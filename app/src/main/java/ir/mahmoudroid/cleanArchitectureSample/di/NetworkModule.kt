package ir.mahmoudroid.cleanArchitectureSample.di

import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


const val OK_HTTP = "OK_HTTP"
const val READ_TIMEOUT = "READ_TIMEOUT"
const val WRITE_TIMEOUT = "WRITE_TIMEOUT"
const val CONNECTION_TIMEOUT = "CONNECTION_TIMEOUT"

val networkModule = module {

    single(named(READ_TIMEOUT)) { 30 * 1000 }
    single(named(WRITE_TIMEOUT)) { 10 * 1000 }
    single(named(CONNECTION_TIMEOUT)) { 10 * 1000 }

    factory<Interceptor> {
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.HEADERS)
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    factory(named("OK_HTTP")) {
        OkHttpClient.Builder()
            //.readTimeout(get(named(READ_TIMEOUT)), TimeUnit.MILLISECONDS)
            //.writeTimeout(get(named(WRITE_TIMEOUT)), TimeUnit.MILLISECONDS)
            //.connectTimeout(get(named(CONNECTION_TIMEOUT)), TimeUnit.MILLISECONDS)
            .readTimeout(30 * 1000 , TimeUnit.MILLISECONDS)
            .writeTimeout(10 * 1000, TimeUnit.MILLISECONDS)
            .connectTimeout(10 * 1000, TimeUnit.MILLISECONDS)
            .addInterceptor(get<Interceptor>())
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get(named(OK_HTTP)))
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .build()
    }

}
