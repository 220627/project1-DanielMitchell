package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.daos.ReimbursementDAO;
import com.revature.daos.UserDAO;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		UserDAO uDAO = new UserDAO();
		ReimbursementDAO rDAO = new ReimbursementDAO();
		
		System.out.println("========Welcome to the Employee Reimbursement Management System (ERS)===========");
		
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("CONNECTION SUCCESSFUL :)");
		} catch (SQLException e) {
			System.out.println("CONNECTION FAILED...");
			e.printStackTrace();
		} //End of the connection test
			
		Javalin app = Javalin.create(config -> {
					config.enableCorsForAllOrigins();
				}).start(3000); 
	}
}//End of Main Method
