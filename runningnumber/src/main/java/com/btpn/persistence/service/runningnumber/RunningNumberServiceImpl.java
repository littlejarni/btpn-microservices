package com.btpn.persistence.service.runningnumber;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.btpn.persistence.entity.RunningNumberEntity;

public class RunningNumberServiceImpl implements RunningNumberService {

	public static final String DEFAULT_RUNNING_NUMBER = "DEFAULT";
	public static final Integer DEFAULT_RUNNING_NUMBER_INTERVAL = 1000;

	
	@Autowired
	RunningNumberRepository repo;
	
	@Autowired
	RunningNumberService service;

	HashMap<String, Integer> mapCurrent = new HashMap<String, Integer>();
	HashMap<String, Integer> mapMax = new HashMap<String, Integer>();

	@Override
	public int getRunningNumber() throws Exception {
		return getRunningNumber(DEFAULT_RUNNING_NUMBER);
	}

	@Override
	public int getRunningNumber(String runningNumberCode) throws Exception {
		String code = runningNumberCode != null ? runningNumberCode : DEFAULT_RUNNING_NUMBER;

		synchronized (code) {
			Integer current = mapCurrent.get(code);
			if (current == null) {
				service.reloadRunningNumber(code);
				current = mapCurrent.get(code);
			}
			
			Integer max = mapMax.get(code);
			if(current==max) {
				service.reloadRunningNumber(code);
			} else {
				mapCurrent.put(code, current + 1);
			}
			
			return current;
		}
	}

	@Override
	@Transactional
	public void reloadRunningNumber(String code) throws Exception {
		
		RunningNumberEntity runningNo = repo.findOne(code);
		if (runningNo == null) {
			throw new Exception("Running Number not registered at DB");
		}
		Integer current = runningNo.getCurrent();
		Integer nextCurrent = current + runningNo.getCacheInterval();
		Integer end = runningNo.getEnd();
		int max;
		if(end!=null && nextCurrent>=end) {
			nextCurrent = runningNo.getStart();
			max = end;
		} else { 
			max = nextCurrent - 1;
		}
		
		runningNo.setCurrent(nextCurrent);
		repo.save(runningNo);

		mapCurrent.put(code, current);
		mapMax.put(code, max);
	}

}
