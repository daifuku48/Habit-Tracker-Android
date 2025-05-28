package com.danilincorporated.habit_tracker_android.extenstion

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

inline fun <reified T, R> List<T>?.mapToImmutable(
    action: (T) -> R,
): ImmutableList<R> {
    if (this == null) return persistentListOf()
    val persistentListBuilder = persistentListOf<R>().builder()
    for (item in this) {
        persistentListBuilder.add(action(item))
    }
    return persistentListBuilder.build()
}

inline fun <reified T, R> List<T>?.mapToImmutableNotNull(
    action: (T) -> R?,
): ImmutableList<R> {
    if (this == null) return persistentListOf()
    val persistentListBuilder = persistentListOf<R>().builder()
    for (item in this) {
        persistentListBuilder.add(action(item) ?: continue)
    }
    return persistentListBuilder.build()
}

inline fun <reified T, R> List<T>?.mapToImmutableIndexed(
    action: (Int, T) -> R,
): ImmutableList<R> {
    if (this == null) return persistentListOf()
    val persistentListBuilder = persistentListOf<R>().builder()
    forEachIndexed { index, item ->
        val mappedItem = action(index, item)
        persistentListBuilder.add(mappedItem)
    }
    return persistentListBuilder.build()
}

inline fun <reified T> buildImmutableList(
    action: PersistentList.Builder<T>.() -> Unit,
): ImmutableList<T> {
    val builder = persistentListOf<T>().builder()
    builder.action()
    return builder.build()
}
