package com.example.actorList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Actor {
	
	// Main fields
	// id
	// completeName
	// detail
	
	@Id  // this attribute is an identifier 
	@GeneratedValue(strategy=GenerationType.AUTO) // attribute value generated automatically
	private Long id;
	private String completeName;
	private String detail;
	private String watcher; // who has watched a film for this actor
	
	// CHECK !!!!!!!!!!!!!!
	// constructor
	/*public Actor(String completeName, String detail)
	{
		this.completeName = completeName;
		this.detail = detail;
	}*/
	
	public Actor(){}
	
	// for fake data
	public Actor(String completeName, String detail, String watcher)
	{
		this.completeName = completeName;
		this.detail = detail;
		this.watcher = watcher;
	}
	
	/*
	public Actor(Long id, String completeName, String detail, String watcher)
	{
		this.id = id;
		this.completeName = completeName;
		this.detail = detail;
		this.watcher = watcher;
	}
	*/
	
	// getter and setters methods  -> ALT + Shift + S
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompleteName() {
		return completeName;
	}
	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getWatcher() {
		return watcher;
	}
	public void setWatcher(String watcher) {
		this.watcher = watcher;
	}

}
