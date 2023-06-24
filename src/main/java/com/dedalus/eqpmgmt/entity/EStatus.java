package com.dedalus.eqpmgmt.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
//@ToString
public class EStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@OneToMany(mappedBy="status")
	private Long statusId;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="statusTypeId", referencedColumnName="statusTypeId")
	private StatusType st;
	private String statusName;
	private String statusDisplayName;
	public Long getStatusId() {
		return statusId;
	}
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}
	public StatusType getSt() {
		return st;
	}
	public void setSt(StatusType st) {
		this.st = st;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getStatusDisplayName() {
		return statusDisplayName;
	}
	public void setStatusDisplayName(String statusDisplayName) {
		this.statusDisplayName = statusDisplayName;
	}
	@Override
	public String toString() {
		return "EStatus [statusId=" + statusId + ", st=" + st + ", statusName=" + statusName + ", statusDisplayName="
				+ statusDisplayName + "]";
	}
	
	

	
}
