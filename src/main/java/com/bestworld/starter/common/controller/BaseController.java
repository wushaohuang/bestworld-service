package com.bestworld.starter.common.controller;

import com.bestworld.starter.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

	@Autowired
	HttpServletRequest req;

	@Autowired
	RedisUtil redisUtil;

}
