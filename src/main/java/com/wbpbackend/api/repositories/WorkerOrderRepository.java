package com.wbpbackend.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wbpbackend.api.entities.WorkerOrder;

@Repository
public interface WorkerOrderRepository extends JpaRepository<WorkerOrder, Long> {

}
