package com.sk.prj.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.transaction.support.TransactionTemplate;

import com.sk.prj.dto.RunVotingHistoryDTO;
import com.sk.prj.util.Constant;

public class RunVotingHistoryDAO {
	private static Logger logger = LoggerFactory.getLogger(RunVotingHistoryDAO.class);
	
	public JdbcTemplate template = null;
	
	public TransactionTemplate transactionTemplate = null;

	public RunVotingHistoryDAO() {
		super();
		// TODO Auto-generated constructor stub
		template = Constant.template;
		transactionTemplate = Constant.transactionTemplate;
	}
	
	public RunVotingHistoryDTO contentView(String vaId, String userId) {
		logger.info("contentView : userId {}, vaId {}", userId, vaId);
		String query = " select vaid, id, bvoteacnt, voteflag, createdtm " +
		               " from   RunVotingHistory " +
				       " where  vaid = '" + vaId +"' " +
		               " and    id = '" + userId +"' ";	
		try {
			RunVotingHistoryDTO runVotingHistoryDTO = new RunVotingHistoryDTO();
			runVotingHistoryDTO = template.queryForObject(query, new BeanPropertyRowMapper<RunVotingHistoryDTO>(RunVotingHistoryDTO.class));
			return runVotingHistoryDTO;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}	 

    }
	
	public void CreateRunVotingHistory(final RunVotingHistoryDTO runVotingHistoryDTO) {
	    String query = " insert into RunVotingHistory(vaid,id,bvoteacnt,voteflag,createdtm) " +
	                   " values (?,?,?,?,?)" ;			
 		template.update(query, new PreparedStatementSetter() {			
 			@Override
 			public void setValues(PreparedStatement ps) throws SQLException {
 				// TODO Auto-generated method stub
 				ps.setString(1, runVotingHistoryDTO.getVaid());
 				ps.setString(2, runVotingHistoryDTO.getId());
 				ps.setString(3, runVotingHistoryDTO.getBvoteacnt());
 				ps.setString(4, runVotingHistoryDTO.getVoteflag());
 				ps.setString(5, runVotingHistoryDTO.getCreatedtm());
 			}
 		});
	}

	public void ModifyRunVotingHistory(final RunVotingHistoryDTO runVotingHistoryDTO) {
	    String query = " update RunVotingHistory " +
	                   " set    voteflag = 'Y' " +
	    		       " where  vaid = ? " +
	                   " and    id   = ? " ;			
 		template.update(query, new PreparedStatementSetter() {			
 			@Override
 			public void setValues(PreparedStatement ps) throws SQLException {
 				// TODO Auto-generated method stub
 				ps.setString(1, runVotingHistoryDTO.getVaid());
 				ps.setString(2, runVotingHistoryDTO.getId());;
 			}
 		});
	}

}
