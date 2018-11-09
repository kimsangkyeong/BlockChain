package com.sk.prj.cmd;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.sk.prj.dao.UserDAO;
import com.sk.prj.dto.UserDTO;

public class UserContentCmd implements UserCmd {

	private static Logger logger = LoggerFactory.getLogger(UserContentCmd.class);
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest httpServletRequest = (HttpServletRequest)map.get("request");
		logger.info("ContentCmd {}", httpServletRequest);
		String userId = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		
		logger.info("ContentCmd {} / {}", userId, pw);
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = userDAO.contentView(userId);

		model.addAttribute("userContent", userDTO);
		
		// 결과에 따라서 화면 이동 처리를 한다.
        if ( userDTO == null ) {
        	model.addAttribute("greeting", "사용자 정보가 없습니다. <br/> 관라자에게 사용자 등록을 먼저 요청하세요!");
        	model.addAttribute("view", "login");
        } else if ( userDTO.getPw().equals(pw) ) {
    		//logger.info("userDTO {} ", userDTO.toString());
        	if ( userDTO.getType().equals("0")) 
    		    model.addAttribute("view", "/admin/adminmenu");
        	else
    		    model.addAttribute("view", "/user/usermenu");  
        	model.addAttribute("id", userId);
        	model.addAttribute("name", userDTO.getName());
        } else {
    		//logger.info("userDTO {} ", userDTO.toString());
        	model.addAttribute("greeting", "패스워드가 맞지 않습니다. <br/> 5번 틀리면 계정이 잠깁니다.");
        	model.addAttribute("inputId", userId);
        	model.addAttribute("view", "login");        	
        }		
   }

}
