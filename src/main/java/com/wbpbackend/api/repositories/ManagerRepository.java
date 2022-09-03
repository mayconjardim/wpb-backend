package com.wbpbackend.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wbpbackend.api.entities.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
