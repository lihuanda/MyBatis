package com.lihuanda.MyBatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lihuanda.MyBatis.mapper.UserMapper;
import com.lihuanda.MyBatis.po.User;

public class UserMappertest {
	
	
	public static void main(String[] args) throws Exception {
		
		
		  String resource="SqlMapConfig.xml";  
          
	        //将配置文件加载成流  
	        InputStream inputStream = Resources.getResourceAsStream(resource);  
	        //创建会话工厂，传入mybatis配置文件的信息  
	        SqlSessionFactory  sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream); 

	        SqlSession sqlSession=sqlSessionFactory.openSession();  
	          
	        //创建UserMapper代理对象  
	        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);  
	          
	        //调用userMapper的方法  
	        //这边没有通过dao类
	        User user=userMapper.findUserById(1);  
	          
	        System.out.println(user.getUsername());  
	        
	        
	}

}
