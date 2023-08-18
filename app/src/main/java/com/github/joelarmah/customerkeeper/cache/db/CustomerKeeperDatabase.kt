package com.github.joelarmah.customerkeeper.cache.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.joelarmah.customerkeeper.cache.dao.CachedCustomerDao
import com.github.joelarmah.customerkeeper.cache.constants.CacheConstants.DB_NAME
import com.github.joelarmah.customerkeeper.cache.model.CachedCustomer
import javax.inject.Inject

@Database(
    entities = [CachedCustomer::class],
    version = 1
)
abstract class CustomerKeeperDatabase : RoomDatabase() {

    abstract fun cachedCustomerDao(): CachedCustomerDao

    companion object {
        @Volatile
        private var INSTANCE: CustomerKeeperDatabase? = null

        fun getInstance(context: Context): CustomerKeeperDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            CustomerKeeperDatabase::class.java,
            DB_NAME
        ).build()
    }

}