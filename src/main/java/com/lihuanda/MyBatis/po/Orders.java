package com.lihuanda.MyBatis.po;

import java.util.Date;
import java.util.List;

public class Orders {
	
	
	private int id;
	
	private int userId;
	
    private  String number;
    
    private  Date  createtime;
    
    private  String note;
    
    private User  user;
    
  //订单明细
    private List<OrderDetail> orderdetails;
    
//    在orders.java类中添加List<orderDetail> orderDetails属性。
//    最终会将订单信息映射到orders中，订单所对应的订单明细映射到orders中的orderDetails属性中。
    
    
    
//    使用resultMap将查询结果中的订单信息映射到Orders对象中，
//    在orders类中添加User属性，将关联查询出来的用户信息映射到orders对象中的user属性中。
    
    
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
