package com.sk.prj.cmd;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.sk.prj.dao.BChainResidentDAO;
import com.sk.prj.dao.RunVotingHistoryDAO;
import com.sk.prj.dto.BChainResidentDTO;
import com.sk.prj.dto.RunVotingHistoryDTO;

public class BChainResidentContentCmd implements BChainResidentCmd {
    public static Logger logger = LoggerFactory.getLogger(BChainResidentContentCmd.class);


	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest httpServletRequest = (HttpServletRequest)map.get("request");
		logger.info("BChainResidentContentCmd {}", httpServletRequest);
        
		String userId = httpServletRequest.getParameter("id");
		logger.info("BChainResidentContentCmd id {}", userId);
		
		BChainResidentDAO bChainResidentDAO = new BChainResidentDAO();
		BChainResidentDTO bChainResidentDTO = bChainResidentDAO.contentView(userId);
		
		model.addAttribute("BCRContent", bChainResidentDTO);
		logger.info("BChainResidentContentCmd ...");
	}

}
