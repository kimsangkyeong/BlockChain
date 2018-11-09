package com.sk.prj.cmd;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.sk.prj.dao.RunVotingHistoryDAO;
import com.sk.prj.dao.UserDAO;
import com.sk.prj.dto.RunVotingHistoryDTO;
import com.sk.prj.dto.UserDTO;

public class RunVotingHistoryContentCmd implements RunVotingHistoryCmd {
    public static Logger logger = LoggerFactory.getLogger(RunVotingHistoryContentCmd.class);

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest httpServletRequest = (HttpServletRequest)map.get("request");
		logger.info("RunVotingHistoryContentCmd {}", httpServletRequest);
        
		String userId = httpServletRequest.getParameter("id");
		String vaId = httpServletRequest.getParameter("vaid");
		
		logger.info("RunVotingHistoryContentCmd id {}, vaid {}", userId, vaId);
		
		RunVotingHistoryDAO runVotingHistoryDAO = new RunVotingHistoryDAO();
		RunVotingHistoryDTO runVotingHistoryDTO = runVotingHistoryDAO.contentView(vaId, userId);
		
		model.addAttribute("RVHContent", runVotingHistoryDTO);
		logger.info("RunVotingHistoryContentCmd ...");
	}

}
