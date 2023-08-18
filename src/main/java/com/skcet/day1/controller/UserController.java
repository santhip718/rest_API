package com.skcet.day1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Welcome")
public class UserController {
@GetMapping("/Welcome")
public String Welcome()
{
	return "Welcome String Boot!";
}
}
