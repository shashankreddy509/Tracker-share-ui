package com.shashank.expense.tracker

import com.shashank.expense.tracker.cache.Database
import com.shashank.expense.tracker.cache.DatabaseDriverFactory
import com.shashank.expense.tracker.cache.Transactions

class TrackerSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)

    suspend fun getTransactions(): List<Transactions> {
        return database.getAllTransactions()
    }
}