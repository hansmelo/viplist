package com.hans.viplist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class Configuration {
	
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return "Hello, You're welcome the system Vips List";
	}

	public static void main(String[] args) {
		SpringApplication.run(Configuration.class, args);
	}
}
