

package com.msa.base_msa_library.network.disposables

/**
 * @author Ali Soleimani
 *
 * A definition for canceling when works should be disposed.
 */
public interface Disposable {

  /** dispose the resource. */
  public fun dispose()

  /** returns true if this resource has been disposed. */
  public fun isDisposed(): Boolean
}
