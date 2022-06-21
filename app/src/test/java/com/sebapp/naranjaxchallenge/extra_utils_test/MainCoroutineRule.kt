package com.sebapp.naranjaxchallenge.extra_utils_test

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import okhttp3.Dispatcher
import org.junit.rules.TestWatcher
import org.junit.runner.Description

/**
 * 21,junio,2022
 *
 * Created by
 * Sebastian Pratto (Misiones, Arg.)
 */

class MainCoroutineRule (val dispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()):
    TestWatcher(), TestCoroutineScope by TestCoroutineScope(dispatcher) {

    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(dispatcher)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        cleanupTestCoroutines()
        Dispatchers.resetMain()
    }
}