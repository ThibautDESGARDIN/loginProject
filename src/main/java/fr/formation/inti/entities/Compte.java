package fr.formation.inti.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "LOGIN")
public class Compte implements Serializable {

	private Integer user_ID;
	private String user;	
	private String pass;

	public Compte() {}
	
	
	public Compte(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	public Integer getUser_ID() {
		return user_ID;
	}
	
	public void setUser_ID(Integer user_ID) {
		this.user_ID = user_ID;
	}
	
	@Column(name = "USER", nullable = false)
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	@Column(name = "PASS", nullable = false)
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}


	@Override
	public String toString() {
		return "Database [user=" + user + ", pass=" + pass + "]";
	}

	}
