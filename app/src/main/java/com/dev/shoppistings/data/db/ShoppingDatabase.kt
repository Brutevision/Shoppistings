package com.dev.shoppistings.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dev.shoppistings.data.db.entities.ShoppingItem

@Database(
        entities = [ShoppingItem::class], // Passed in a array if multiple entities
        version = 1 //if we change anything in DB, we've to update this version
)
abstract class ShoppingDatabase : RoomDatabase() {
    abstract fun getShoppingDao(): ShoppingDao

    /**
     * This function will make sure that we can access our DB operations from inside the DB class
     */
    companion object {
        /**
         * writes to this instance will be made visible immediately to other threads.
         * We need to do this so that only one thread is writing to the instance at a time.
         * Otherwise multiple threads will initialise instance variable and multiple instances of same DB will be created.
         * We don't want it here :)
         */
        @Volatile

        private var instance: ShoppingDatabase? = null;
        private val LOCK = Any()

        /**
         * Called everytime when we create an instance of our DB and it will return our instance.
         * IF our instance is NULL, it will call that synchronized block{} and no other thread can set the instance while code with this block is executing.
         * So in this block{} we again check for nullability->createInstance by calling createDB fun.
         * And set the created result equals to 'it'
         */
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK)
        {
            instance ?: createDatabase(context).also { instance = it }
        }

        //Method to instantiate our DB
        private fun createDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext, ShoppingDatabase::class.java, "ShoppingDB.db").build()
    }
}