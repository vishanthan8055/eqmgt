package com.dedalus.eqpmgmt.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "userRequest")
public class UserRequest {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long rid;
    
    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;
    
    @ManyToOne
    @JoinColumn(name = "equipmentId")
    private Equipement eq;
    
    private String reqDate;
    
    @ManyToOne
    @JoinColumn(name = "servicePoint")
    private ServicePoint servicePoint;


    
    public ServicePoint getServicePoint() {
		return servicePoint;
	}

	public void setServicePoint(ServicePoint servicePoint) {
		this.servicePoint = servicePoint;
	}

	private String approvalStatus;

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}



	public Equipement getEq() {
		return eq;
	}

	public void setEq(Equipement eq) {
		this.eq = eq;
	}

	public String getReqDate() {
		return reqDate;
	}

	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}


	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

    
   
}

