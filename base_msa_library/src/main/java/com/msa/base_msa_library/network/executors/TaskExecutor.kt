

@file:Suppress("unused")

package com.msa.base_msa_library.network.executors

import androidx.annotation.RestrictTo



/**
 * A task executor that can divide tasks into logical groups.
 *
 *
 * It holds a collection a executors for each group of task.
 *
 *
 * TODO: Don't use this from outside, we don't know what the API will look like yet.
 * @hide
 */

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
internal abstract class TaskExecutor {

  /**
   * Returns true if the current thread is the main thread, false otherwise.
   *
   * @return true if we are on the main thread, false otherwise.
   */
  abstract val isMainThread: Boolean

  /**
   * Executes the given task in the disk IO thread pool.
   *
   * @param runnable The runnable to run in the disk IO thread pool.
   */
  abstract fun executeOnDiskIO(runnable: Runnable)

  /**
   * Posts the given task to the main thread.
   *
   * @param runnable The runnable to run on the main thread.
   */
  abstract fun postToMainThread(runnable: Runnable, duration: Long)

  /**
   * Executes the given task on the main thread.
   *
   *
   * If the current thread is a main thread, immediately runs the given runnable.
   *
   * @param runnable The runnable to run on the main thread.
   */
  fun executeOnMainThread(runnable: Runnable, duration: Long) {
    if (isMainThread) {
      runnable.run()
    } else {
      postToMainThread(runnable, duration)
    }
  }
}
