package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;

public interface ReimbursementDAOInterface {
	ArrayList<Reimbursement> getReimbursements();

	ReimbursementStatus getReimbStatus(int id);

	ReimbursementType getReimbType(int id);

	boolean submitReimb(Reimbursement newReimb);

	void updateReimbStatus(Reimbursement newReimbStatus);

}
