

@file:Suppress("unused")

package com.msa.base_msa_library.network.adapters


import com.msa.base_msa_library.network.ApiResponse
import com.msa.base_msa_library.network.NetInitializer
import com.msa.base_msa_library.network.adapters.internal.ApiResponseCallAdapter
import com.msa.base_msa_library.network.adapters.internal.ApiResponseDeferredCallAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 *
 *
 * CoroutinesResponseCallAdapterFactory is an coroutines call adapter factory for creating [ApiResponse].
 *
 * Adding this class to [Retrofit] allows you to return on [ApiResponse] from service method.
 *
 * ```
 * @GET("DisneyPosters.json")
 * suspend fun fetchDisneyPosterList(): ApiResponse<List<Poster>>
 * ```
 */
public class ApiResponseCallAdapterFactory private constructor(
  private val coroutineScope: CoroutineScope
) : CallAdapter.Factory() {

  override fun get(
    returnType: Type,
    annotations: Array<Annotation>,
    retrofit: Retrofit,
  ): CallAdapter<*, *>? {
    when (getRawType(returnType)) {
      Call::class.java -> {
        val callType = getParameterUpperBound(0, returnType as ParameterizedType)
        val rawType = getRawType(callType)
        if (rawType != ApiResponse::class.java) {
          return null
        }

        val resultType = getParameterUpperBound(0, callType as ParameterizedType)
        return ApiResponseCallAdapter(resultType, coroutineScope)
      }
      Deferred::class.java -> {
        val callType = getParameterUpperBound(0, returnType as ParameterizedType)
        val rawType = getRawType(callType)
        if (rawType != ApiResponse::class.java) {
          return null
        }

        val resultType = getParameterUpperBound(0, callType as ParameterizedType)
        return ApiResponseDeferredCallAdapter<Any>(resultType, coroutineScope)
      }
      else -> return null
    }
  }

  public companion object {
    @JvmStatic
    public fun create(
      coroutineScope: CoroutineScope = NetInitializer.sandwichScope
    ): ApiResponseCallAdapterFactory = ApiResponseCallAdapterFactory(coroutineScope)
  }
}
