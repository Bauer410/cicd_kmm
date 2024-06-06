package at.bauercloud.pokedex.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import at.bauercloud.Database
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<SqlDriver> { NativeSqliteDriver(Database.Schema, "database.db") }

    single { Darwin.create() }
}

