package com.zh.tx.Service;

import com.zh.tx.dao.BookShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("bookShopService")
public class BookShopServiceImpl implements BookShopService{

    @Autowired
    private BookShopDao bookShopDao;

    //�������ע��
    //1.ʹ�� propagation ָ������Ĵ�����Ϊ, ����ǰ�����񷽷�������һ�����񷽷�����ʱ
    //���ʹ������, Ĭ��ȡֵΪ REQUIRED, ��ʹ�õ��÷���������
    //REQUIRES_NEW: �����Լ�������, ���õ����񷽷������񱻹���.
    //2.ʹ�� isolation ָ������ĸ��뼶��, ��õ�ȡֵΪ READ_COMMITTED
    //3.Ĭ������� Spring ������ʽ��������е�����ʱ�쳣���лع�. Ҳ����ͨ����Ӧ��
    //���Խ�������. ͨ�������ȥĬ��ֵ����.
    //4.ʹ�� readOnly ָ�������Ƿ�Ϊֻ��. ��ʾ�������ֻ��ȡ���ݵ�����������,
    //�������԰������ݿ������Ż�����. �������һ��ֻ��ȡ���ݿ�ֵ�ķ���, Ӧ���� readOnly=true
    //5.ʹ�� timeout ָ��ǿ�ƻع�֮ǰ�������ռ�õ�ʱ��.

    /**
     * δ���transactionע��ʱ:������ʱ������Υ�����ݿ���Լ����  ���׳��쳣
     *            ��ʱ���û�з����仯  ���ǿ�����Ѿ���ȥ1
     *            ���о��漰�������������
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void purchase(String username, String isbn) {

        //��ȡ��ĵ���
        int price = bookShopDao.findBookPriceByIsbn(isbn);

        //���¿��
        bookShopDao.updateBookStock(isbn);

        //�����˻����
        bookShopDao.updateUserAccount(username,price);
    }
}
