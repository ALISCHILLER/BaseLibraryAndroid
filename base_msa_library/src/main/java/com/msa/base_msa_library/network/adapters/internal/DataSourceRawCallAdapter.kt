

package com.msa.base_msa_library.network.adapters.internal

import com.msa.base_msa_library.network.DataSource
import com.msa.base_msa_library.network.ResponseDataSource
import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

/**
 *
 *
 * DataSourceCallAdapter is an call adapter for creating [DataSource] from service method.
 *
 * request API network call asynchronously and returns [DataSource].
 */
internal class DataSourceRawCallAdapter<R> constructor(
  private val responseType: Type
) : CallAdapter<R, DataSource<R>> {

  override fun responseType(): Type {
    return responseType
  }

  override fun adapt(call: Call<R>): DataSource<R> {
    val responseDataSource: ResponseDataSource<R> = ResponseDataSource()
    return responseDataSource.combine(call, null)
  }
}
