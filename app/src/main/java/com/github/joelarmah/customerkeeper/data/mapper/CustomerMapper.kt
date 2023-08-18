package com.github.joelarmah.customerkeeper.data.mapper

import com.github.joelarmah.customerkeeper.data.model.CustomerEntity
import com.github.joelarmah.customerkeeper.domain.model.Customer
import javax.inject.Inject

open class CustomerMapper @Inject constructor(): Mapper<CustomerEntity, Customer> {

    /**
     * Map a [CustomerEntity] instance to a [Customer] instance
     */
    override fun mapFromEntity(type: CustomerEntity): Customer {
        return Customer(type.id, type.name, type.title, type.avatar)
    }

    /**
     * Map a [Customer] instance to a [CustomerEntity] instance
     */
    override fun mapToEntity(type: Customer): CustomerEntity {
        return CustomerEntity(type.id, type.name, type.title, type.avatar)
    }

}