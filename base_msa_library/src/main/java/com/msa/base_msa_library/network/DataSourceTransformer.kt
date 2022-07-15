

@file:JvmName("DataSourceTransformer")
@file:JvmMultifileClass

package com.msa.base_msa_library.network

/**
 * 
 *
 * Changes an instance of the [DataSource] interface to the [ResponseDataSource].
 */
public fun <T> DataSource<T>.toResponseDataSource(): ResponseDataSource<T> {
  requireNotNull(this is ResponseDataSource)
  return this as ResponseDataSource<T>
}
