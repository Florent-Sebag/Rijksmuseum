package sebag.florent.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import sebag.florent.presentation.features.details.DetailsViewModel
import sebag.florent.presentation.features.home.HomeViewModel

val PresentationModule = module {

    viewModel { HomeViewModel(get()) }
    viewModel { DetailsViewModel(get(), get()) }
}