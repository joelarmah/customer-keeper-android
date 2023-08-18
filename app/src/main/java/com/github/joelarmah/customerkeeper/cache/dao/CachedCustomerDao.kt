package com.github.joelarmah.customerkeeper.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.joelarmah.customerkeeper.cache.constants.CacheConstants.DELETE_ALL_CUSTOMERS
import com.github.joelarmah.customerkeeper.cache.constants.CacheConstants.QUERY_CUSTOMERS
import com.github.joelarmah.customerkeeper.cache.model.CachedCustomer

@Dao
abstract class CachedCustomerDao {

    @Query(QUERY_CUSTOMERS)
    abstract fun getCustomers(): List<CachedCustomer>

    @Query(DELETE_ALL_CUSTOMERS)
    abstract fun clearCustomers()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertCustomer(cachedCustomer: CachedCustomer)

}