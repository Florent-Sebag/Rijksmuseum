package sebag.florent.data.di

import org.koin.dsl.module
import sebag.florent.data.mappers.ArtRepositoryMapper
import sebag.florent.data.mappers.ArtRepositoryMapperImpl
import sebag.florent.data.repositories.ArtRepositoryImpl
import sebag.florent.domain.repositories.ArtRepository

val RepositoryModule = module {

    single<ArtRepositoryMapper> { ArtRepositoryMapperImpl() }

    single<ArtRepository> { ArtRepositoryImpl(get(), get()) }
}