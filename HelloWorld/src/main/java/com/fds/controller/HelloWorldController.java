package com.fds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fds.model.HelloRequest;
import com.fds.model.HelloResponse;
import com.fds.model.Item;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {

	@Autowired
	private HelloResponse response;
	
	public HelloWorldController() {
		System.out.println("Init HelloWorldController ");
	}
	
	@RequestMapping(value = "/sayHello", method = RequestMethod.POST)
	public HelloResponse sayHello(@RequestParam(value = "key") String key, @RequestBody HelloRequest request) {
		response.setMsg(request.getMsg());
		response.setStatus(1);
		response.getItemList().clear();
		response.getItemList().add(new Item("A1","1"));
		response.getItemList().add(new Item("A2","2"));
		return response;
	}
	public HelloResponse getResponse() {
		return response;
	}
	public void setResponse(HelloResponse response) {
		this.response = response;
	}
}
