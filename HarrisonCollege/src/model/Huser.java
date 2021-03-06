package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the HUSER database table.
 * 
 */
@Entity
@Table(name="Huser", schema="testuserdb")
@NamedQuery(name="Huser.findAll", query="SELECT h FROM Huser h")
public class Huser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String netid;

	private String userpwd;

	private int usertype;

	public Huser() {
	}

	public String getNetid() {
		return this.netid;
	}

	public void setNetid(String netid) {
		this.netid = netid;
	}

	public String getUserpwd() {
		return this.userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public int getUsertype() {
		return this.usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}

}