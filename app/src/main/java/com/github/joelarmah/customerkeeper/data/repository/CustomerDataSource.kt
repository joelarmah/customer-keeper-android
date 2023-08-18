package com.github.joelarmah.customerkeeper.data.repository

import com.github.joelarmah.customerkeeper.data.model.CustomerEntity

interface CustomerDataSource {

    suspend fun clearCustomers()

    suspend fun saveCustomers(customers: List<CustomerEntity>)

    suspend fun getCustomers(): List<CustomerEntity>

    suspend fun isCached(): Boolean

}