package com.dedalus.eqpmgmt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dedalus.eqpmgmt.entity.Equipement;

@Repository
public interface EquipementRepository extends CrudRepository<Equipement, Long>{

}
