package com.dedalus.eqpmgmt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dedalus.eqpmgmt.entity.*;
import com.dedalus.eqpmgmt.service.EquipementService;

@RestController
public class EquipementRestController {
	
	@Autowired
	EquipementService EquipementService;
	
	@GetMapping("/delete")
	public String helloEquipement() {
		EquipementService.deleteAllEquipements();
		return "Hello👋👋";
	}
	
	@PostMapping("/addEquipement")
	public Equipement addEquipement(@RequestBody Equipement equipement) {
		return EquipementService.addEquipement(equipement);
	}
	@PostMapping("/updateEquipement")
	public Equipement updateEquipement(@RequestBody Equipement equipement) throws Exception {
		return EquipementService.updateEquipement(equipement);
	}
	@PostMapping("/addServicepoint")
	public ServicePoint addServicePoint(@RequestBody ServicePoint sp) {
		return EquipementService.addServicePoint(sp);
	}
	@GetMapping("/listallEquipement")
	public List<Equipement> listAllEquipements(){
		return EquipementService.listAllEquipements();
	}
	@GetMapping("/findEquipementById/{id}")
	public Optional<Equipement> findByEqId(@PathVariable("id") Long EqId){
		return EquipementService.getEqById(EqId);
	}
//	@GetMapping("/listEquipementTransaction/{id}")
//	public List<EquipementMovement> eqtransactions(@PathVariable("id") Long EqId){
//		Optional<Equipement> eq = EquipementService.getEqById(EqId);
//		if(eq.isPresent()) {
//			Equipement neq = eq.get();
//			return neq.transactions;
//		}
//		else {
//			return null;
//		}
//	}
	@GetMapping("/listallTransactions")
	public List<EquipementMovement> listAllTransactions(){
		return EquipementService.listAllTransactions();
	}
	@PostMapping("/addEquipementtypegroup")
	public TypeGroup addEquipementType(@RequestBody TypeGroup tg) {
		return EquipementService.addEquipementtypegroup(tg);
	}
	@PostMapping("/addstatustype")
	public StatusType addStatustype(@RequestBody StatusType st) {
		return EquipementService.addStatustype(st);
	}
	@PostMapping("/addstatus")
	public EStatus addStatus(@RequestBody EStatus status) {
		return EquipementService.addStatus(status);
	}
	
	@PostMapping("/addEquipementtype")
	public EType addEquipementType(@RequestBody EType etype) {
		return EquipementService.saveTypeRequest(etype);
	}
	@PostMapping("/addTransaction")
	public EquipementMovement addEquipementMovement(@RequestBody EquipementMovement em) {
		return EquipementService.addEquipementMovement(em);
	}
	@PostMapping("/addUser")
	public Users addUser(@RequestBody Users user) {
		return EquipementService.addUser(user);
	}
	@PostMapping("/addUserRequest")
	public UserRequest addUserRequest(@RequestBody UserRequest ur) {
		return EquipementService.addRequest(ur);
	}
	@GetMapping("/listallRequests")
	public List<UserRequest> listAllUserRequests(){
		return EquipementService.listAllRequests();
	}
//	@GetMapping("/listallEquipementType")
//	public List<EType> listAllEquipementsType(){
//		return EquipementService.listAllEquipementsType();
//	}

}
