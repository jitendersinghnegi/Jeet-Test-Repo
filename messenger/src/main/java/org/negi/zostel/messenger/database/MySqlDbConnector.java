/**
 * 
 */
package org.negi.zostel.messenger.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.glassfish.hk2.utilities.reflection.Logger;
import org.negi.zostel.messenger.model.Profile;

/**
 * @author Jitender
 *This class creates connection between the application and the MySql DB
 */
public class MySqlDbConnector {
	private static final String CONNECT_URL="jdbc:mysql://localhost:3306/JeetDB";
	private static final String DB_USER="root";
	private static final String DB_USER_PWD="ebs1@967";
	
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			connect = DriverManager.getConnection(  
					CONNECT_URL,DB_USER,DB_USER_PWD);
		}catch(Exception e) {
			Logger.getLogger().debug(e.getMessage());
		}
		return connect;	
	}
	
	public void writeBasicProfileinDB(Profile profile) {
		// PreparedStatements can use variables and are more efficient
        try {
        	String query = " insert into JeetDB.BasicProfile (FirstName, LastName, Email, CreationDate,ProfileName)"
        	        + " values (?, ?, ?, ?, ?)";
			preparedStatement = connect
			        .prepareStatement(query);
			preparedStatement.setString(1, profile.getFirstName());
	        preparedStatement.setString(2, profile.getLastName());
	        preparedStatement.setString(3, profile.getEmail());
	        preparedStatement.setDate(4, new java.sql.Date(Calendar.DATE));
	        preparedStatement.setString(5, profile.getProfileName());
	        preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
        finally {
            close();
        }
       
        
	}
	
	public ResultSet readAllProfiles() {
		String query="select * from JeetDB.BasicProfile";
		try {
			preparedStatement = connect.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultSet;
		
	}
	
	
	
	private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

	
	
	

}
