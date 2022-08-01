package com.revature.models;

public class Reimbursement {
	
	private int reimb_id;
	private int reimb_amount;
	private String reimb_submitted; 
	private String reimb_description;
	private int reimb_author;
	private int reimb_resolver;
	private ReimbursementStatus reimbursement_status;
	private ReimbursementType reimbursement_type;
	
	
	private int reimb_status_id_fk;
	private int reimb_type_id_fk;
	
	public Reimbursement() {
		super();
	}
	
	public Reimbursement(int reimb_id, int reimb_amount, String reimb_submitted, String reimb_description,
			int reimb_author, int reimb_resolver, ReimbursementStatus reimbuirsement_status,
			ReimbursementType reimbursement_type) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_description = reimb_description;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimbursement_status = reimbuirsement_status;
		this.reimbursement_type = reimbursement_type;
	}
	
	public int getReimb_id() {
		return reimb_id;
	}
	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}
	public int getReimb_amount() {
		return reimb_amount;
	}
	public void setReimb_amount(int reimb_amount) {
		this.reimb_amount = reimb_amount;
	}
	public String getReimb_submitted() {
		return reimb_submitted;
	}
	public void setReimb_submitted(String reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}
	public String getReimb_description() {
		return reimb_description;
	}
	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}
	public int getReimb_author() {
		return reimb_author;
	}
	public void setReimb_author(int reimb_author) {
		this.reimb_author = reimb_author;
	}
	public int getReimb_resolver() {
		return reimb_resolver;
	}
	public void setReimb_resolver(int reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}
	public ReimbursementStatus getReimbuirsement_status() {
		return reimbursement_status;
	}
	public void setReimbursement_status(ReimbursementStatus reimbuirsement_status) {
		this.reimbursement_status = reimbuirsement_status;
	}
	public ReimbursementType getReimbursement_type() {
		return reimbursement_type;
	}
	public void setReimbursement_type(ReimbursementType reimbursement_type) {
		this.reimbursement_type = reimbursement_type;
	}
	public int getReimb_type_id_fk() {
		return reimb_type_id_fk;
	}
	public void setReimb_type_id_fk(int reimb_type_id_fk) {
		this.reimb_type_id_fk = reimb_type_id_fk;
	}
	public int getReimb_status_id_fk() {
		return reimb_status_id_fk;
	}
	public void setReimb_status_id_fk(int reimb_status_id_fk) {
		this.reimb_status_id_fk = reimb_status_id_fk;
	}
}//End of Reimbursement
