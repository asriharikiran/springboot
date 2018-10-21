package com.springboot.controllers;


import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BPMController {
	
	@Autowired
	RuntimeService runtimeService;
	
	@Autowired
	TaskService taskService;

	@RequestMapping(name = "/startprocess", method= RequestMethod.GET)
	public String startProcess() {
		ProcessInstance pi = runtimeService.startProcessInstanceByKey("simpleProcess");
		System.out.println("Process Started "+pi.getId());
		return "Process Started with Id "+pi.getId(); 
	}
	
	@RequestMapping("/hello")
	public String getHelloMessage() {
		return "Hello Buddy";
	}
	
	@RequestMapping("/mytasks")
	public long getCount(){
		 
		return taskService.createTaskQuery().taskAssignee("Hari").count();
	}
}
