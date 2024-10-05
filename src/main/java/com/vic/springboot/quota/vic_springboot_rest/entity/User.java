package com.vic.springboot.quota.vic_springboot_rest.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="firstname")
    private String firstname;
    
    @Column(name="lastname")
    private String lastname;
    
    @Column(name="requestcountone")
    private int requestcountone;
    
    @Column(name="requestcounttwo")
    private int requestcounttwo;    
    
    
    public User() {
    	
    }

    
	public User(int id, String firstname, String lastname) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	
	public User(int id, String firstname, String lastname, int requestcountone, int requestcounttwo) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.requestcountone = requestcountone;
		this.requestcounttwo = requestcounttwo;
	}


	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public int getRequestcountone() {
		return requestcountone;
	}


	public void setRequestcountone(int requestcountone) {
		this.requestcountone = requestcountone;
	}


	public int getRequestcounttwo() {
		return requestcounttwo;
	}


	public void setRequestcounttwo(int requestcounttwo) {
		this.requestcounttwo = requestcounttwo;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", requestcountone="
				+ requestcountone + ", requestcounttwo=" + requestcounttwo + "]";
	}


	
	
	

}
