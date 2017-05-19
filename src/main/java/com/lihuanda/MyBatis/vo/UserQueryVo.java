package com.lihuanda.MyBatis.vo;

public class UserQueryVo {
	
	
//	mybatis的输入映射。
//
//	通过parameterType指定输入参数的类型，类型可以是
//
//	简单类型
//	hashmap
//	pojo的包装类型
	
	

    //在这里包装所需要的查询条件

    //用户查询条件
	
	
	//输入的参数只能是一个，所以要对查询的条件进行包装
    private UserCustom userCustom;

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    //可以包装其它的查询条件，订单、商品
    //....

    
    
    

}
