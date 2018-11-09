package com.sk.prj.cmd;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.sk.prj.dao.RunVotingHistoryDAO;
import com.sk.prj.dao.UserDAO;
import com.sk.prj.dto.RunVotingHistoryDTO;
import com.sk.prj.dto.UserDTO;

public class RunVotingHistoryCreateCmd implements RunVotingHistoryCmd {
    public static Logger logger = LoggerFactory.getLogger(RunVotingHistoryCreateCmd.class);
    
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest httpServletRequest = (HttpServletRequest)map.get("request");
		logger.info("RunVotingHistoryCreateCmd {}", httpServletRequest);
		
		RunVotingHistoryDTO runVotingHistoryDTO = new RunVotingHistoryDTO();
		runVotingHistoryDTO.setVaid(httpServletRequest.getParameter("vaid"));
		runVotingHistoryDTO.setId(httpServletRequest.getParameter("id"));
		runVotingHistoryDTO.setBvoteacnt((String)map.get("bvoteacnt"));
		runVotingHistoryDTO.setVoteflag("N");
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		runVotingHistoryDTO.setCreatedtm(sdf.format(date));
	    		
		logger.info("RunVotingHistoryCreateCmd {}", runVotingHistoryDTO.toString());
		
		RunVotingHistoryDAO runVotingHistoryDAO = new RunVotingHistoryDAO();
		runVotingHistoryDAO.CreateRunVotingHistory(runVotingHistoryDTO);
	}

}
