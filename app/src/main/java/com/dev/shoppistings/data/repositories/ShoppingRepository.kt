package com.dev.shoppistings.data.repositories

import com.dev.shoppistings.data.db.ShoppingDatabase
import com.dev.shoppistings.data.db.entities.ShoppingItem

class ShoppingRepository (private val db : ShoppingDatabase)
{
    // ViewModel can call the methods from repository

    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}