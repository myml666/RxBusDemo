package com.itfitness.rxbusdemo.rxbus

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

/**
 *
 * @ProjectName:    RxBusDemo
 * @Package:        com.itfitness.rxbusdemo.rxbus
 * @ClassName:      RxBus
 * @Description:     java类作用描述 ：
 * @Author:         作者名：lml
 * @CreateDate:     2019/6/14 17:15
 * @UpdateUser:     更新者：
 * @UpdateDate:     2019/6/14 17:15
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */
object RxBus {
    private var mBus:Subject<Any> = PublishSubject.create<Any>().toSerialized()
    fun post(any: Any){
        mBus.onNext(any)
    }
    fun <T> toObservable(clazz:Class<T>):Observable<T>{
        return mBus.ofType(clazz)
    }
    fun toObservable():Observable<Any>{
        return mBus
    }
}