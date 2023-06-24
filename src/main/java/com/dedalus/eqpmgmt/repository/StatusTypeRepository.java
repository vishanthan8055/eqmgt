package com.dedalus.eqpmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dedalus.eqpmgmt.entity.Equipement;
import com.dedalus.eqpmgmt.entity.StatusType;
import com.dedalus.eqpmgmt.entity.TypeGroup;

@Repository
public interface StatusTypeRepository extends CrudRepository<StatusType, Long>{

}
