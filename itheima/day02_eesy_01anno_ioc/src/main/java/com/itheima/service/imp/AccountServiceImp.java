package com.itheima.service.imp;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.iml.AccountDaoImp;
import com.itheima.service.IAccountService;
import org.springframework.stereotype.Component;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.service.imp
 * Description:
 *
 * 曾经的xml配置
 * <bean id="accountService" class="com.itheima.service.imp.AccountServiceImp"  scope=""
 *  init-method="" destroy-method="" >
 *      <property name="" value="" ref=""></property>
 *  </bean>
 *
 *
 *  用于创建对象的
 *      他们的作用就和在xml配置文件中编写一个<bean>标签实现的功能时一样的
 *      @Conponent:
 *          作用：用于把当前类对象存入spring容器中
 *          属性：value：用于指定bean的id，当我们不写时，他的默认值时当前类名，且首字母该小写
 *      Controller:一般用于表现层
 *      Service：一般用于业务层
 *      Repository：一般用于持久层
 *      以上三个注解的功能和属性与component是一摸一样的
 *      他们三个是spring框架为我们提供明确的三层架构使用的注解，是我们的三层对象更加清晰
 *
 *
 *  用于注入数据的
 *      他们呢的作用就和在xml配置文件中的bean标签中写一个property标签的作用一样的
 *      Autowired:
 *           作用：自动按照类型注入，只要容器中由唯一个bean对象类型和要注入的变量类型匹配，就可以成功注入
 *                  如果ioc容器中没有任何bean的类型和要注入的变量类型匹配，则报错。
 *           出现的位置：可以在变量上，也可以在方法上。
 *                细节：在使用注解输入时，set方法就不是必须的了。
 *      Qualifier:
 *             作用：在按照类中注入的基础之上在按照名称注入，他在给类成员注入时不能单独使用。但是再给方法参数注入时可以单独使用
 *              属性：value ：用于指定注入bean的id。
 *      Resource：
 *              作用：注解按照bean的id注入，他可以独立使用。
 *              属性：name 用于指定bean的id
 *      以上三个注解都只能在其他bean类型的数据，而基本类型和String类型无法使用上述注解实现。
 *      另外，集合类型的注入只能通过xml来实现。
 *
 *      value：
 *          作用：用于注入基本类型和String类型的数据
 *          属性：value ：用于指定数据的值，它可以使用spring中ApEL（就是spring的EL表达式）
 *                         SpEL的写法：${表达式}
 *  用于改变作用范围的
 *      他们的作用就和在bean标签中使用scope属性实现的功能一样的
 *      scope
 *            作用：用于指定bean的作用范围
 *            属性：value: 指定范围的取值，常用取值：singleton proptotype
 *  和生命周期相关（了解）
 *      他们的作用就和在bean标签中使用init-method 和destroy-method的做作用是一样的
 *      ProDestroy：指定销毁的方法
 *      PostConstruct：指定初始化方法
 *
 *
 * @Date:2021/7/26 20:36
 * @Author:zhang'lin zhanglin@163.com
 */
@Component
public class AccountServiceImp implements IAccountService {

    private IAccountDao iAccountDao = new AccountDaoImp();

    public void saveAccount() {
        iAccountDao.save();
    }
}
