package com.dedalus.eqpmgmt.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EQUIPEMENT")
public class Equipement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long equipementId;
	@Column(name="ename")
	private String equipementName;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="typeId", referencedColumnName="typeId")
	private EType etype;
	
	@Column(name="eno")
	private String equipementNo;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="statusId", referencedColumnName="statusId")
	private EStatus status;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "servicePointId", referencedColumnName = "servicePointId")
	private ServicePoint servicePoint;
	private String expiryDate;
	
	 @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL, orphanRemoval = true)
	 private List<EquipementMovement> transactions;
//	 @OneToMany(mappedBy = "eq", cascade = CascadeType.ALL, orphanRemoval = true)
//	 private List<UserRequest> ur;
//	public void setTransactions(List<EquipementMovement> transactions) {
//		this.transactions = transactions;
//	}
	public Long getEquipementId() {
		return equipementId;
	}
	public void setEquipementId(Long equipementId) {
		this.equipementId = equipementId;
	}
	public EType getEtype() {
		return etype;
	}
	public void setEtype(EType etype) {
		this.etype = etype;
	}
	public String getEquipementNo() {
		return equipementNo;
	}
	public void setEquipementNo(String equipementNo) {
		this.equipementNo = equipementNo;
	}
	

	
	public ServicePoint getServicePoint() {
		return servicePoint;
	}
	public void setServicePoint(ServicePoint servicePoint) {
		this.servicePoint = servicePoint;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public EStatus getStatus() {
		return status;
	}
	public void setStatus(EStatus status) {
		this.status = status;
	}
//	@Override
//	public String toString() {
//		return "Equipment [equipementId=" + equipementId + " , equipementNo=" + equipementNo
//				+ ", workingStatus=" + workingStatus + ", servicePointId=" + servicePointId
//				+ ", expiryDate=" + expiryDate + "]";
//	}
	public String getEquipementName() {
		return equipementName;
	}
	public void setEquipementName(String equipementName) {
		this.equipementName = equipementName;
	}
	
	
	
	

}
