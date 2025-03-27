package sebag.florent.presentation.di

import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import sebag.florent.presentation.features.home.HomeViewModel

val PresentationModule = module {
    includes(
        ViewModelModule
    )
}