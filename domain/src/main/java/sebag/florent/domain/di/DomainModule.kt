package sebag.florent.domain.di

import org.koin.dsl.module
import sebag.florent.domain.usecases.GetArtDetailsUseCase
import sebag.florent.domain.usecases.GetArtDetailsUseCaseImpl
import sebag.florent.domain.usecases.GetArtListUseCase
import sebag.florent.domain.usecases.GetArtListUseCaseImpl

val DomainModule = module {

    factory<GetArtListUseCase> { GetArtListUseCaseImpl(get()) }

    factory<GetArtDetailsUseCase> { GetArtDetailsUseCaseImpl(get()) }
}