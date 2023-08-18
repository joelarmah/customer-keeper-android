package com.github.joelarmah.customerkeeper.cache

import com.github.joelarmah.customerkeeper.cache.db.CustomerKeeperDatabase
import com.github.joelarmah.customerkeeper.cache.mapper.CustomerEntityMapper
import com.github.joelarmah.customerkeeper.cache.utils.CachePreferencesHelper
import com.github.joelarmah.customerkeeper.data.model.CustomerEntity
import com.github.joelarmah.customerkeeper.data.repository.CustomerCache
import javax.inject.Inject

class CustomerCacheImpl @Inject constructor(private val customerKeeperDatabase: CustomerKeeperDatabase,
                                            private val entityMapper: CustomerEntityMapper,
                                            private val cachePreferencesHelper: CachePreferencesHelper
) :
    CustomerCache {

    companion object {
        private const val EXPIRATION_TIME = (60 * 10 * 1000).toLong()

    }
    /**
     * Retrieve an instance from the database, used for tests.
     */
    internal fun getDatabase(): CustomerKeeperDatabase {
        return customerKeeperDatabase
    }

    /**
     * Remove all the data from all the tables in the database.
     */
    override suspend fun clearCustomers() {
        customerKeeperDatabase.cachedCustomerDao().clearCustomers()
    }

    /**
     * Save the given list of [CustomerEntity] instances to the database.
     */
    override suspend fun saveCustomers(customers: List<CustomerEntity>) {
        customers.forEach {
                customerKeeperDatabase.cachedCustomerDao().insertCustomer(
                    entityMapper.mapToCached(it))
            }
    }

    /**
     * Retrieve a list of [CustomerEntity] instances from the database.
     */
    override suspend fun getCustomers(): List<CustomerEntity> {
        return  customerKeeperDatabase.cachedCustomerDao().getCustomers().map {
            entityMapper.mapFromCached(it)
        }
    }

    /**
     * Check whether there are instances of [CachedCustomer] stored in the cache.
     */
    override suspend fun isCached(): Boolean {
        return customerKeeperDatabase.cachedCustomerDao().getCustomers().isNotEmpty()
    }

    /**
     * Set a point in time at when the cache was last updated.
     */
    override suspend fun setLastCacheTime(lastCache: Long) {
        cachePreferencesHelper.lastCacheTime = lastCache
    }

    /**
     * Check whether the current cached data exceeds the defined [EXPIRATION_TIME] time.
     */
    override suspend fun isExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = this.getLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }

    /**
     * Get in millis, the last time the cache was accessed.
     */
    private fun getLastCacheUpdateTimeMillis(): Long {
        return cachePreferencesHelper.lastCacheTime
    }

}