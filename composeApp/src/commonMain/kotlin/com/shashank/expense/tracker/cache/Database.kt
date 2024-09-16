package com.shashank.expense.tracker.cache

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = TrackerDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.trackerDatabaseQueries

    internal fun getAllTransactions(): List<Transactions> {
        return dbQuery.selectAllTransactions().executeAsList()
    }
}