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

import com.sk.prj.dto.ReservationDTO;
import com.sk.prj.util.Constant;

public class ReservationDAO {
	private static Logger logger = LoggerFactory.getLogger(ReservationDAO.class);
	
	public JdbcTemplate template = null;
	
	public TransactionTemplate transactionTemplate = null;

	public ReservationDAO() {
		template = Constant.template;
		transactionTemplate = Constant.transactionTemplate;
	}
	
	
	public List<Map<String, Object>> contentView(String userId) {
		logger.info("List<Map<String, Object>> userid : {}", userId);

		String query = "select name, discription, use_id, use_yn from reservation order by n asc";
		try {
			List<Map<String, Object>> reservationDTO = template.queryForList(query);
			logger.info("List<Map<String, Object>> : {}", reservationDTO.get(0));
			return reservationDTO;
		} catch (Exception e) {
			// TODO: handle exceptioSn
			e.printStackTrace();
			return null;
		}	 

    }
	
	public void rent(final ReservationDTO reservationDTO) {
		if ( transactionTemplate == null) 
		    logger.info("rent : transactionTemplate is null");
		else
			logger.info("rent :");

	    String query = "update reservation set use_id='yongdol', use_yn='y' where name=?" ;			
 		template.update(query, new PreparedStatementSetter() {			
 			@Override
 			public void setValues(PreparedStatement ps) throws SQLException {
 				// TODO Auto-generated method stub
 				ps.setString(1, reservationDTO.getName());
 			}
 		});
	}

	
	public void reTurn(final ReservationDTO reservationDTO) {
		if ( transactionTemplate == null) 
		    logger.info("reTurn : transactionTemplate is null");
		else
			logger.info("reTurn :");

	    String query = "update reservation set use_id='', use_yn='n' where name=?" ;			
 		template.update(query, new PreparedStatementSetter() {			
 			@Override
 			public void setValues(PreparedStatement ps) throws SQLException {
 				// TODO Auto-generated method stub
 				ps.setString(1, reservationDTO.getName());
 			}
 		});
	}
}
