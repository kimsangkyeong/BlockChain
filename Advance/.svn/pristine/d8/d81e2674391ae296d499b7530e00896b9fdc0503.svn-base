package com.sk.prj.cmd;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.sk.prj.dao.UserDAO;
import com.sk.prj.dto.UserDTO;

public class UserCreateCmd implements UserCmd {
    public static Logger logger = LoggerFactory.getLogger(UserCreateCmd.class);
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest httpServletRequest = (HttpServletRequest)map.get("request");
		logger.info("UserCreateCmd {}", httpServletRequest);
		UserDTO userDTO = new UserDTO();
		userDTO.setId(httpServletRequest.getParameter("id"));
		userDTO.setName(httpServletRequest.getParameter("name"));
		userDTO.setPw(httpServletRequest.getParameter("pw"));
		userDTO.setMtel(httpServletRequest.getParameter("mtel"));
		userDTO.setHtel(httpServletRequest.getParameter("htel"));
		userDTO.setDong(httpServletRequest.getParameter("dong"));
		userDTO.setHo(httpServletRequest.getParameter("ho"));
		userDTO.setType(httpServletRequest.getParameter("type"));
		userDTO.setValidflag("Y");
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");	
		userDTO.setCreatedtm(sdf.format(date));
		userDTO.setUpdatedtm(null);
	    		
		logger.info("UserCreateCmd {}", userDTO.toString());
		
		UserDAO userDAO = new UserDAO();
		userDAO.createUser(userDTO);
	    model.addAttribute("view", "/admin/adminmenu"); 
	}

}
