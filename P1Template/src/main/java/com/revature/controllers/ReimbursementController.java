package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.daos.ReimbursementDAO;
import com.revature.models.Reimbursement;

import io.javalin.http.Handler;

public class ReimbursementController {
	
	ReimbursementDAO rDAO = new ReimbursementDAO();
	
	public Handler getReimbursementsHandler = (ctx) -> {
		
		//if(AuthController.ses != null) { 
			
			ArrayList<Reimbursement> reimbursements = rDAO.getReimbursements();
			
			Gson gson = new Gson();
			
			String JSONreimbursements = gson.toJson(reimbursements); 
			
			ctx.result(JSONreimbursements); 
			ctx.status(200);
			/*} else { 
				ctx.result("PLEASE LOG IN");
				ctx.status(401); 
			}*/
	};

}
