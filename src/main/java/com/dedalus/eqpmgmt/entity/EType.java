package com.dedalus.eqpmgmt.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
public class EType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long typeId;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="tgroupId", referencedColumnName="typeGroupId")
	private TypeGroup tGroup;
	private String typeName;
	private String typeDisplayName;
	
	
public Long getTypeId() {
		return typeId;
	}
	public TypeGroup gettGroup() {
	return tGroup;
}
public void settGroup(TypeGroup tGroup) {
	this.tGroup = tGroup;
}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeDisplayName() {
		return typeDisplayName;
	}
	public void setTypeDisplayName(String typeDisplayName) {
		this.typeDisplayName = typeDisplayName;
	}
	@Override
	public String toString() {
		return "Type [typeId=" + typeId +  ", typeName=" + typeName + ", typeDisplayName="
				+ typeDisplayName + "]";
	}
	
}
