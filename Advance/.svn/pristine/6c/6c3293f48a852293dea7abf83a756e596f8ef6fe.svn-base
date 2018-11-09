package com.sk.prj.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;

import com.sk.prj.dto.BallotDTO;
import com.sk.prj.dto.BallotItemsDTO;
import com.sk.prj.dto.UserDTO;
import com.sk.prj.dto.VotingAgendaDTO;
import com.sk.prj.util.Constant;

public class BallotDAO {
	private static Logger logger = LoggerFactory.getLogger(BallotDAO.class);
	
	public JdbcTemplate template = null;
	
	public TransactionTemplate transactionTemplate = null;

	public BallotDAO() {
		super();
		// TODO Auto-generated constructor stub
		template = Constant.template;
		transactionTemplate = Constant.transactionTemplate;
	}
 
	public BallotDTO contentView(String ballotId) {
		logger.info("contentView : ballotId {}", ballotId);
		String query = " select ballotid, iteminfo, bctractflag, bcontractid, regdtm " +
		               " from   Ballot " +
				       " where  ballotid = '" + ballotId+"'";	
		try {
			BallotDTO ballotDTO = new BallotDTO();
			ballotDTO = template.queryForObject(query, new BeanPropertyRowMapper<BallotDTO>(BallotDTO.class));
			return ballotDTO;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}	 
		
	}
	
	// 투표가능 목록 리스트 조회하기 - 투표기간 및 투표대상에 포함되는 경우만
	public ArrayList<BallotItemsDTO> ballotItemList(String ballotId) {
		logger.info("ballotItemList : entered");
		logger.info("ballotItemList : condition {}", ballotId);

		String query = " select ballotid, seq, item, bcandidate, regdtm " +
				       " from   BallotItems " + 
				       " where  ballotid = '" + ballotId + "' " ;
		
		return (ArrayList<BallotItemsDTO>) template.query(query, new BeanPropertyRowMapper<BallotItemsDTO>(BallotItemsDTO.class));
	}
}
