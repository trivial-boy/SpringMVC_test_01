package com.it.test;

import com.it.dao.AccountDao;
import com.it.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    @Test
    public void run1() throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //查询所有
        List<Account> all = dao.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
        //关闭资源
        session.close();
        in.close();
    }

    @Test
    public void run2()  throws  IOException{
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //查询所有
        Account account = new Account();
        account.setMoney(1000d);
        account.setName("里详细");
        account.setId(11);
        dao.saveAccount(account);
        System.out.println(account.toString());
        //提交事务
        session.commit();
        //关闭资源
        session.close();
        in.close();
    }
}
