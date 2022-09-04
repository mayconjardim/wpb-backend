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
		Dispatcher d2 = new Dispatcher(null, "Roberto Monteiro");
		Manager m1 = new Manager(null, "Rodrigo Tjeua", "+55198414454", "rod@gmail.com");
		Manager m2 = new Manager(null, "Lebron James", "+5519844840", "lebron@gmail.com");

		WorkerOrder wrk = new WorkerOrder(null, Priority.HIGH, Status.OPEN, d1, m1, "Vasco da gama");
		WorkerOrder wrk2 = new WorkerOrder(null, Priority.MEDIUM, Status.OPEN, d2, m2, "Concerta essa porra");

		d1.getList().add(wrk);
		m1.getList().add(wrk);
		
		d2.getList().add(wrk2);
		m2.getList().add(wrk2);

		dispatcherRepository.saveAll(Arrays.asList(d1, d2));
		managerRepository.saveAll(Arrays.asList(m1, m2));

		workerRepository.saveAll(Arrays.asList(wrk, wrk2));

	}

}
