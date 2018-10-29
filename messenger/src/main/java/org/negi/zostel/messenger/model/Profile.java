/**
 * 
 */
package org.negi.zostel.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Jitender
 *
 */
@XmlRootElement
public class Profile {
	private int id;
	private String profileName;
	private String firstName;
	private String lastName;
	private String email;
	private Date created;
	
	public Profile() {
		
	}

	public Profile(int id, String profileName, String firstNane, String lastName) {
		this.id = id;
		this.profileName = profileName;
		this.firstName = firstNane;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	

}
