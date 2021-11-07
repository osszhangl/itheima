package com.itheima.cglib;

import com.itheima.proxy.IProducer;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.proxy
 * Description: 模拟一个厂家生产者
 *
 * @Date:2021/9/2 16:13
 * @Author:zhang'lin zhanglin@163.com
 */
public class Producer {
    /**
     * 销售产品，获取利润
     * @param money
     */
    public  void saleProducer(float money){
        System.out.println("销售产品，获得钱："+money);
    }

    /**
     * 售后服务，获得利润
     * @param money
     */
    public void afterService(float money){
        System.out.println("售后服务，获取钱"+money);
    }

}
