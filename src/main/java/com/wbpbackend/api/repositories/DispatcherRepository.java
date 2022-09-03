package com.wbpbackend.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wbpbackend.api.entities.Dispatcher;

@Repository
public interface DispatcherRepository extends JpaRepository<Dispatcher, Long> {

}
