package sebag.florent.data.di

import okhttp3.OkHttpClient
import org.koin.dsl.module
import sebag.florent.data.interceptor.OkInterceptor

val OkHttpModule = module {

    single { OkInterceptor("rIl6yb6x") }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<OkInterceptor>())
            .build()
    }
}