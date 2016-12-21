package com.atguigu.bk.dto;

public class TurnPage {	
	public int currentPage =1 ;        //当前页号，从1开始-----------入参
	public int rowsOnePage = 10;       //每页显示的记录行数-----------入参
    public int allRows;                //满足查询条件的记录总数---------返回值
    public int allPages;               //满足查询条件的总页数----------返回值
}
