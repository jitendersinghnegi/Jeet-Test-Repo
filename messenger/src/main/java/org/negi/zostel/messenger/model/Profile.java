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
	private long id;
	private String profileName;
	private String firstNane;
	private String lastName;
	private Date created;
	
	public Profile() {
		
	}

	public Profile(long id, String profileName, String firstNane, String lastName) {
		this.id = id;
		this.profileName = profileName;
		this.firstNane = firstNane;
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getFirstNane() {
		return firstNane;
	}

	public void setFirstNane(String firstNane) {
		this.firstNane = firstNane;
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
