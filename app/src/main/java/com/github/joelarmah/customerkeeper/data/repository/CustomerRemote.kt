package com.github.joelarmah.customerkeeper.data.repository

import com.github.joelarmah.customerkeeper.data.model.CustomerEntity

interface CustomerRemote {

    /**
     * Retrieve a list of customers, from the cache
     */
    suspend fun getCustomers(): List<CustomerEntity>

    suspend fun getCustomer(customerId: Long): CustomerEntity
}