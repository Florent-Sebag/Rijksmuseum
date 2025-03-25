package sebag.florent.data.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class OkInterceptor(private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = chain.request().url()

        val newUrl = originalUrl.newBuilder()
            .addQueryParameter("key", apiKey)
            .build()

        val newRequest = originalRequest.newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }
}