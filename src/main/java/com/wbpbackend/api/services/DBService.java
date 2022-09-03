package com.wbpbackend.api.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbpbackend.api.entities.Dispatcher;
import com.wbpbackend.api.entities.Manager;
import com.wbpbackend.api.entities.WorkerOrder;
import com.wbpbackend.api.enums.Priority;
import com.wbpbackend.api.enums.Status;
import com.wbpbackend.api.repositories.DispatcherRepository;
import com.wbpbackend.api.repositories.ManagerRepository;
import com.wbpbackend.api.repositories.WorkerOrderRepository;

@Service
public class DBService {

	
	@Autowired
	private DispatcherRepository dispatcherRepository;
	
	@Autowired
	private ManagerRepository managerRepository;
	
	@Autowired
	private WorkerOrderRepository workerRepository;
	
	
	public void runDB() {

		Dispatcher d1 = new Dispatcher(null, "Dispatcher sinistro");
		Manager m1 = new Manager(null, "Rodrigo Tjeua", "+55198414454", "rod@gmail.com");

		WorkerOrder wrk = new WorkerOrder(null, Priority.HIGH, Status.OPEN, d1, m1, "Vasco da gama");

		d1.getList().add(wrk);
		m1.getList().add(wrk);

		dispatcherRepository.saveAll(Arrays.asList(d1));
		managerRepository.saveAll(Arrays.asList(m1));

		workerRepository.saveAll(Arrays.asList(wrk));

	}

}
