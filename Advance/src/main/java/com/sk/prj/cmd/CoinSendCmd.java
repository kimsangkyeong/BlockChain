package com.sk.prj.cmd;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

public class CoinSendCmd implements CoinCmd {
	private static Logger logger = LoggerFactory.getLogger(UserContentCmd.class);
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest httpServletRequest = (HttpServletRequest)map.get("request");
		
		logger.info("CoinSendCmd {}", httpServletRequest);
		
		//String userId = httpServletRequest.getParameter("id");
		String userId = "yongdol";
		model.addAttribute("from_id", userId);
		
		logger.info("CoinSendCmd {} / {}", userId);
		

		//List<Map<String, Object>> coinDTO = coinDAO.contentView(userId);
    	//model.addAttribute("coinHist", coinDTO);


    	CoinDTO coinDTO = new CoinDTO();
		coinDTO.setFrom_id(userId);
		coinDTO.setTo_id(httpServletRequest.getParameter("to_id"));
		coinDTO.setValue(Integer.parseInt(httpServletRequest.getParameter("value")));
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");	
		coinDTO.setDateTime(sdf.format(date));
		
		CoinDAO coinDAO = new CoinDAO();
		coinDAO.sendCoin(coinDTO);
    	
   }
}


