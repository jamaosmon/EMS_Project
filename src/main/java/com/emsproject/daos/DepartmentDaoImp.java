package com.emsproject.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.emsproject.entities.Department;

public class DepartmentDaoImp implements DepartmentDao {
	private Connection connection;
	
	public DepartmentDaoImp (Connection connectionInput) {
		this.connection = connectionInput;
	}


	@Override
	public int addDepartment(Department dep) {
		
		int returnValue=0;
		
		try {
			
			PreparedStatement stmt;
			stmt = connection.prepareStatement("insert into department values(?,?,?)");
			stmt.setInt(1, dep.getId());
			stmt.setString(2, dep.getName());
			stmt.setInt(3, dep.getTotalEmp());

			
			returnValue = stmt.executeUpdate();
			
			if(returnValue!=0) {
				System.out.println("\n *** Department Added Successfully *** \n \n");
				System.out.println("Returning Back to Menu... \n");
			}
				
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		
		return returnValue;
	}

	@Override
	public List<Department> viewAllDepartment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateDepartment() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeDepartment(int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int totalEmpCount(int id) throws SQLException {
		int totalEmpCount = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = connection.prepareStatement("select count(*) as totalEmp from employee where departmentId= ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				totalEmpCount = rs.getInt("totalEmp");
			} 
			
			PreparedStatement updateStmt = connection.prepareStatement("update department set totalEmp = ? where id = ?");
	        updateStmt.setInt(1, totalEmpCount);
	        updateStmt.setInt(2, id);
	        updateStmt.executeUpdate();
	        
		} finally {
			if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
			
			return totalEmpCount;
			
			
	}



}
