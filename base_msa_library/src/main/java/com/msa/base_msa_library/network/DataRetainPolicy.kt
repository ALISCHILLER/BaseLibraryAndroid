

package com.msa.base_msa_library.network

/**
 * 
 *
 * [DataRetainPolicy] is a policy for retaining data on the internal storage
 * when the same request is called from [ResponseDataSource].
 */
public enum class DataRetainPolicy {
  // Retain the fetched data on the memory storage temporarily.
  // If request again, returns the retained data instead of re-fetching from the network.
  RETAIN,

  // Re-fetch data from the network every time.
  NO_RETAIN
}
