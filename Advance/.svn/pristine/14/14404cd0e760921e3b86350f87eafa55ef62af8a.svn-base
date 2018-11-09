package com.sk.prj.cmd;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.sk.prj.dao.VotingAgendaDAO;
import com.sk.prj.dto.VotingAgendaDTO;
import com.sk.prj.dto.VotingAgendaForResidentDTO;

public class VoteAgentListrCmd implements VoteAgentCmd {
    public static Logger logger = LoggerFactory.getLogger(VoteAgentListrCmd.class);

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest httpServletRequest = (HttpServletRequest)map.get("request");
		logger.info("VoteAgentListrCmd {}", httpServletRequest);
        
		String userId = httpServletRequest.getParameter("id");
		VotingAgendaDAO dao = new VotingAgendaDAO();
		ArrayList<VotingAgendaForResidentDTO> dtos = dao.listr(userId);
		
		model.addAttribute("id", userId);  
		model.addAttribute("contents",dtos);
		logger.info("VoteAgentListrCmd dtos - {}", dtos.size());
		model.addAttribute("view", "/user/vote/votelist");  
	}

}
