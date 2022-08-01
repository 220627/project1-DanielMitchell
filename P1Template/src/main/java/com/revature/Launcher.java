package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbursementController;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
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
		
	ReimbursementController rc = new ReimbursementController();
	app.get("/ers_reimbursement", rc.getReimbursementsHandler);
	app.put("/ers_reimbursement", rc.submitReimbursementHandler);
	app.put("/ers_reimbursement/update", rc.reimbDecisionHandler);
	
	AuthController ac = new AuthController();
	app.post("/login", ac.loginHandler);
	
	
	
	}//End of Main Method
}
