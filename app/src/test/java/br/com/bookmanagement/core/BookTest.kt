package br.com.bookmanagement.core

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import kotlin.coroutines.CoroutineContext
import kotlin.time.Duration.Companion.milliseconds

@OptIn(ExperimentalCoroutinesApi::class)
abstract class BookTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    open val coroutineRule = CoroutinesMainTestRule()

    protected val dispatcher = StandardTestDispatcher()

    fun coTest(
        context: CoroutineContext = dispatcher,
        dispatchTimeoutMs: Long = 60_000L,
        testBody: suspend TestScope.() -> Unit
    ) {
        runTest(context, timeout = dispatchTimeoutMs.milliseconds, testBody)
    }
}