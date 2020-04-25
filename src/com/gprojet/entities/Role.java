package com.gprojet.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="")
public class Role {

	@Id
	@GeneratedValue
	@Column(name="ID_ROLE")
	private int id_role;
	@Column(name="ROLE")
	private String role;
	@Column(name="DISCRIPTION")
	private String discription;
	
	@OneToMany(mappedBy="role", fetch=FetchType.EAGER)
    private List<Utilisateur>utilisateurs=new ArrayList<Utilisateur>();

	public int getId_role() {
		return id_role;
	}

	public void setId_role(int id_role) {
		this.id_role = id_role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Role() {
		super();
	}

	public Role(int id_role, String role, String discription) {
		super();
		this.id_role = id_role;
		this.role = role;
		this.discription = discription;
	}
	
	

	
    
		
}
