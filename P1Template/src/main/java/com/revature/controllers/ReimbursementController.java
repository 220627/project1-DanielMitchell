package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.daos.ReimbursementDAO;
import com.revature.models.Reimbursement;

import io.javalin.http.Handler;

public class ReimbursementController {
	
	ReimbursementDAO rDAO = new ReimbursementDAO();
	
	public Handler getReimbursementsHandler = (ctx) -> {
		
		if(AuthController.ses != null) { 
			
			ArrayList<Reimbursement> reimbursements = rDAO.getReimbursements();
			
			Gson gson = new Gson();
			
			String JSONreimbursements = gson.toJson(reimbursements); 
			
			ctx.result(JSONreimbursements); 
			ctx.status(200);
			} else { 
				ctx.result("PLEASE LOG IN");
				ctx.status(401); 
			}
	};

	public Handler submitReimbursementHandler = (ctx) -> {
		if(AuthController.ses != null) { 
			
			
			String body = ctx.body();
			
			Gson gson = new Gson();
		
			Reimbursement newReimb = gson.fromJson(body, Reimbursement.class);
			
			
			if(rDAO.submitReimb(newReimb)) {
				//return a successful status code
				ctx.status(202); //202 stands for "accepted"
			} else {
				ctx.status(406); //406 stands for "Not Acceptable", AKA whatever the user sent couldn't be added to the DB
			}
			
			
		} else { 
			ctx.result("PLEASE LOG IN");
			ctx.status(401); 
		}
	};

	public Handler reimbDecisionHandler;
	

}
