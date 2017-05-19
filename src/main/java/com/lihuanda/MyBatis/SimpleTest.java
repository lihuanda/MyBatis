package com.lihuanda.MyBatis;

import java.io.IOException;


import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;


import junit.framework.TestCase;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lihuanda.MyBatis.po.User;

public class SimpleTest {
	
	 //根据id查询用户信息，得到一条记录结果

//    @Test
    public void findUserByIdTest() throws IOException{
        // mybatis配置文件
//    	URL url = Mybatis.class.getClassLoader().getResource("/conf.properties");
    	//E:/work/MyBatis/
        String resource = "SqlMapConfig.xml";
        // 得到配置文件流
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis配置文件的信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 通过SqlSession操作数据库
        // 第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
        // 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
        // sqlSession.selectOne结果 是与映射文件中所匹配的resultType类型的对象
        // selectOne查询出一条记录
        Integer id=new  Integer(27);
     
        User user = (User) sqlSession.selectOne("test.findUserById", id);
        //这里要对返回的数据进行判断
         //如果数据为空...
        System.out.println(user);
        System.out.println(user.getUsername());
        System.out.println(user.getSex());

        // 释放资源
        sqlSession.close();

    }

    // 根据用户名称模糊查询用户列表
//    @Test
    public void findUserByNameTest() throws IOException {
        // mybatis配置文件
        String resource = "SqlMapConfig.xml";
        // 得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);

        // 通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // list中的user和映射文件中resultType所指定的类型一致
        List list = sqlSession.selectList("test.findUserByName", "军");
        System.out.println(list);
         for(int i=0;i<list.size();i++)
         {
        	 User user  = (User) list.get(i);
        	 System.out.println(user.getUsername());
        	 System.out.println(user.getSex());
         }
        sqlSession.close();

    }
    // 添加用户信息
//    @Test
    public void insertUserTest() throws IOException {
        // mybatis配置文件
        String resource = "SqlMapConfig.xml";
        // 得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);

        // 通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 插入用户对象
        User user = new User();
        user.setUsername("王小军");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("河南郑州");

        sqlSession.insert("test.insertUser", user);

        // 提交事务
        sqlSession.commit();

        // 获取用户信息主键
        System.out.println(user.getId());
        // 关闭会话
        sqlSession.close();

    }

    // 根据id删除 用户信息
//    @Test
    public void deleteUserTest() throws IOException {
        // mybatis配置文件
        String resource = "SqlMapConfig.xml";
        // 得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);

        // 通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 传入id删除 用户
        Integer id  = new  Integer(28);
        sqlSession.delete("test.deleteUser", id);

        // 提交事务
        sqlSession.commit();

        // 关闭会话
        sqlSession.close();

    }

    // 更新用户信息
//    @Test
    public void updateUserTest() throws IOException {
        // mybatis配置文件
        String resource = "SqlMapConfig.xml";
        // 得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);

        // 通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 更新用户信息

        User user = new User();
        //必须设置id
        //
        user.setId(27);
        user.setUsername("王大军");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("河南郑州");

        sqlSession.update("test.updateUser", user);

        // 提交事务
        sqlSession.commit();

        // 关闭会话
        sqlSession.close();

    }
    


    public static void main(String[] args) {
    	
    	
    	try {
    		
    		SimpleTest mybatis=new SimpleTest();
    		mybatis.findUserByIdTest();
    		System.out.println("--------------------------");
    		mybatis.findUserByNameTest();
    		System.out.println("--------------------------");
    		mybatis.insertUserTest();
    		System.out.println("--------------------------");
    		mybatis.deleteUserTest();
    		System.out.println("--------------------------");
    		mybatis.updateUserTest();
    		System.out.println("--------------------------");
    		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    

}




//#{}和${}
//#{}表示一个占位符号，#{}接收输入参数，类型可以是简单类型，pojo、hashmap。
//
//如果接收简单类型，#{}中可以写成value或其它名称。
//
//#{}接收pojo对象值，通过OGNL读取对象中的属性值，通过属性.属性.属性...的方式获取对象属性值。
//
//${}表示一个拼接符号，会引用sql注入，所以不建议使用${}。
//
//${}接收输入参数，类型可以是简单类型，pojo、hashmap。
//
//如果接收简单类型，${}中只能写成value。
//
//${}接收pojo对象值，通过OGNL读取对象中的属性值，通过属性.属性.属性...的方式获取对象属性值。



//hibernate
//是一个标准ORM框架（对象关系映射）。入门门槛较高的，不需要程序写sql，sql语句自动生成了。对sql语句进行优化、修改比较困难的。
//
//应用场景：适用与需求变化不多的中小型项目，比如：后台管理系统，erp、orm、oa。。
//
//mybatis
//专注是sql本身，需要程序员自己编写sql语句，sql修改、优化比较方便。mybatis是一个不完全的ORM框架，虽然程序员自己写sql，mybatis也可以实现映射（输入映射、输出映射）。
//
//应用场景：适用与需求变化较多的项目，比如：互联网项目。
//
//企业进行技术选型，以低成本高回报作为技术选型的原则，根据项目组的技术力量进行选择。
