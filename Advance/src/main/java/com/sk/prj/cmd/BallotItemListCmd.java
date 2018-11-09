package com.sk.prj.cmd;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.sk.prj.dao.BallotDAO;
import com.sk.prj.dto.BallotDTO;
import com.sk.prj.dto.BallotItemsDTO;

public class BallotItemListCmd implements BallotCmd {
    public static Logger logger = LoggerFactory.getLogger(BallotItemListCmd.class);

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest httpServletRequest = (HttpServletRequest)map.get("request");
		logger.info("BallotContentCmd {}", httpServletRequest);
        
		String ballotId = httpServletRequest.getParameter("ballotid");
	
		logger.info("BallotContentCmd ballotid {}", ballotId);
		BallotDAO ballotDAO = new BallotDAO();
		ArrayList<BallotItemsDTO> ballotItemsDTOs = ballotDAO.ballotItemList(ballotId);
		
		logger.info("BallotContentCmd ballotItemsDTOs size {}", ballotItemsDTOs.size());
		model.addAttribute("BallotItemContents", ballotItemsDTOs); 
	}

}
