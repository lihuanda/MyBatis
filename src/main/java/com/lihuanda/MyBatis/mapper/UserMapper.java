package com.lihuanda.MyBatis.mapper;

import java.util.List;

import com.lihuanda.MyBatis.po.User;
import com.lihuanda.MyBatis.vo.UserCustom;
import com.lihuanda.MyBatis.vo.UserQueryVo;

public interface UserMapper {
	
	
	//根据id查询用户信息
    public User findUserById(int id) throws Exception;

    //根据用户名列查询用户列表
    public List<User> findUserByName(String name) throws Exception;

    //添加用户信息
    public void insertUser(User user) throws Exception;

    //删除用户信息
    public void deleteUser(int id) throws Exception;

    //更新用户
    public void updateUser(User user)throws Exception;
    
    
    //用户信息综合查询
    public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
    
     // 用户信息查询总数
      //resultType 是简单类型
    public int  findUserCount(UserQueryVo userQueryVo)  throws  Exception;
    
    
    
//    系统框架中，dao层的代码是被业务层公用的。
//    即使mapper接口只有一个参数，可以使用包装类型的pojo满足不同的业务方法的需求
    
    
//    开发规范
//
//    在mapper.xml中namespace等于mapper接口地址
//    <!--
//     namespace 命名空间，作用就是对sql进行分类化管理,理解为sql隔离
//     注意：使用mapper代理方法开发，namespace有特殊重要的作用,namespace等于mapper接口地址
//     -->
//    <mapper namespace="com.iot.mybatis.mapper.UserMapper">
//    mapper.java接口中的方法名和mapper.xml中statement的id一致
//
//    mapper.java接口中的方法输入参数类型和mapper.xml中statement的parameterType指定的类型一致。
//
//    mapper.java接口中的方法返回值类型和mapper.xml中statement的resultType指定的类型一致。
//
//    <select id="findUserById" parameterType="int" resultType="com.iot.mybatis.po.User">
//        SELECT * FROM  user  WHERE id=#{value}
//    </select>
//    //根据id查询用户信息
//    public User findUserById(int id) throws Exception;
    
    
//    输出pojo对象和pojo列表
//
//    不管是输出的pojo单个对象还是一个列表（list中包括pojo），在mapper.xml中resultType指定的类型是一样的。
//
//    在mapper.java指定的方法返回值类型不一样：
//
//    输出单个pojo对象，方法返回值是单个对象类型
//    //根据id查询用户信息
//    public User findUserById(int id) throws Exception;
//    输出pojo对象list，方法返回值是List
//    //根据用户名列查询用户列表
//    public List<User> findUserByName(String name) throws Exception;
//    生成的动态代理对象中是根据mapper方法的返回值类型确定是调用selectOne(返回单个对象调用)还是selectList （返回集合对象调用 ）.
 
    
    
//    mybatis中使用resultMap完成高级输出结果映射。(一对多，多对多)
    
//    如果查询出来的列名和pojo的属性名不一致，通过定义一个resultMap对列名和pojo属性名之间作一个映射关系。
    
}
