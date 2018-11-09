package com.sk.prj.cmd;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.sk.prj.dto.ReservationDTO;
import com.sk.prj.dao.ReservationDAO;

public class ReservationReturnCmd implements ReservationCmd {
	private static Logger logger = LoggerFactory.getLogger(UserContentCmd.class);
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest httpServletRequest = (HttpServletRequest)map.get("request");
		
		logger.info("ReservationRentCmd {}", httpServletRequest);
		
		//String userId = httpServletRequest.getParameter("id");
		String userId = "yongdol";
		model.addAttribute("from_id", userId);
		
		logger.info("ReservationRentCmd {} / {}", userId);
		

		//List<Map<String, Object>> coinDTO = coinDAO.contentView(userId);
    	//model.addAttribute("coinHist", coinDTO);


    	ReservationDTO reservationDTO = new ReservationDTO();
    	reservationDTO.setUse_id(userId);
    	reservationDTO.setName(httpServletRequest.getParameter("name"));
    	logger.info("ReservationRetrunCmd Name {}", httpServletRequest.getParameter("name"));
		//Date date = new Date();
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");	
		//coinDTO.setDateTime(sdf.format(date));
		
    	ReservationDAO reservationDAO = new ReservationDAO();
    	reservationDAO.reTurn(reservationDTO);
    	
   }
}
