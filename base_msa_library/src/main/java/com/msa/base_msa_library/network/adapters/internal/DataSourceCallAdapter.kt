

package com.msa.base_msa_library.network.adapters.internal

import com.msa.base_msa_library.network.DataSource

import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

/**
 *
 *
 * CoroutinesDataSourceCallAdapter is an coroutines call adapter for creating [DataSource] from service method.
 *
 * request API network call asynchronously and returns [DataSource].
 */
internal class DataSourceCallAdapter constructor(
  private val responseType: Type
) : CallAdapter<Type, Call<DataSource<Type>>> {

  override fun responseType(): Type {
    return responseType
  }

  override fun adapt(call: Call<Type>): Call<DataSource<Type>> {
    return DataSourceCallDelegate(call)
  }
}
