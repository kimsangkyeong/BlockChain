package com.sk.prj.cmd;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.sk.prj.dao.RunVotingHistoryDAO;
import com.sk.prj.dto.RunVotingHistoryDTO;

public class RunVotingHistoryModifyCmd implements RunVotingHistoryCmd {
    public static Logger logger = LoggerFactory.getLogger(RunVotingHistoryModifyCmd.class);

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest httpServletRequest = (HttpServletRequest)map.get("request");
		logger.info("RunVotingHistoryCreateCmd {}", httpServletRequest);
		
		RunVotingHistoryDTO runVotingHistoryDTO = new RunVotingHistoryDTO();
		runVotingHistoryDTO.setVaid(httpServletRequest.getParameter("vaid"));
		runVotingHistoryDTO.setId(httpServletRequest.getParameter("id"));
	    		
		logger.info("RunVotingHistoryModifyCmd {}", runVotingHistoryDTO.toString());
		
		RunVotingHistoryDAO runVotingHistoryDAO = new RunVotingHistoryDAO();
		runVotingHistoryDAO.ModifyRunVotingHistory(runVotingHistoryDTO);
	}

}
