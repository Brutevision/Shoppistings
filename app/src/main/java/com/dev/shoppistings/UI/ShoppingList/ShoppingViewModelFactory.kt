package com.dev.shoppistings.UI.ShoppingList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dev.shoppistings.data.repositories.ShoppingRepository

class ShoppingViewModelFactory(private val repository: ShoppingRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}