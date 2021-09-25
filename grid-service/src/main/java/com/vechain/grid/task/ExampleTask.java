package com.vechain.grid.task;


import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.vechain.service.TaskService;


@Component
public class ExampleTask extends TaskService {

	@Override
	public boolean runTask() {
		System.out.println("task =======================================================================");
		return false;
	}

	@Override
	public boolean openTask() {
		return true;
	}

	@Override
	public boolean lockTask() {
		return true;
	}

	@Override
	public long getLockTime() {
		return 1000 * 60 * 5;
	}

	@Override
	public TimeUnit getTimeUnit() {
		return TimeUnit.MILLISECONDS;
	}

	@Override
	public String getTaskName() {
		return ExampleTask.class.getSimpleName();
	}

}
