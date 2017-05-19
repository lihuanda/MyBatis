package com.lihuanda.MyBatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lihuanda.MyBatis.dao.UserDao;
import com.lihuanda.MyBatis.dao.impl.UserDaoImpl;
import com.lihuanda.MyBatis.po.User;

public class UserDaoImplTest {
	
	public static void main(String[] args) throws Exception {
		
		// 创建sqlSessionFactory

				// mybatis配置文件
				String resource = "SqlMapConfig.xml";
				// 得到配置文件流
				InputStream inputStream = Resources.getResourceAsStream(resource);

				// 创建会话工厂，传入mybatis的配置文件信息
				SqlSessionFactory   sqlSessionFactory = new SqlSessionFactoryBuilder()
						.build(inputStream);
		
				UserDao userDao = new UserDaoImpl(sqlSessionFactory);

				// 调用UserDao的方法
				User user = userDao.findUserById(27);
				
				System.out.println(user.getUsername());
		
		
	}

}
