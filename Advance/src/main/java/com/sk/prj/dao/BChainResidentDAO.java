package com.sk.prj.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;

import com.sk.prj.dto.BChainAdmAcntDTO;
import com.sk.prj.dto.BChainResidentDTO;
import com.sk.prj.dto.RunVotingHistoryDTO;
import com.sk.prj.util.Constant;

public class BChainResidentDAO {
	private static Logger logger = LoggerFactory.getLogger(BChainResidentDAO.class);
	
	public JdbcTemplate template = null;
	
	public TransactionTemplate transactionTemplate = null;

	public BChainResidentDAO() {
		super();
		// TODO Auto-generated constructor stub
		template = Constant.template;
		transactionTemplate = Constant.transactionTemplate;
	}

	public BChainResidentDTO contentView(String userId) {
		logger.info("contentView : userId {}", userId);
		String query = " select id, seq, bacnt, validflag, createdtm, deletedtm " +
		               " from   BChainResident " +
				       " where  id = '" + userId +"' " +
		               " and    validflag = 'Y' " +
				       " and    seq = '1' ";	

		try {
			BChainResidentDTO bChainResidentDTO = new BChainResidentDTO();
			bChainResidentDTO = template.queryForObject(query, new BeanPropertyRowMapper<BChainResidentDTO>(BChainResidentDTO.class));
			return bChainResidentDTO;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}	 
		
	}
	
	public BChainAdmAcntDTO getAdminContent() {
		logger.info("getAdminContent - BChainAdmAcntDTO ");
		String query = " select a.bacnt bchacnt, b.pw pswd " +
	                   " from   BChainResident a, Resident b " +
			           " where  a.id = b.id " +
	                   " and    a.seq = 1 " +
			           " and    a.validflag = 'Y' " +
	                   " and    b.validflag = 'Y' ";	

	    try {
	    	BChainAdmAcntDTO bChainAdmAcntDTO = new BChainAdmAcntDTO();
	    	bChainAdmAcntDTO = template.queryForObject(query, new BeanPropertyRowMapper<BChainAdmAcntDTO>(BChainAdmAcntDTO.class));
	    	return bChainAdmAcntDTO;
	    } catch (Exception e) {
	    	// TODO: handle exception
		    e.printStackTrace();
	    	return null;
    	}	 
	}
	
	public BChainResidentDTO getAdminContent2() {
		logger.info("getAdminContent2 - BChainResidentDTO ");
		String query = " select a.id id, a.seq seq, a.bacnt bacnt , a.validflag validflag , a.createdtm createdtm, a.deletedtm deletedtm " +
	                   " from   BChainResident a, Resident b " +
			           " where  a.id = b.id " +
	                   " and    a.seq = 1 " +
			           " and    a.validflag = 'Y' " +
	                   " and    b.validflag = 'Y' ";	

	    try {
    		BChainResidentDTO bChainResidentDTO = new BChainResidentDTO();
	    	bChainResidentDTO = template.queryForObject(query, new BeanPropertyRowMapper<BChainResidentDTO>(BChainResidentDTO.class));
	    	return bChainResidentDTO;
	    } catch (Exception e) {
	    	// TODO: handle exception
		    e.printStackTrace();
	    	return null;
    	}	 
	}

}
