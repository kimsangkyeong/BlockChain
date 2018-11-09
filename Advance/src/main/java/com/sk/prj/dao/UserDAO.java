package com.sk.prj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

import com.sk.prj.dto.UserDTO;
import com.sk.prj.util.Constant;

public class UserDAO {
	private static Logger logger = LoggerFactory.getLogger(UserDAO.class);
	
	public JdbcTemplate template = null;
	
	public TransactionTemplate transactionTemplate = null;

	public UserDAO() {
		template = Constant.template;
		transactionTemplate = Constant.transactionTemplate;
	}
	

	public UserDTO contentView(String userId) {
		logger.info("contentView : {}", userId);
		String query = " select id,name,pw,mtel,htel,dong,ho,type,validflag,createdtm,updatedtm " +
		               " from   Resident " +
				       " where  id = '" + userId+"' "+
		               " and    validflag = 'Y'";	
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
		String query = " select id,name,pw,mtel,htel,dong,ho,type,validflag,createdtm,updatedtm " +
		               " from   Resident asc" ;		
		return (ArrayList<UserDTO>) template.query(query, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	}
	
	public void createUser(final UserDTO userDTO) {
		if ( transactionTemplate == null) 
		    logger.info("createUser : transactionTemplate is null");
		else
			logger.info("createUser :");

	    String query = " insert into Resident(id,name,pw,mtel,htel,dong,ho,type,validflag,createdtm,updatedtm) " +
	                   " values (?,?,?,?,?,?,?,?,?,?,?)" ;			
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
	
/*	
	DataSource datasource;
	
	public UserDAO() {
		
		Context context;
		try {
			context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/tomcat9");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public UserDTO contentView(String userId) {
		UserDTO userDTO = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = datasource.getConnection();
			String query = "select id,name,pw,mtel,htel,dong,ho,type,validflag,createdtm,updatedtm from Resident where id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				userDTO = new UserDTO();
				userDTO.setId(resultSet.getString("id"));
				userDTO.setName(resultSet.getString("name"));
				userDTO.setPw(resultSet.getString("pw"));
				userDTO.setMtel(resultSet.getString("mtel"));
				userDTO.setHtel(resultSet.getString("htel"));
				userDTO.setDong(resultSet.getString("dong"));
				userDTO.setHo(resultSet.getString("ho"));
				userDTO.setType(resultSet.getString("type"));
				userDTO.setValidflag(resultSet.getString("validflag"));
				userDTO.setCreatedtm(resultSet.getString("createdtm"));
				userDTO.setUpdatedtm(resultSet.getString("updatedtm"));			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
    	} finally {
    		try {
    			if ( resultSet != null ) resultSet.close();
    			if ( preparedStatement != null) preparedStatement.close();
    			if ( connection != null) connection.close();			
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}		
		return userDTO;
	}
*/
}
