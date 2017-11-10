package com.tlz.rxcommons.bus

import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import java.util.concurrent.TimeUnit

/**
 * Created by tomlezen.
 * Date: 2017/5/22.
 * Time: 下午10:17
 */
internal interface RxBusI {

  fun <T> onEvent(observable: Observable<T>, onNext: (T) -> Unit): Disposable

  fun <T> onEvent(observable: Observable<T>, onNext: (T) -> Unit,
      onError: (Throwable) -> Unit): Disposable

  fun <T> onEvent(tag: Any, onNext: (T) -> Unit): Disposable

  fun <T> onEvent(tag: Any, onNext: (T) -> Unit, onError: (Throwable) -> Unit): Disposable

  fun <T> register(tag: Any): Observable<T>

  fun unregister(tag: Any)

  fun unregister(tag: Any, observable: Observable<*>)

  fun post(content: Any)

  fun postDelay(content: Any, millis: Long): Disposable?

  fun postDelay(content: Any, delay: Long, unit: TimeUnit): Disposable?

  fun post(tag: Any, content: Any)

  fun postDelay(tag: Any, content: Any, millis: Long): Disposable?

  fun postDelay(tag: Any, content: Any, delay: Long, unit: TimeUnit): Disposable?

}