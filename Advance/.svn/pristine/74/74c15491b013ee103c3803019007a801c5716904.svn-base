package com.sk.prj.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.sk.prj.dao.CoinDAO;
import com.sk.prj.dao.UserDAO;
import com.sk.prj.dto.CoinDTO;
import com.sk.prj.dto.UserDTO;

public class CoinContentCmd implements CoinCmd {
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
				
		logger.info("CoinContentCmd {} / {}", userId);
		CoinDAO coinDAO = new CoinDAO();
		//CoinDTO coinDTO;
		List<Map<String, Object>> coinDTO = coinDAO.contentView(userId);
    	model.addAttribute("coinHist", coinDTO);
    	
		int balance = coinDAO.getBalance(userId);
    	model.addAttribute("balance", balance);
    	
   }
}
