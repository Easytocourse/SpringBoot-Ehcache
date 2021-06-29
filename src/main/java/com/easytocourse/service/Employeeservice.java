package com.easytocourse.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.easytocourse.dao.EmployeeRepository;
import com.easytocourse.model.Employee;

@Service
@CacheConfig(cacheNames = "demoCache")
public class Employeeservice {

	@Autowired
	EmployeeRepository emprepo;

	private final Logger log = LoggerFactory.getLogger(Employeeservice.class);

	@CachePut(key = "#result.id")
	public Employee saveaction(Employee emp) {

		Employee savedemp = emprepo.save(emp);

		return savedemp;

	}

	@Cacheable(key = "#id")
	public Optional<Employee> getemployeebyid(int id) {

		return emprepo.findById(id);
	}

	@Cacheable()
	public List<Employee> getallemployees() {

		return emprepo.findAll();
	}

	@CacheEvict(cacheNames = { "demoCache" }, allEntries = true)
	public void evictCache() {
		log.info("Evict all cache entries...");
	}
	
	@Autowired
	private CacheManager cacheManager;
	
	public void cachemanager()
	{
		Cache cache = cacheManager.getCache("demoCache");
		Employee emp=(Employee) cache.get(25).get();
		log.info("from the cachemanager="+emp);
	}

}
