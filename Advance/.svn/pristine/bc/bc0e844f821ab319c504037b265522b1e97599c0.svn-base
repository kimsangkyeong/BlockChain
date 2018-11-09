package com.sk.prj.cmd;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.sk.prj.dao.VotingAgendaDAO;
import com.sk.prj.dto.VotingAgendaDTO;

public class VoteAgentListCmd implements VoteAgentCmd {
    public static Logger logger = LoggerFactory.getLogger(VoteAgentListCmd.class);

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest httpServletRequest = (HttpServletRequest)map.get("request");
		logger.info("VoteAgentListCmd {}", httpServletRequest);
        
		String userId = httpServletRequest.getParameter("id");
		VotingAgendaDAO dao = new VotingAgendaDAO();
		ArrayList<VotingAgendaDTO> dtos = dao.list(userId);
		
		model.addAttribute("id", userId);  
		model.addAttribute("contents",dtos);
		logger.info("VoteAgentListCmd dtos - {}", dtos.size());
		logger.info("VoteAgentListCmd dtos - {}", dtos.get(0).getTitle());
		logger.info("VoteAgentListCmd dtos - {}", dtos.get(1).getTitle());
		model.addAttribute("view", "/user/vote/votelist");  
	}

}
