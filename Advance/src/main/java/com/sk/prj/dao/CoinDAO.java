package com.sk.prj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.sk.prj.dto.CoinDTO;
import com.sk.prj.dto.UserDTO;
import com.sk.prj.util.Constant;

public class CoinDAO {
	private static Logger logger = LoggerFactory.getLogger(UserDAO.class);
	
	public JdbcTemplate template = null;
	
	public TransactionTemplate transactionTemplate = null;

	public CoinDAO() {
		template = Constant.template;
		transactionTemplate = Constant.transactionTemplate;
	}
	
/*	
	public CoinDTO contentView(String userId) {
		logger.info("contentView : {}", userId);
		String query = "select from_id, to_id, value from accountHist where from_id = '" + userId+"' or to_id = '" + userId + "'";	
		try {
			CoinDTO coinDTO = new CoinDTO();
			coinDTO = template.queryForList(query, new BeanPropertyRowMapper<CoinDTO>(CoinDTO.class));
			return coinDTO;
		} catch (Exception e) {
			// TODO: handle exceptioSn
			e.printStackTrace();
			return null;
		}	 

    } List<Map<String, Object>>
*/    
	public List<Map<String, Object>> contentView(String userId) {
		logger.info("List<Map<String, Object>> userid : {}", userId);
		//String query = "select from_id, to_id, value, dateTime from accountHist where from_id = '" + userId+"' or to_id = '" + userId + "' order by n desc";	
		String query = "select a.from_id, a.from_name from_name, a.to_id, b.name to_name,  value, dateTime from" + 
				" (select a.n, a.from_id, b.name from_name, a.to_id, value, dateTime from accountHist a, members b" + 
				" where a.from_id=b.id) a, members b" + 
				" where a.to_id=b.id and ( from_id = '" + userId+ "' or to_id = '" + userId + "') order by a.n desc";
		try {
			//ArrayList<CoinDTO> coinDTO = (ArrayList<CoinDTO>) template.query(query, new BeanPropertyRowMapper<CoinDTO>(CoinDTO.class));
			List<Map<String, Object>> coinDTO = template.queryForList(query);
			logger.info("List<Map<String, Object>> : {}", coinDTO.get(0));
			return coinDTO;
		} catch (Exception e) {
			// TODO: handle exceptioSn
			e.printStackTrace();
			return null;
		}	 

    }	
	
	public int getBalance(String userId) {
		logger.info("getBalance", userId);
		String query = "select balance from account where id = '" + userId+"'";	
		try {
			//ArrayList<CoinDTO> coinDTO = (ArrayList<CoinDTO>) template.query(query, new BeanPropertyRowMapper<CoinDTO>(CoinDTO.class));
			int balance = template.queryForInt(query);
			return balance;
		} catch (Exception e) {
			// TODO: handle exceptioSn
			e.printStackTrace();
			return 0;
		}	 

    }	
	
	
	
	public void sendCoin(final CoinDTO coinDTO) {
		if ( transactionTemplate == null) 
		    logger.info("CoinSend : transactionTemplate is null");
		else
			logger.info("CoinSend :");

	    String query = "insert into accountHist(from_id,to_id,value,dateTime) values (?,?,?,?)" ;			
 		template.update(query, new PreparedStatementSetter() {			
 			@Override
 			public void setValues(PreparedStatement ps) throws SQLException {
 				// TODO Auto-generated method stub
 				ps.setString(1, coinDTO.getFrom_id());
 				ps.setString(2, coinDTO.getTo_id());
 				ps.setInt(3, coinDTO.getValue());
 				ps.setString(4, coinDTO.getDateTime());
 			}
 		});
	}
/*
	public UserDTO contentView(String userId) {
		logger.info("contentView : {}", userId);
		String query = "select id,name,pw,mtel,htel,dong,ho,type,validflag,createdtm,updatedtm from Resident where id = '" + userId+"'";	
		try {
			UserDTO userDTO = new UserDTO();
			userDTO = template.queryForObject(query, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
			return userDTO;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}	 

    }
	
	public ArrayList<UserDTO> list() {
		logger.info("list : {}");
		String query = "select id,name,pw,mtel,htel,dong,ho,type,validflag,createdtm,updatedtm from Resident asc" ;		
		return (ArrayList<UserDTO>) template.query(query, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	}

	public void createUser(final UserDTO userDTO) {
		if ( transactionTemplate == null) 
		    logger.info("createUser : transactionTemplate is null");
		else
			logger.info("createUser :");

	    String query = "insert into Resident(id,name,pw,mtel,htel,dong,ho,type,validflag,createdtm,updatedtm) values (?,?,?,?,?,?,?,?,?,?,?)" ;			
 		template.update(query, new PreparedStatementSetter() {			
 			@Override
 			public void setValues(PreparedStatement ps) throws SQLException {
 				// TODO Auto-generated method stub
 				ps.setString(1, userDTO.getId());
 				ps.setString(2, userDTO.getName());
 				ps.setString(3, userDTO.getPw());
 				ps.setString(4, userDTO.getMtel());
 				ps.setString(5, userDTO.getHtel());
 				ps.setString(6, userDTO.getDong());
 				ps.setString(7, userDTO.getHo());
 				ps.setString(8, userDTO.getType());
 				ps.setString(9, userDTO.getValidflag());
 				ps.setString(10, userDTO.getCreatedtm());
 				ps.setString(11, userDTO.getUpdatedtm());
 			}
 		});
	}
*/	
}
