package com.github.joelarmah.customerkeeper.cache.utils

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import com.github.joelarmah.customerkeeper.cache.dao.CachedCustomerDao
import com.github.joelarmah.customerkeeper.cache.db.CustomerKeeperDatabase
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import java.io.IOException

abstract class CacheBaseTest {

    @get: Rule
    val testRule = CoroutineTestRule()

    val dispatcher = testRule.dispatcher
    // val exceptionHandler = TestCoroutineExceptionHandler()
    private lateinit var database: CustomerKeeperDatabase
    protected lateinit var customerDao: CachedCustomerDao
    protected lateinit var context: Context

    @Before
    open fun setup() {
        context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, CustomerKeeperDatabase::class.java)
            .allowMainThreadQueries().build()
        customerDao = database.cachedCustomerDao()
    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
        dispatcher.runBlockingTest {
            database.clearAllTables()
        }
        database.close()
    }

}