package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.utils.ConnectionUtil;

public class ReimbursementDAO implements ReimbursementDAOInterface {
	
	public static Logger log = LogManager.getLogger(); //<------ use

	@Override
	public ArrayList<Reimbursement> getReimbursements() {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM \"ERS\".ers_reimbursement;";

			Statement s = conn.createStatement(); 
			ResultSet rs = s.executeQuery(sql);

			ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
			
			while(rs.next()) {
				
				Reimbursement r = new Reimbursement(
							rs.getInt("reimb_id"),
							rs.getInt("reimb_amount"),
							rs.getString("reimb_submitted"),
							rs.getString("reimb_description"),
							rs.getInt("reimb_author"),
							rs.getInt("reimb_resolver"),
							null,
							null
						);
						
				int reimbStatusFK = rs.getInt("reimb_status_id_fk");
				int reimbTypeFK = rs.getInt("reimb_type_id_fk");
				
				ReimbursementDAO rDAO = new ReimbursementDAO();
				
				ReimbursementStatus RS = rDAO.getReimbStatus(reimbStatusFK);
				ReimbursementType RT = rDAO.getReimbType(reimbTypeFK);
				
				
				r.setReimbursement_status(RS);
				r.setReimbursement_type(RT);
				reimbursementList.add(r);
				
			}
			log.info("User Got All Reimbursements");
			return reimbursementList;
			
		} catch (SQLException e) {
			System.out.println("SOMETHING WENT WRONG GETTING REIMBURSEMENTS");
			e.printStackTrace(); 
		}
		
		return null;
	} //End of getReimbursements()
	
	@Override
	public ReimbursementStatus getReimbStatus(int id) {
		
		
		try(Connection conn = ConnectionUtil.getConnection()){
		
			String sql = "select * from \"ERS\".ers_reimbursement_status where reimb_status_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				ReimbursementStatus rStatus = new ReimbursementStatus(
						rs.getInt("reimb_status_id"),
						rs.getString("reimb_status")
					); 
				return rStatus;	
			}
		} catch (SQLException e) {
			System.out.println("GETTING REIMBURSEMENT STATUS FAILED"); 
			e.printStackTrace(); 
		}
		
		return null;
		
	} //end of getReimbStatus()
	
	@Override
	public ReimbursementType getReimbType(int id) {
		
		
		try(Connection conn = ConnectionUtil.getConnection()){
		
			String sql = "select * from \"ERS\".ers_reimbursement_type where reimb_type_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				ReimbursementType rType = new ReimbursementType(
						rs.getInt("reimb_type_id"),
						rs.getString("reimb_type")
					); 
				return rType;	
			}
		} catch (SQLException e) {
			System.out.println("GETTING REIMBURSEMENT TYPE FAILED"); 
			e.printStackTrace(); 
		}
		
		return null;
		
	}
}
