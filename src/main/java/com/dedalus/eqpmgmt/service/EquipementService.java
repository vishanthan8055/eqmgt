package com.dedalus.eqpmgmt.service;

import java.util.List;
import java.util.Optional;

import com.dedalus.eqpmgmt.entity.EStatus;
import com.dedalus.eqpmgmt.entity.EType;
import com.dedalus.eqpmgmt.entity.Equipement;
import com.dedalus.eqpmgmt.entity.EquipementMovement;
import com.dedalus.eqpmgmt.entity.ServicePoint;
import com.dedalus.eqpmgmt.entity.StatusType;
import com.dedalus.eqpmgmt.entity.TypeGroup;
import com.dedalus.eqpmgmt.entity.UserRequest;
import com.dedalus.eqpmgmt.entity.Users;

public interface EquipementService {
	public Equipement addEquipement(Equipement equipement);
	public TypeGroup addEquipementtypegroup(TypeGroup tg);
	public StatusType addStatustype(StatusType st);
	public ServicePoint addServicePoint(ServicePoint sp);
	public EStatus addStatus(EStatus status);
	public  List<Equipement> listAllEquipements();
	public EType saveTypeRequest(EType etype);
	public TypeGroup addTypeGroup(TypeGroup typeGroup);
	public EquipementMovement addEquipementMovement(EquipementMovement em);
	public void deleteAllEquipements();
	public List<EquipementMovement> listAllTransactions();
	public Optional<Equipement> getEqById(Long id);
	public Equipement updateEquipement(Equipement eq) throws Exception;
	public Users addUser(Users user);
	public UserRequest addRequest(UserRequest ur);
	public List<UserRequest> listAllRequests();
//	public List<EType> listAllEquipementsType();
}
