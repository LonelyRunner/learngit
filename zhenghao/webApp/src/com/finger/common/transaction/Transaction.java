package com.finger.common.transaction;

/**
 * Created by ZH on 2016/7/21.
 */
public interface Transaction {
    void beginTransaction();
    void commit();
    void rollback();
}
