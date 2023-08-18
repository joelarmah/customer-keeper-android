package com.github.joelarmah.customerkeeper.cache.mapper

import com.github.joelarmah.customerkeeper.cache.model.CachedCustomer
import com.github.joelarmah.customerkeeper.data.model.CustomerEntity
import javax.inject.Inject

/**
 * Map a [CachedData] instance to and from a [Entity] instance when data is moving between
 * this later and the Data layer
 */
open class CustomerEntityMapper @Inject constructor():
    EntityMapper<CachedCustomer, CustomerEntity> {

    /**
     * Map a [Entity] instance to a [Cache] instance
     */
    override fun mapToCached(type: CustomerEntity): CachedCustomer {
        return CachedCustomer(type.id, type.name, type.title, type.avatar)
    }

    /**
     * Map a [Cache] instance to a [Entity] instance
     */
    override fun mapFromCached(type: CachedCustomer): CustomerEntity {
        return CustomerEntity(type.id, type.name, type.title, type.avatar)
    }

}