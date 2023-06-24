package com.dedalus.eqpmgmt.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "ServicePoint")
public class ServicePoint {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long servicePointId;
	private String servicePointName;
	public Long getServicePointId() {
		return servicePointId;
	}
	public void setServicePointId(Long servicePointId) {
		this.servicePointId = servicePointId;
	}
	public String getServicePointName() {
		return servicePointName;
	}
	public void setServicePointName(String servicePointName) {
		this.servicePointName = servicePointName;
	}
	
	
	
	
}
