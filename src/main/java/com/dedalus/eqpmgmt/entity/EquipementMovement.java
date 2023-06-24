package com.dedalus.eqpmgmt.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EquipmentMovement")
public class EquipementMovement {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)

    private Long equipmentMovementId;

    @ManyToOne
    @JoinColumn(name = "equipmentId")
    private Equipement equipment;

    @ManyToOne
    @JoinColumn(name = "fromServicePointId")
    private ServicePoint fromServicePoint;

    @ManyToOne
    @JoinColumn(name = "toServicePointId")
    private ServicePoint toServicePoint;
    @OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "rid", referencedColumnName = "rid")
	private UserRequest ur;
    
    private String movedAt;

	public UserRequest getUr() {
		return ur;
	}

	public void setUr(UserRequest ur) {
		this.ur = ur;
	}

	public Long getEquipmentMovementId() {
		return equipmentMovementId;
	}

	public void setEquipmentMovementId(Long equipmentMovementId) {
		this.equipmentMovementId = equipmentMovementId;
	}

	public Equipement getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipement equipment) {
		this.equipment = equipment;
	}

	public ServicePoint getFromServicePoint() {
		return fromServicePoint;
	}

	public void setFromServicePoint(ServicePoint fromServicePoint) {
		this.fromServicePoint = fromServicePoint;
	}

	public ServicePoint getToServicePoint() {
		return toServicePoint;
	}

	public void setToServicePoint(ServicePoint toServicePoint) {
		this.toServicePoint = toServicePoint;
	}

	public String getMovedAt() {
		return movedAt;
	}

	public void setMovedAt(String movedAt) {
		this.movedAt = movedAt;
	}
    
    
    // Constructors, getters, setters
}