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
@Table(name = "ETypeGroup")
public class TypeGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long typeGroupId;
	
	private String groupName;
	
	
	public Long getTypeGroupId() {
		return typeGroupId;
	}


	public void setTypeGroupId(Long typeGroupId) {
		this.typeGroupId = typeGroupId;
	}


	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	@Override
	public String toString() {
		return "TypeGroup [TypeGroupId=" + typeGroupId + ", groupName=" + groupName + "]";
	}
}
