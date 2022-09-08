package com.android.newsfeed

import com.android.newsfeed.utils.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher

class TestDispatcherProvider : DispatcherProvider {
    override val io: CoroutineDispatcher
        get() = UnconfinedTestDispatcher()
}
