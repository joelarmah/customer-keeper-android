package com.github.joelarmah.customerkeeper.cache.constants

object CacheConstants {
    const val DB_NAME = "customer_keeper.db"
    const val CUSTOMER_TABLE_NAME = "customer"

    const val QUERY_CUSTOMERS = "SELECT * FROM $CUSTOMER_TABLE_NAME"
    const val GET_CUSTOMER = "SELECT * FROM $CUSTOMER_TABLE_NAME WHERE  id = :id"
    const val DELETE_ALL_CUSTOMERS = "DELETE FROM $CUSTOMER_TABLE_NAME"
}