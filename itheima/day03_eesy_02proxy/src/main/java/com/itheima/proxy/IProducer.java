package com.itheima.proxy;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.proxy
 * Description: 生产代理
 *
 * @Date:2021/9/2 16:18
 * @Author:zhang'lin zhanglin@163.com
 */
public interface IProducer {
    /**
     * 销售产品，获取利润
     * @param money
     */
    public  void saleProducer(float money);

    /**
     * 售后服务，获得利润
     * @param money
     */
    public void afterService(float money);


}
