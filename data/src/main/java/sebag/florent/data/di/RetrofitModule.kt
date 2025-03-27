package sebag.florent.data.di

import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sebag.florent.data.source.remote.api.ArtApiService

val RetrofitModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://www.rijksmuseum.nl/api/en/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
            .create(ArtApiService::class.java)
    }
}