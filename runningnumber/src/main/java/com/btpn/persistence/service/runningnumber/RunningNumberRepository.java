package com.btpn.persistence.service.runningnumber;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;

import com.btpn.persistence.entity.RunningNumberEntity;

public interface RunningNumberRepository extends CrudRepository<RunningNumberEntity, String> {

	@Override
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	public RunningNumberEntity findOne(String id);
}
