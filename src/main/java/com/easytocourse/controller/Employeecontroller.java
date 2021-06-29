package com.easytocourse.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easytocourse.model.Employee;
import com.easytocourse.service.Employeeservice;

@RestController
@RequestMapping("/Employee")
public class Employeecontroller {

	@Autowired
	Employeeservice empservice;

	@PostMapping("/addEmployee")
	public Employee addemployee(@RequestBody Employee emp) {
		return empservice.saveaction(emp);

	}

	@GetMapping("/getemployee/{id}")
	public Optional<Employee> getemployee(@PathVariable int id) {
		return empservice.getemployeebyid(id);
	}

	@GetMapping("/getemployees")
	public List<Employee> getemployees() {
		return empservice.getallemployees();
	}

	@GetMapping("/evict")
	public void removecache()
	{
		empservice.evictCache();
	}
	
	@GetMapping("/cachemanager")
	public void cachemanager()
	{
		empservice.cachemanager();
	}

}
