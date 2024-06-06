package at.bauercloud.pokedex.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import at.bauercloud.Database
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<SqlDriver> {
        AndroidSqliteDriver(
            Database.Schema,
            get(),
            "database.db"
        )
    }
}