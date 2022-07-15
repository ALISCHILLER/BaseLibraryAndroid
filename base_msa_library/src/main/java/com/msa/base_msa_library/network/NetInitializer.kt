package com.msa.base_msa_library.network

import com.msa.base_msa_library.network.operators.NetOperator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import okio.Timeout
import kotlin.coroutines.CoroutineContext

/**
 * @author Ali Soleimani
 *
 * SandwichInitializer is a rules and strategies initializer of the network response.
 */
public object NetInitializer {

  /**
   *
   * determines the success code range of network responses.
   *
   * if a network request is successful and the response code is in the [successCodeRange],
   * its response will be a [ApiResponse.Success].
   *
   * if a network request is successful but out of the [successCodeRange] or failure,
   * the response will be a [ApiResponse.Failure.Error].
   * */
  @JvmStatic
  public var successCodeRange: IntRange = 200..299

  /**
   * " "
   *
   * A global Operator that operates on [ApiResponse]s globally on each response.
   *
   * [ApiResponseOperator] which allows you to handle success and error response instead of
   * the [ApiResponse.onSuccess], [ApiResponse.onError], [ApiResponse.onException] transformers.
   * [ApiResponseSuspendOperator] can be used for suspension scope.
   *
   * Via setting a [netOperator], we don't need to set operator for every [ApiResponse].
   */
  @JvmStatic
  public var netOperator: NetOperator? = null

  /**
   *
   * A [CoroutineScope] for executing and operating the overall Retrofit network requests.
   */
  @JvmSynthetic
  public var sandwichScope: CoroutineScope = CoroutineScope(Dispatchers.IO)

  /**
   *
   * A [CoroutineContext] for operating the [netOperator] when it extends
   */
  @Deprecated(
    message = "sandwichOperatorContext has been deprecated. Use `sandwichScope` instead.",
    replaceWith = ReplaceWith(expression = "SandwichInitializer.sandwichScope")
  )
  @JvmSynthetic
  public var sandwichOperatorContext: CoroutineContext = sandwichScope.coroutineContext

  /**
   *
   * Returns a timeout that spans the entire call: resolving DNS, connecting, writing the request
   * body, server processing, and reading the response body. If the call requires redirects or
   * retries all must complete within one timeout period.
   */
  @JvmStatic
  public var sandwichTimeout: Timeout? = null
}
