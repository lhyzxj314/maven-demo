package com.test.demo.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.demo.domain.User;
import com.test.demo.service.DemoService;
import com.test.demo.vo.ResponseView;

@Controller
public class DemoController {
	
	private static Logger log = Logger.getLogger(DemoController.class);
	
	@Resource
	private DemoService demoService;
	
	@RequestMapping(value="/demo.json", method={RequestMethod.GET})
	public @ResponseBody ResponseView echoHello(@RequestParam(value="id", required=false) Long id){
		log.info("echo hello of "+id);
		ResponseView result = new ResponseView();
		if(id==null){
			result.setBody("在url中加入id=1");
		}else{
			result.setBody(demoService.getName(id));
		}
		return result;
	}
	
	@RequestMapping(value="/add.json", method={RequestMethod.POST})
	public @ResponseBody ResponseView addUser(@RequestBody User user){
		log.info("add user:" + user);
		ResponseView result = new ResponseView();
		demoService.addUser(user);
		result.setBody("Success");
		return result;
	}
	
	@RequestMapping(value="/exchange.json", method={RequestMethod.GET})
	public @ResponseBody ResponseView handleExchangeReq(@RequestParam(value="srcid", required=false) Long userSrcId,
												 @RequestParam(value="destid", required=false) Long userDestId,
												 @RequestParam(value="money", required=false) Double money){
		log.info("exchange money:" + userSrcId + " to " + userDestId + ",sum=" + money);
		ResponseView result = new ResponseView();
		demoService.exchangeMoney(userSrcId, userDestId, money);
		result.setBody("Success");
		return result;
	}
	
	
}
