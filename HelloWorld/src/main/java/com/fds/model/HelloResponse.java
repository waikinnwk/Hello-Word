package com.fds.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HelloResponse {
	
	private int status;
	private String msg;
	private String date;
	private List<Item> itemList;
	
	public HelloResponse() {
		System.out.println("Init HelloResponse");
		date = (new Date()).toGMTString();
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Item> getItemList() {
		if(itemList == null)
			itemList = new ArrayList<Item>();
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
}
