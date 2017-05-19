package com.lihuanda.MyBatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lihuanda.MyBatis.mapper.UserMapper;
import com.lihuanda.MyBatis.vo.UserCustom;
import com.lihuanda.MyBatis.vo.UserQueryVo;

public class InputTypeTest {
	
	public static void main(String[] args) throws Exception {
		

		String resource="SqlMapConfig.xml";  
        
	        //将配置文件加载成流  
	    InputStream inputStream = Resources.getResourceAsStream(resource);  
	        //创建会话工厂，传入mybatis配置文件的信息  
	    SqlSessionFactory  sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream); 
	        
		
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper  = sqlSession.getMapper(UserMapper.class);

		//创建包装对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		//由于这里使用动态sql，如果不设置某个值，条件不会拼接在sql中
		userCustom.setSex("男");
		userCustom.setUsername("军");
		userQueryVo.setUserCustom(userCustom);
		//调用userMapper的方法

		List<UserCustom> list = userMapper.findUserList(userQueryVo);

		System.out.println(list);

		
		
	}

}
