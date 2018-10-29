/**
 * 
 */
package org.negi.zostel.messenger.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.negi.zostel.messenger.database.MySqlDbConnector;
import org.negi.zostel.messenger.model.ErrorMessage;
import org.negi.zostel.messenger.model.Profile;

/**
 * @author Jitender
 *
 */
public class ProfileService {

	
	
	public List<Profile> getAllProfiles(){
		ArrayList<Profile> profiles = new ArrayList<Profile>();
		try {
		MySqlDbConnector dbConnector = new MySqlDbConnector();
		dbConnector.getConnection();
		ResultSet rs = dbConnector.readAllProfiles();
		
		while (rs.next())
	      {
			Profile profile = new Profile();
			profile.setId(rs.getInt("UUID"));
			profile.setFirstName(rs.getString("FirstName"));
			profile.setLastName(rs.getString("LastName"));
			profile.setCreated(rs.getDate("CreationDate"));
			profile.setProfileName(rs.getString("ProfileName"));
			profile.setEmail(rs.getString("Email"));
			profiles.add(profile);
			
	      }
		}catch(Exception e) {
			e.printStackTrace();
		}
	        
		return profiles;
	}
	
}
