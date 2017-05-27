package com.cinema_ticketing_sys.support.interfaces;

/**
 * Created by KC on 2017/5/18.
 *
 * 读入数据时/创建时确认用回调函数,
 */
public interface CreationCallback<T> {

    void createFail(String msg);

    T createSucceed(T obj);
}
