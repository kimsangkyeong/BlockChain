package com.sk.prj.cmd;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.sk.prj.dao.BallotDAO;
import com.sk.prj.dto.BallotDTO;

public class BallotContentCmd implements BallotCmd {
    public static Logger logger = LoggerFactory.getLogger(BallotContentCmd.class);
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stubBallotContentCmd
		Map<String, Object> map = model.asMap();
		HttpServletRequest httpServletRequest = (HttpServletRequest)map.get("request");
		logger.info("BallotContentCmd {}", httpServletRequest);
        
		String ballotId = httpServletRequest.getParameter("ballotid");
	
		logger.info("BallotContentCmd ballotid {}", ballotId);
		BallotDAO ballotDAO = new BallotDAO();
		BallotDTO ballotDTO = ballotDAO.contentView(ballotId);
		
		model.addAttribute("BallotContent", ballotDTO); 
	}

}
