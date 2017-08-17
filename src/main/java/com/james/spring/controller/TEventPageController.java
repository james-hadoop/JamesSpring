package com.james.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.james.spring.dao.mapper.master.TEventPageMapper;
import com.james.spring.entity.TEventPage;

@RestController
public class TEventPageController {
	@Autowired
	TEventPageMapper tEventPageMapper;

	@RequestMapping("/getAllTEventPage")
	public List<TEventPage> getAllTEventPage() {
		List<TEventPage> tEventPageList = tEventPageMapper.getAllTEventPage();
		return tEventPageList;
	}
}
