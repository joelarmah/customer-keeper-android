package com.github.joelarmah.customerkeeper.cache

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.joelarmah.customerkeeper.cache.db.CustomerKeeperDatabase
import com.github.joelarmah.customerkeeper.cache.mapper.CustomerEntityMapper
import com.github.joelarmah.customerkeeper.cache.utils.CacheBaseTest
import com.github.joelarmah.customerkeeper.cache.utils.CachePreferencesHelper
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [30])
class CustomerCacheImplTest: CacheBaseTest() {

    private val customerEntityMapper = CustomerEntityMapper()
    private lateinit var preferencesHelper: CachePreferencesHelper
    private lateinit var customerKeeperDatabase: CustomerKeeperDatabase
    lateinit var sut: CustomerCacheImpl

    @Before
    override fun setup() {
        super.setup()
        preferencesHelper = CachePreferencesHelper(context)
        customerKeeperDatabase = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), CustomerKeeperDatabase::class.java).allowMainThreadQueries().build()
        sut = CustomerCacheImpl(customerKeeperDatabase, customerEntityMapper, preferencesHelper)
    }

//    @Test
//    fun `getDatabase should return customer keeper database`() {
//
//    }
//
//    @Test
//    fun `clearCustomers`() {
//
//    }
//
//    @Test
//    fun `saveCustomers`() {
//    }

    @Test
    fun `getCustomers should return success from local room cache with empty list`() {
        runTest {
            val customers = sut.getCustomers()
            assertTrue(customers.isEmpty())
        }
    }

//    @Test
//    fun isCached() {
//    }
//
//    @Test
//    fun setLastCacheTime() {
//    }
//
//    @Test
//    fun isExpired() {
//    }
}