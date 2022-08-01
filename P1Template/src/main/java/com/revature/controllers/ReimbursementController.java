package com.revature.controllers;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.revature.daos.ReimbursementDAO;
import com.revature.models.Reimbursement;

import io.javalin.http.Handler;

public class ReimbursementController {
	
	public static Logger log = LogManager.getLogger();
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
				ctx.status(202);
			} else {
				ctx.status(406);
			}
			
		} else { 
			ctx.result("PLEASE LOG IN");
			ctx.status(401); 
		}
	};


	public Handler reimbDecisionHandler = (ctx) -> {
		if(AuthController.ses != null) {
			
			String update = ctx.pathParam("");
			
			String decision = ctx.body(); 
			if(rDAO.updateReimbStatus(update, decision)) {
				ctx.status(202);
			} else {
				ctx.status(406);
			}
			
			
			
				
			log.info("Reimbursement Decision Submitted");
		} else { 
			ctx.result("PLEASE LOG IN");
			ctx.status(401); 
		}
	};
}
