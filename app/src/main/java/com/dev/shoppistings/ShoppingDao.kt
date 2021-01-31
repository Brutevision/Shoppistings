package com.dev.shoppistings

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShoppingDao {

    /**
     * In SQL it does not allow to write to the dataBase in main thread.
     * So we'll call these functions asynchronously (in Kotlin we can use coroutines)
     * To mark these functions as the function to be executed asynchronously, we write 'suspend' keyword.
     */

    // Insert new item or replace existing item
    @Insert(onConflict = OnConflictStrategy.REPLACE) //Replaces item of same ID
    suspend fun upsert (item: ShoppingItem)

    @Delete
    suspend fun delete (item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems (): LiveData<List<ShoppingItem>>

    /**
     * LiveData<List<ShoppingItem>>
     *     return type of this 'LiveData' object is our ShoppingItems list
     */
}