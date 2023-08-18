package com.github.joelarmah.customerkeeper.data.repository

import com.github.joelarmah.customerkeeper.data.model.CustomerEntity

interface CustomerCache {

    suspend fun clearCustomers()

    /**
     * Save a given list of Customers to the cache.
     */
    suspend fun saveCustomers(customers: List<CustomerEntity>)

    /**
     * Retrieve a list of Customers, from the cache.
     */
    suspend fun getCustomers(): List<CustomerEntity>

    /**
     * Check whether there is a list of customers stored in the cache.
     *
     * @return true if the list is cached, otherwise false
     */
    suspend fun isCached(): Boolean

    /**
     * Set a point in time at when the cache was last updated.
     *
     * @param lastCache the point in time at when the cache was last updated
     */
    suspend fun setLastCacheTime(lastCache: Long)

    /**
     * Check if the cache is expired.
     *
     * @return true if the cache is expired, otherwise false
     */
    suspend fun isExpired(): Boolean

}