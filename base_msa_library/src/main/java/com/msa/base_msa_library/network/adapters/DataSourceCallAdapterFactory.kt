

package com.msa.base_msa_library.network.adapters

import com.msa.base_msa_library.network.DataSource
import com.msa.base_msa_library.network.adapters.internal.DataSourceCallAdapter
import com.msa.base_msa_library.network.adapters.internal.DataSourceRawCallAdapter
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 *
 *
 * DataSourceCallAdapterFactory is an call adapter factory for creating [DataSource].
 *
 * Adding this class to [Retrofit] allows you to return on [DataSource] from service method.
 *
 * ```
 * @GET("DisneyPosters.json")
 * fun fetchDisneyPosterList(): DataSource<List<Poster>>
 * ```
 */
public class DataSourceCallAdapterFactory private constructor() : CallAdapter.Factory() {

  override fun get(
    returnType: Type,
    annotations: Array<Annotation>,
    retrofit: Retrofit
  ): CallAdapter<*, *>? {
    when (getRawType(returnType)) {
      DataSource::class.java -> {
        val resultType = getParameterUpperBound(0, returnType as ParameterizedType)
        return DataSourceRawCallAdapter<Type>(resultType)
      }
      Call::class.java -> {
        val callType = getParameterUpperBound(0, returnType as ParameterizedType)
        val rawType = getRawType(callType)
        if (rawType != DataSource::class.java) {
          return null
        }
        val resultType = getParameterUpperBound(0, callType as ParameterizedType)
        return DataSourceCallAdapter(resultType)
      }
      else -> return null
    }
  }

  public companion object {
    @JvmStatic
    public fun create(): DataSourceCallAdapterFactory = DataSourceCallAdapterFactory()
  }
}
