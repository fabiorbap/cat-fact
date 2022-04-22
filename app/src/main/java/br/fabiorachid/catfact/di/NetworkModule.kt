package br.fabiorachid.catfact.di

import br.fabiorachid.catfact.model.ApiInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://catfact.ninja/"
const val TIMEOUT_DURATION = 10L

val networkModule = module {

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
    }

    single<OkHttpClient> {
        OkHttpClient.Builder().apply {
            connectTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
            readTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
            writeTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
        }
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(ApiInterface::class.java) }

}