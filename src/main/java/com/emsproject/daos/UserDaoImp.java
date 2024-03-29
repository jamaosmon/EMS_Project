package com.emsproject.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.emsproject.entities.User;

public class UserDaoImp implements UserDao{

	private Connection connection;
	public  UserDaoImp(Connection connectionInput) {
		this.connection = connectionInput;
	}
	
	



    @Override
    public User getUserByUsername(String username) {
        String query = "select * from user where username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    String retrievedUsername = resultSet.getString("username");
                    String retrievedPassword = resultSet.getString("password");
          
                    return new User(retrievedUsername, retrievedPassword);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addUser(User user) {
		int returnValue=0;
	
		
		try {
			
			PreparedStatement stmt;
			stmt = connection.prepareStatement("insert into user values(?,?)");
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
		
			
			returnValue = stmt.executeUpdate();
			
			if(returnValue!=0) {
				System.out.println("\n *** User Added Successfully *** \n \n");
				System.out.println("Returning Back to Menu... \n");
			}
				
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		
		return returnValue;
	
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}

}
