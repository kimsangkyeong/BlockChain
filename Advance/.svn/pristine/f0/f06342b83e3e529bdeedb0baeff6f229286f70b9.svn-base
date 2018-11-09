package com.sk.prj.cmd;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.sk.prj.dao.ReservationDAO;

public class ReservationContentCmd implements ReservationCmd {
	private static Logger logger = LoggerFactory.getLogger(UserContentCmd.class);
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest httpServletRequest = (HttpServletRequest)map.get("request");
		
		logger.info("CoinContentCmd {}", httpServletRequest);
		
		//String userId = httpServletRequest.getParameter("id");
		String userId = "yongdol";
		model.addAttribute("userId", userId);
				
		logger.info("ReservationContentCmd {} / {}", userId);
		ReservationDAO reservationDAO = new ReservationDAO();
		//CoinDTO coinDTO;
		List<Map<String, Object>> reservationDTO = reservationDAO.contentView(userId);
    	model.addAttribute("reservationStatus", reservationDTO);
    	
		//int balance = reservationDAO.getBalance(userId);
    	//model.addAttribute("balance", balance);
    	
   }
}


