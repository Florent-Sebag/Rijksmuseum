package sebag.florent.rijksmuseum

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import sebag.florent.data.di.DataModule
import sebag.florent.domain.di.DomainModule
import sebag.florent.presentation.di.PresentationModule

class RijksmuseumApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@RijksmuseumApp)
            modules(
                DataModule,
                DomainModule,
                PresentationModule
            )
        }
    }
}