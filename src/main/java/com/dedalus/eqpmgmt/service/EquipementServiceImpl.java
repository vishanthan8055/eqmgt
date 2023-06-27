package com.dedalus.eqpmgmt.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dedalus.eqpmgmt.entity.EStatus;
import com.dedalus.eqpmgmt.entity.EType;
import com.dedalus.eqpmgmt.entity.Equipement;
import com.dedalus.eqpmgmt.entity.EquipementMovement;
import com.dedalus.eqpmgmt.entity.ServicePoint;
import com.dedalus.eqpmgmt.entity.StatusType;
import com.dedalus.eqpmgmt.entity.TypeGroup;
import com.dedalus.eqpmgmt.entity.UserRequest;
import com.dedalus.eqpmgmt.entity.Users;
import com.dedalus.eqpmgmt.repository.EquipementMovementRepository;
import com.dedalus.eqpmgmt.repository.EquipementRepository;
import com.dedalus.eqpmgmt.repository.ServicePointRepository;
import com.dedalus.eqpmgmt.repository.StatusRepository;
import com.dedalus.eqpmgmt.repository.StatusTypeRepository;
import com.dedalus.eqpmgmt.repository.TypeGroupRepository;
import com.dedalus.eqpmgmt.repository.TypeRepository;
import com.dedalus.eqpmgmt.repository.UserRequestRepository;
import com.dedalus.eqpmgmt.repository.UsersRepository;

import ch.qos.logback.core.status.Status;

@Service
public class EquipementServiceImpl implements EquipementService {
	
	@Autowired
	EquipementRepository equipementRepository;
	@Autowired
	TypeRepository typeRepository;
	@Autowired
	TypeGroupRepository typeGroupRepository;
	@Autowired
	StatusTypeRepository statusTypeRepository;
	@Autowired
	StatusRepository statusRepository;
	@Autowired
	ServicePointRepository servicePointRepository;
	@Autowired
	EquipementMovementRepository equipementMovementRepository;
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	UserRequestRepository usersRequestRepository;
	@Override
	public Equipement addEquipement(Equipement equipement) {
		EType et = equipement.getEtype();
		EStatus es = equipement.getStatus();
		ServicePoint sp = equipement.getServicePoint();
		equipement.setServicePoint(sp);
		equipement.setStatus(es);
		equipement.setEtype(et);
		return equipementRepository.save(equipement);
	}
	@Override
	public EStatus addStatus(EStatus status) {
		StatusType st = status.getSt();
		status.setSt(st);
		return statusRepository.save(status);
	}
	@Override
	public TypeGroup addEquipementtypegroup(TypeGroup tg){
		return typeGroupRepository.save(tg);
	}
	@Override
	public ServicePoint addServicePoint(ServicePoint sp){
		return servicePointRepository.save(sp);
	}
	@Override
	public StatusType addStatustype(StatusType st){
		return statusTypeRepository.save(st);
	}
	@Override
	public List<Equipement> listAllEquipements() {
		return (List<Equipement>) equipementRepository.findAll();
	}
	
	@Override
	public EType saveTypeRequest(EType etype) {

		TypeGroup tg = etype.gettGroup();
		etype.settGroup(tg);
		return typeRepository.save(etype);
	}
	@Override
	public TypeGroup addTypeGroup(TypeGroup typeGroup) {
		return typeGroupRepository.save(typeGroup);
	}
	
	@Override
	public EquipementMovement addEquipementMovement(EquipementMovement em) {
		UserRequest ur = em.getUr();
		ur.setApprovalStatus("Aproved");
		Equipement eq = em.getEquipment();
		ServicePoint fsp = em.getFromServicePoint();
		ServicePoint tsp = em.getToServicePoint();
//		UserRequest ur = em.getUr();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		em.setEquipment(eq);
		em.setFromServicePoint(fsp);
		em.setToServicePoint(tsp);
		em.setUr(ur);
		em.setMovedAt(dateFormat.format(date));
		usersRequestRepository.save(ur);
		return equipementMovementRepository.save(em);
	}
	
	@Override
	public List<EquipementMovement> listAllTransactions() {
		return (List<EquipementMovement>) equipementMovementRepository.findAll();
	}
	@Override
	public Optional<Equipement> getEqById(Long id) {
		return equipementRepository.findById(id);
	}
	@Override
	public Equipement updateEquipement(Equipement eq) throws Exception {
		Optional<Equipement> ne =  equipementRepository.findById(eq.getEquipementId());
		if(ne.isEmpty()) {
			throw new Exception("Not Found");
		}
		else {
			Equipement neq = ne.get();
			neq.setEquipementName(eq.getEquipementName());
			neq.setEquipementNo(eq.getEquipementNo());
			neq.setEtype(eq.getEtype());
			neq.setExpiryDate(eq.getExpiryDate());
			neq.setServicePoint(eq.getServicePoint());
			neq.setStatus(eq.getStatus());
			
			return equipementRepository.save(neq);
		}	
	}
	@Override
	public void deleteAllEquipements() {
		equipementRepository.deleteAll();
		System.out.println("Deleted Successfully");
	}
	
	@Override
	public Users addUser(Users user){
		return usersRepository.save(user);
	}
	@Override
	public UserRequest addRequest(UserRequest ur){
		Users u  =ur.getUser();
		Equipement eq = ur.getEq();
		ur.setEq(eq);
		ur.setUser(u);
		return usersRequestRepository.save(ur);
	}
	
	@Override
	public List<UserRequest> listAllRequests(){
		return (List<UserRequest>) usersRequestRepository.findAll();
	}
//	@Override
//	public List<EType> listAllEquipementsType() {
//		return (List<EType>) typeRepository.findAll();
//	}
}
