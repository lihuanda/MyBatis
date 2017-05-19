package com.lihuanda.MyBatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lihuanda.MyBatis.mapper.OrdersMapperCustom;
import com.lihuanda.MyBatis.po.Orders;

public class AssociationTest {
	
	public static void main(String[] args) throws Exception {
		
		String resource="SqlMapConfig.xml";  
        
        //将配置文件加载成流  
    InputStream inputStream = Resources.getResourceAsStream(resource);  
        //创建会话工厂，传入mybatis配置文件的信息  
    SqlSessionFactory  sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream); 
    
    
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession
				.getMapper(OrdersMapperCustom.class);

		// 调用maper的方法
		List<Orders> list = ordersMapperCustom.findOrdersUserResultMap();

		System.out.println(list);
		for(Orders orders:list)
		{
			System.out.println(orders.getId());
			System.out.println(orders.getCreatetime());
			System.out.println(orders.getUser().getUsername());
			System.out.println("------------------");
		}

		sqlSession.close();
	}

}
