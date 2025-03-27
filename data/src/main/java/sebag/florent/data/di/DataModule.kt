package sebag.florent.data.di

import org.koin.dsl.module

val DataModule = module {
    includes(
        RepositoryModule,
        OkHttpModule,
        RetrofitModule
    )
}