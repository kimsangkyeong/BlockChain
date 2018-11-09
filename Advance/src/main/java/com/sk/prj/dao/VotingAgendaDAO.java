package com.sk.prj.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;

import com.sk.prj.dto.UserDTO;
import com.sk.prj.dto.VotingAgendaDTO;
import com.sk.prj.dto.VotingAgendaForResidentDTO;
import com.sk.prj.util.Constant;

public class VotingAgendaDAO {
	private static Logger logger = LoggerFactory.getLogger(VotingAgendaDAO.class);
	
	public JdbcTemplate template = null;
	
	public TransactionTemplate transactionTemplate = null;

	public VotingAgendaDAO() {
		super();
		// TODO Auto-generated constructor stub
		template = Constant.template;
		transactionTemplate = Constant.transactionTemplate;
	}

	// 투표가능 목록 리스트 조회하기 - 투표기간 및 투표대상에 포함되는 경우만
	public ArrayList<VotingAgendaDTO> list(String userId) {
		logger.info("list : entered");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");	
		String currDtm = sdf.format(date);
		logger.info("list : condition {}, {}", userId, currDtm);

		String query = "select vaid,title,desp,votetype,votesdtm,voteedtm,voterange,ballotid,regdtm " +
				       "from   VotingAgenda " + 
				       "where '" + currDtm + "' between votesdtm and voteedtm "+ 
				       "and   (  voterange = 'A' " + 
	   			       "      or voterange = ( select dong from Resident where id = '" + userId + "' ) ) ";
		
		return (ArrayList<VotingAgendaDTO>) template.query(query, new BeanPropertyRowMapper<VotingAgendaDTO>(VotingAgendaDTO.class));
	}

	// 투표가능 목록 리스트 조회하기 - 투표기간 및 투표대상에 포함되는 경우만
	public ArrayList<VotingAgendaForResidentDTO> listr(String userId) {
		logger.info("list : entered");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");	
		String currDtm = sdf.format(date);
		logger.info("list : condition {}, {}", userId, currDtm);

		String query = "select a.vaid vaid,title,desp,votetype,votesdtm,voteedtm,voterange,ballotid,regdtm,voteflag " +
				       "from   VotingAgenda a left join RunVotingHistory b on  ( a.vaid = b.vaid ) " + 
				       "where '" + currDtm + "' between votesdtm and voteedtm "+ 
				       "and   (  voterange = 'A' " + 
	   			       "      or voterange = ( select dong from Resident where id = '" + userId + "' ) ) ";
		
		return (ArrayList<VotingAgendaForResidentDTO>) template.query(query, new BeanPropertyRowMapper<VotingAgendaForResidentDTO>(VotingAgendaForResidentDTO.class));
	}

}
