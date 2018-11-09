package com.sk.prj.cmd;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.sk.prj.dao.BChainResidentDAO;
import com.sk.prj.dto.BChainAdmAcntDTO;
import com.sk.prj.dto.BChainResidentDTO;

public class BChainResidentGetBChAdminAcnt implements BChainResidentCmd {
    public static Logger logger = LoggerFactory.getLogger(BChainResidentGetBChAdminAcnt.class);

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest httpServletRequest = (HttpServletRequest)map.get("request");
		logger.info("BChainResidentGetBChAdminAcnt {}", httpServletRequest);
        	
		BChainResidentDAO bChainResidentDAO = new BChainResidentDAO();
		BChainAdmAcntDTO bChainAdmAcntDTO = bChainResidentDAO.getAdminContent();
		
		model.addAttribute("BCRContent", bChainAdmAcntDTO);
		logger.info("BChainResidentGetBChAdminAcnt ...{}", bChainAdmAcntDTO);
	}

}
