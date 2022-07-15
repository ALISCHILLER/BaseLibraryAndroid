

package com.msa.base_msa_library.network

/**
 * 
 *
 * A mapper interface for mapping [ApiResponse.Success] response as a custom [V] instance model.
 *
 *
 */
public fun interface ApiSuccessModelMapper<T, V> {

  /**
   * maps the [ApiResponse.Success] to the [V] using the mapper.
   *
   * @param apiErrorResponse The [ApiResponse.Success] error response from the network request.
   * @return A custom [V] success response model.
   */
  public fun map(apiErrorResponse: ApiResponse.Success<T>): V
}
