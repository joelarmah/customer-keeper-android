package com.github.joelarmah.customerkeeper.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.joelarmah.customerkeeper.cache.constants.CacheConstants.CUSTOMER_TABLE_NAME

@Entity(tableName = CUSTOMER_TABLE_NAME)
data class CachedCustomer (
    @PrimaryKey
    var id: Long,
    val name: String,
    val title: String,
    val avatar: String
)