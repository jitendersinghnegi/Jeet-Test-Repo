/**
 * 
 */
package org.negi.zostel.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.negi.zostel.messenger.database.DatabaseClass;
import org.negi.zostel.messenger.model.ErrorMessage;
import org.negi.zostel.messenger.model.Profile;

/**
 * @author Jitender
 *
 */
public class ProfileService {

	private Map<String,Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("Jitender", new Profile(1L, "Jitender", "Jitender", "Negi"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	public Profile getProfile(String profileName) {
		ErrorMessage errorMessage = new ErrorMessage("Not Found",404,"www.google.com");
		Response response = Response.status(Status.NOT_FOUND).entity(errorMessage).build();
		Profile profile = profiles.get(profileName);
		if(null == profile) {
			throw new WebApplicationException(response);
		}
		return profiles.get(profileName);
	}
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
