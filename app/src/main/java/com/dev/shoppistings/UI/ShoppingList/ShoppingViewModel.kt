package com.dev.shoppistings.UI.ShoppingList

import androidx.lifecycle.ViewModel
import com.dev.shoppistings.data.db.entities.ShoppingItem
import com.dev.shoppistings.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// We are passing our ShoppingRepository as a parameter to this viewModel class
class ShoppingViewModel(private val repository: ShoppingRepository): ViewModel()
{
    // Here we want to call our repository methods

    fun upsert(item:ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item:ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    //This is only a READ operation so coroutine not required
    fun getAllShoppingItems() = repository.getAllShoppingItems()
}

/**
 * Now we'll create an instance of this viewModel inside our MainActivity.
 */