

package com.msa.base_msa_library.network

/**
 * @author ALI Soleimani
 *
 * A mapper interface for mapping [ApiResponse.Failure.Error] response as a custom [V] instance model.
 * [ApiResponse.Failure.Error] به عنوان یک مدل نمونه سفارشی [V].
 *
 */
public fun interface ApiErrorModelMapper<V> {

  /**
   * maps the [ApiResponse.Failure.Error] to the [V] using the mapper.
   *
   * @param apiErrorResponse The [ApiResponse.Failure.Error] error response from the network request.
   * apiErrorResponse پاسخ خطای از درخواست شبکه  [ApiResponse.Failure.Error].
   * @return A custom [V] error response model.
   * @return یک مدل پاسخ خطای سفارشی [V]
   */
  public fun map(apiErrorResponse: ApiResponse.Failure.Error<*>): V
}
