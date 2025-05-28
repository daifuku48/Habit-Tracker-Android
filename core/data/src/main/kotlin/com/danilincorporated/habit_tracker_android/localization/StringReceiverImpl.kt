package com.danilincorporated.habit_tracker_android.localization

import com.danilincorporated.habit_tracker_android.dao.LocalizationDao
import com.danilincorporated.habit_tracker_android.model.DomainLanguage
import com.danilincorporated.habit_tracker_android.model.LanguageEntity
import com.danilincorporated.habit_tracker_android.model.LocaleEntity
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

internal class StringReceiverImpl(
    private val localesDao: LocalizationDao,
) : StringReceiver {

    private var currentLanguage: String = DEFAULT_CURRENT_LANGUAGE
    private val localizedStrings = mutableMapOf<String, MutableMap<String, String>>()
    private val _textUpdated = MutableSharedFlow<Unit>(replay = 1)
    override val textUpdated = _textUpdated.asSharedFlow()

    override suspend fun getLanguages(): List<DomainLanguage> {
        return listOf()
    }

    override suspend fun getString(key: String): String {
        return localizedStrings[currentLanguage]?.get(key) ?: key
    }

    override suspend fun loadStrings() {
        try {
            this.getLocalCopy()
            //TODO Create implementation in the backend 
//            val timestamp = appSettingsRepository.getLastRetrievedTimestamp()
//            val data = preLoginRepository.retrieveLocales(timestamp).get()
//            val data =
//            data.locales.forEach { locale ->
//                localizedStrings[locale.key] = locale.value.toMutableMap()
//            }
//            appSettingsRepository.updateLastRetrievedTimestamp(data.timestamp)
//            saveLocalCopy(data.languages)
            saveLocalCopy(
                listOf(
                    DomainLanguage(
                        languageId = "1",
                        emojiImageCode = "fff",
                        placeholder = "flfflflfl"
                    )
                )
            )
            this._textUpdated.tryEmit(Unit)
        } catch (e: Exception) {
            if (localizedStrings.isEmpty()) throw e
        }
    }

    override suspend fun changeCurrentLanguage(newLanguage: String): Boolean {
        val languageFound =
            localizedStrings[newLanguage]?.isEmpty() == false
        if (languageFound) {
            this.currentLanguage = newLanguage
            this.saveNewPreferredLanguage()
            this._textUpdated.tryEmit(Unit)
        }
        return languageFound
    }

    override suspend fun getCurrentLanguage(): String {
        return currentLanguage
    }

    private suspend fun saveNewPreferredLanguage() {
        localesDao.resetPreferredLanguage()
        localesDao.setPreferredLanguage(currentLanguage)
    }

    private suspend fun getLocalCopy() {
        val languages = localesDao.getLanguages()
        localesDao.getLocales().forEach { locale ->
            if (languages.any { it.languageId == locale.languageId }) {
                localizedStrings.getOrPut(locale.languageId) { mutableMapOf() }[locale.placeholder] =
                    locale.value
            }
        }
        this.currentLanguage = languages.find { it.isPreferred }?.languageId ?: DEFAULT_CURRENT_LANGUAGE
    }

    private suspend fun saveLocalCopy(list: List<DomainLanguage>) {
        localesDao.removeLocales()
        localesDao.removeLanguages()
        val locales = mutableListOf<LocaleEntity>()
        val languages = mutableListOf<LanguageEntity>()
        localizedStrings.forEach { language ->
            val matchingLanguage = list.find { it.languageId == language.key }
            languages.add(
                LanguageEntity(
                    languageId = language.key,
                    isPreferred = currentLanguage == language.key,
                    emojiImageCode = matchingLanguage?.emojiImageCode.orEmpty(),
                    placeholder = matchingLanguage?.placeholder.orEmpty(),
                )
            )
            language.value.forEach { (placeHolder, value) ->
                locales.add(
                    LocaleEntity(
                        placeholder = placeHolder,
                        value = value,
                        languageId = language.key
                    )
                )
            }
        }
        localesDao.setLocales(locales)
        localesDao.setLanguages(languages)
    }

    companion object {
        const val DEFAULT_CURRENT_LANGUAGE = "en"
    }
}