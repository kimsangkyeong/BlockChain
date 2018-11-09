package com.sk.prj.cmd;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.sk.prj.dao.BChainResidentDAO;
import com.sk.prj.dto.BChainResidentDTO;

public class BChainResidentGetAdminContentCmd implements BChainResidentCmd {
    public static Logger logger = LoggerFactory.getLogger(BChainResidentGetAdminContentCmd.class);

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest httpServletRequest = (HttpServletRequest)map.get("request");
		logger.info("BChainResidentGetAdminContentCmd {}", httpServletRequest);
        	
		BChainResidentDAO bChainResidentDAO = new BChainResidentDAO();
		BChainResidentDTO bChainResidentDTO = bChainResidentDAO.getAdminContent2();
		
		model.addAttribute("BCRContent", bChainResidentDTO);
		logger.info("BChainResidentGetAdminContentCmd ...{}", bChainResidentDTO);
	}

}
