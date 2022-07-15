

package com.msa.base_msa_library.network

import kotlinx.coroutines.delay

/**
 * Retry the given function [execute] specified number of times with delays
 * if the [execute] returns [ApiResponse.Failure].
 *
 * @param retry Retry times if the given function [execute] returns [ApiResponse.Failure].
 * @param timeMillis Milli seconds delay before retrying the given function [execute].
 * @param execute An executable lambda which returns [ApiResponse].
 */
public suspend inline fun <T : Any> retry(
  retry: Int = 1,
  timeMillis: Long = 1000,
  execute: () -> ApiResponse<T>
): ApiResponse<T> {
  repeat(times = retry) {
    when (val response = execute.invoke()) {
      is ApiResponse.Success<T> -> return response
      else -> delay(timeMillis)
    }
  }
  return execute.invoke()
}
