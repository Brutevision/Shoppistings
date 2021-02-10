package com.dev.shoppistings.UI.ShoppingList

import com.dev.shoppistings.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked (item:ShoppingItem)
}