package com.github.joelarmah.customerkeeper.domain.repository

import com.github.joelarmah.customerkeeper.domain.model.Customer
import kotlinx.coroutines.flow.Flow

interface CustomerRepository {

    suspend fun clearCustomers()

    suspend fun saveCustomers(customers: List<Customer>)

    suspend fun getCustomers(): Flow<List<Customer>>

}