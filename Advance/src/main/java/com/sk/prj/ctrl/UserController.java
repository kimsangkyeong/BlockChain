package com.sk.prj.ctrl;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.soap.AddressingFeature.Responses;

import org.apache.log4j.spi.LoggerFactory;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sk.prj.bch.Bchain;
import com.sk.prj.cmd.BChainResidentCmd;
import com.sk.prj.cmd.BChainResidentContentCmd;
import com.sk.prj.cmd.BChainResidentGetAdminContentCmd;
import com.sk.prj.cmd.BChainResidentGetBChAdminAcnt;
import com.sk.prj.cmd.BallotCmd;
import com.sk.prj.cmd.BallotContentCmd;
import com.sk.prj.cmd.BallotItemListCmd;
import com.sk.prj.cmd.CoinCmd;
import com.sk.prj.cmd.CoinContentCmd;
import com.sk.prj.cmd.CoinSendCmd;
import com.sk.prj.cmd.ReservationCmd;
import com.sk.prj.cmd.ReservationContentCmd;
import com.sk.prj.cmd.ReservationRentCmd;
import com.sk.prj.cmd.ReservationReturnCmd;
import com.sk.prj.cmd.RunVotingHistoryCmd;
import com.sk.prj.cmd.RunVotingHistoryContentCmd;
import com.sk.prj.cmd.RunVotingHistoryCreateCmd;
import com.sk.prj.cmd.RunVotingHistoryModifyCmd;
import com.sk.prj.cmd.UserCmd;
import com.sk.prj.cmd.UserContentCmd;
import com.sk.prj.cmd.UserCreateCmd;
import com.sk.prj.cmd.VoteAgentCmd;
import com.sk.prj.cmd.VoteAgentListCmd;
import com.sk.prj.cmd.VoteAgentListrCmd;
import com.sk.prj.dto.BChainAdmAcntDTO;
import com.sk.prj.dto.BChainResidentDTO;
import com.sk.prj.dto.RunVotingHistoryDTO;
import com.sk.prj.dto.UserDTO;
import com.sk.prj.util.Constant;

@Controller
public class UserController {
	private static Logger logger =org.slf4j.LoggerFactory.getLogger(UserController.class);
	private UserCmd userCmd;
	private CoinCmd coinCmd;
	private ReservationCmd reservationCmd;
	private VoteAgentCmd voteaAgentCmd;
	private BallotCmd  ballotCmd;
	private RunVotingHistoryCmd runVotingHistoryCmd;
	private BChainResidentCmd bChainResidentCmd;
	
	private String LoginIdPasswd;  // 투표를 시도하는 경우 사용자 블럭체인 계정 비밀번호를 미리 저장해 놓아서 재 조회를 방지한다.
	
	public JdbcTemplate template;
	public TransactionTemplate transactionTemplate;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@Autowired
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
	// entry point - url call initial url call entry poiint
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String Index(HttpServletRequest httpServletRequest, Locale locale, Model model) {
	    logger.info("[/] {}", locale);
	    
	    model.addAttribute("greeting", "블럭체인 SOT1 주민 여러분 반갑습니다.");
		return "login";
	}

	// login check - RequestParam으로 Parameter를 아예 선언하기  : 변수 값이 없으면, 400 에러를 발생시킨다. 이럴 경우에는 화면에서 변수 값 확인을 해야 한다.
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String Login(HttpServletRequest httpServletRequest, Model model) {	    
		logger.info("[/login]");
		
	    model.addAttribute("request", httpServletRequest);
		userCmd = new UserContentCmd();
	    userCmd.execute(model);
	    
	    return (String)model.asMap().get("view");
	}

	// 관리자가 사용자 관리 메뉴를 호출하는 경우
	@RequestMapping(value="/admin/usermenu", method=RequestMethod.GET)
	public String adminmenu1(HttpServletRequest httpServletRequest, Model model) {	    
		logger.info("[/admin/usermenu]");
        return "/admin/user/usercreate";
	}
	
	// 관리자가 사용자를 신규 생성하는 경우
	@RequestMapping(value="/admin/usercreate", method=RequestMethod.POST)
	public String usercreate(HttpServletRequest httpServletRequest, Model model) {	    
		logger.info("[/admin/usercreate]");
		
	    model.addAttribute("request", httpServletRequest);
		userCmd = new UserCreateCmd();
	    userCmd.execute(model);
	    	    
	    return (String)model.asMap().get("view");
	}

/*  block chain json-rpc 통신 처리 예시 
    model.addAttribute("calltype",	"0");
//    Bchain bchain = new Bchain("http://192.168.223.123:8545");  // Block chain RPC 통신 서버
    Bchain bchain = new Bchain();  // SOT Block chain RPC 통신 서버
    bchain.execute(model);
*/
    
	// block chain 테스트 하기
	@RequestMapping(value="/admin/bcntest", method=RequestMethod.GET)
	public String bcntest(HttpServletRequest httpServletRequest, Model model) {	    
		logger.info("[/admin/bcntest]");
		
		model.addAttribute("calltype",	"0");
	    Bchain bchain = new Bchain();  // SOT Block chain RPC 통신 서버
	    bchain.execute(model);
	    
		
		//return (String)model.asMap().get("view");
		return "/admin/test";
	}


	//#################### User 메뉴 ##################### 
	@RequestMapping(value="/u_coin", method=RequestMethod.GET)
	public String Coin(HttpServletRequest httpServletRequest, Model model) {	    
		logger.info("/user/coin");
		
	    model.addAttribute("request", httpServletRequest);
	    
		coinCmd = new CoinContentCmd();
	    coinCmd.execute(model);
  
	    return "/user/coin/main";
	}
	
	@RequestMapping(value="/CoinSend", method=RequestMethod.POST)
	public String CoinSend(HttpServletRequest httpServletRequest, Model model) {	    
		logger.info("[/CoinSend]");
		
	    model.addAttribute("request", httpServletRequest);
	    
	    Bchain bchain = new Bchain();  // SOT Block chain RPC 통신 서버
	    //model.addAttribute("calltype",	"50");
	    //bchain.execute(model);	        
	    model.addAttribute("calltype",	"51");
	    bchain.execute(model);
	    
	    coinCmd = new CoinSendCmd();
	    coinCmd.execute(model);
	    
		coinCmd = new CoinContentCmd();
	    coinCmd.execute(model);
	    
	    return "/user/coin/main";
	}
	
	
	// ksk - 사용자 목록에서 설문/투표하기를 선택한 경우
	@RequestMapping(value="/u_vote", method=RequestMethod.POST)
	public String Vote(HttpServletRequest httpServletRequest, Model model) {	    
		logger.info("[/user/vote]");
		
	    model.addAttribute("request", httpServletRequest);
	    voteaAgentCmd = new VoteAgentListrCmd();
	    voteaAgentCmd.execute(model);
	    return (String)model.asMap().get("view");
	}
	
	// ksk -  사용자 목록에서 설문/투표하기를 선택한 경우
	@RequestMapping(value="/u_ballot", method=RequestMethod.POST)
	public String Ballot(HttpServletRequest httpServletRequest, Model model) {	    
		logger.info("[/user/Ballot]");
		
	    model.addAttribute("request", httpServletRequest);
	    model.addAttribute("id", httpServletRequest.getParameter("id"));
	    model.addAttribute("vaid", httpServletRequest.getParameter("vaid"));
	    runVotingHistoryCmd = new RunVotingHistoryContentCmd();
	    runVotingHistoryCmd.execute(model);

	    RunVotingHistoryDTO runVotingHistoryDTO = (RunVotingHistoryDTO)model.asMap().get("RVHContent");
		if ( runVotingHistoryDTO == null ) {
			// 투표처리 Block 계정 생성하여 기초 레코드 미리 생성한 후 투표지 화면으로 이동
			logger.info("[/usr/Ballot] {}", "투표처리 Block 계정 생성하여 기초 레코드 미리 생성한 후 투표지 화면으로 이동");
			// 사용자 password 얻어오기
			userCmd = new UserContentCmd();
		    userCmd.execute(model);		    
		    UserDTO userDTO = (UserDTO)model.asMap().get("userContent");
		    
		    // 주민 테이블의 관리자 계정으로 등록된 블럭체인 계정 및 비밀번호 정보 얻어오기
		    bChainResidentCmd = new BChainResidentGetBChAdminAcnt();
		    bChainResidentCmd.execute(model);
		    BChainAdmAcntDTO  bChainAdmAcntDTO = (BChainAdmAcntDTO)model.asMap().get("BCRContent");
		    
			// block chain 신규 계정 생성하기 
		    model.addAttribute("calltype",	"73");
		    model.addAttribute("pswd", userDTO.getPw());
		    this.LoginIdPasswd = userDTO.getPw();  // 향후 투표할 때 재 조회하지 않기 위해 내부 변수로 셋팅함
//		    Bchain bchain73 = new Bchain("http://192.168.223.123:8545");  // Block chain RPC 통신 서버
		    Bchain bchain73 = new Bchain();  // SOT Block chain RPC 통신 서버
		    bchain73.execute(model);
		    
		    logger.info("bchan73 call result msg : " + (String)model.asMap().get("bchResultMsg"));
		    JSONObject bchResult = (JSONObject) model.asMap().get("bchResult");
			model.addAttribute("bvoteacnt", bchResult.get("result"));

			// 신규 계정에 투표용 기본 비트코인 이체하기
			  // 관리자 계정의 비밀번호 해제하기
  		        model.addAttribute("calltype",	"74");
		        model.addAttribute("bchacnt", bChainAdmAcntDTO.getBchacnt());  //관리자 계정
  		        model.addAttribute("pswd"   , bChainAdmAcntDTO.getPswd());     //관리자 계정 비밀번호
//		        Bchain bchain74 = new Bchain("http://192.168.223.123:8545");  // Block chain RPC 통신 서버
   	    	    Bchain bchain74 = new Bchain();  // SOT Block chain RPC 통신 서버
	    
   	    	    bchain74.execute(model);
   	    	    logger.info("bchan74 call result msg : " + (String)model.asMap().get("bchResultMsg"));
   	    	 
			  // 관리자 계정 -> 신규 계정 이체하기
  		        model.addAttribute("calltype",	"75");
		        model.addAttribute("adminbchacnt", bChainAdmAcntDTO.getBchacnt());  // 관리자 계정
  		        model.addAttribute("personbchacnt" , (String)model.asMap().get("bvoteacnt")); // 일회용 계정
//		        Bchain bchain75 = new Bchain("http://192.168.223.123:8545");  // Block chain RPC 통신 서버
     		    Bchain bchain75 = new Bchain();  // SOT Block chain RPC 통신 서버
	    	    bchain75.execute(model);			
			
	    	    logger.info("bchan75 call result msg : " + (String)model.asMap().get("bchResultMsg"));
	    	    
			// 비트코인까지 전달이 성공(결과구조체가 not null)한 후에만 계정을 생성한다.
	    	if ( (JSONObject) model.asMap().get("bchResult") != null ) {
		      runVotingHistoryCmd = new RunVotingHistoryCreateCmd();
		      runVotingHistoryCmd.execute(model);
	    	}
		    
		    // 재조회 방지를 위해 화면으로 일회용 블럭체인 계정 정보를 전달한다.
		    model.addAttribute("personbchacnt", (String)model.asMap().get("bvoteacnt"));
		    
		    // 투표지로 이동한다.
		    return TransferBallot(model);
		}  else if ( runVotingHistoryDTO.getVoteflag().equals("N") ) {
			// 투표처리 Block 계정은 이미 생성되었지만, 투표를 마무리 하지 못한 경우. 투표지로 이동
			logger.info("[/usr/Ballot] {}", "투표처리 Block 계정은 이미 생성되었지만, 투표를 마무리 하지 못한 경우. 투표지로 이동");
			// 사용자 password 얻어오기
			userCmd = new UserContentCmd();
		    userCmd.execute(model);		    
		    UserDTO userDTO = (UserDTO)model.asMap().get("userContent");
		    this.LoginIdPasswd = userDTO.getPw();  // 향후 투표할 때 재 조회하지 않기 위해 내부 변수로 셋팅함
		    
		    // 재조회 방지를 위해 화면으로 일회용 블럭체인 계정 정보를 전달한다.
		    model.addAttribute("personbchacnt", runVotingHistoryDTO.getBvoteacnt());

		    // 투표지로 이동한다.
			return TransferBallot(model);
		} else {
			// 투표를 완료한 경우로, 투표 목록 리스트로 이동
			logger.info("[/usr/Ballot] {}", "투표를 완료한 경우로, 투표 목록 리스트로 이동");
			return this.Vote(httpServletRequest, model);
		}
	}

	// ksk -  투표를 완료한 후 투표 목록으로 이동한다.
	@RequestMapping(value="/u_voting", method=RequestMethod.POST)
	public String RunVoting(HttpServletRequest httpServletRequest, Model model) {	    
		logger.info("[RunVoting]");
	    model.addAttribute("request", httpServletRequest);
	    String votebchacnt = httpServletRequest.getParameter("voteinfo");
	    String personbchacnt = httpServletRequest.getParameter("personbchacnt");
	    logger.info(" votebchacnt {} personbchacnt {}", votebchacnt, personbchacnt);
	    logger.info(" saved passwd : {} ", this.LoginIdPasswd);
	    
		// 일회용 투표 계정 비밀번호 해제하기
	    model.addAttribute("calltype",	"74");
        model.addAttribute("bchacnt", personbchacnt);  //일회용 투표 계정
	    model.addAttribute("pswd"   , this.LoginIdPasswd);  // 재조회를 방지하기 위해 직전에 저장해 놓은 비밀번호를 이용한다.
//        Bchain bchain74 = new Bchain("http://192.168.223.123:8545");  // Block chain RPC 통신 서버
	    Bchain bchain74 = new Bchain();  // SOT Block chain RPC 통신 서버
	    bchain74.execute(model);	    	    
	    logger.info("bchan74 call result msg : " + (String)model.asMap().get("bchResultMsg"));
	    
	    // 투표용 블럭체인 계정에서 대상자 계정으로 1 wei 이체한다.
	    model.addAttribute("calltype",	"76");
	    model.addAttribute("votebchacnt", votebchacnt);
	    model.addAttribute("personbchacnt", personbchacnt);
//	    Bchain bchain76 = new Bchain("http://192.168.223.123:8545");  // Block chain RPC 통신 서버
	    Bchain bchain76 = new Bchain();  // SOT Block chain RPC 통신 서버
	    bchain76.execute(model);
	    
	    logger.info("bchan76 call result msg : " + (String)model.asMap().get("bchResultMsg"));
	    JSONObject bchResult = (JSONObject) model.asMap().get("bchResult");
	    if (bchResult != null) logger.info("[RunVoting] bch 76 result {} ", bchResult.get("result"));
	    
	    // 블럭체인이 성공((결과구조체가 not null)한 후에만, 투표 완료로 update 한다.
	    if ( (JSONObject) model.asMap().get("bchResult") != null ) {
	      runVotingHistoryCmd = new RunVotingHistoryModifyCmd();
	      runVotingHistoryCmd.execute(model);
	    }
	    
	    // 투표가 완료되면 투표 목록으로 이동한다.
	    return this.Vote(httpServletRequest, model);
	}
	
	// ksk -  투표지 정보를 조회한 후 투표지로 이동한다.
	private String TransferBallot(Model model) {
		ballotCmd = new BallotContentCmd();
		ballotCmd.execute(model);
		
		ballotCmd = new BallotItemListCmd();
		ballotCmd.execute(model);
		return "/user/vote/ballot";
	}
	
	@RequestMapping(value="/u_reservation", method=RequestMethod.GET)
	public String Reservation(HttpServletRequest httpServletRequest, Model model) {	    
		logger.info("/user/reservation");
		
	    model.addAttribute("request", httpServletRequest);
	    
		reservationCmd = new ReservationContentCmd();
		reservationCmd.execute(model);
	    
	    return "/user/reservation/main";
	}	

	@RequestMapping(value="/rent", method=RequestMethod.POST)
	public String Rent(HttpServletRequest httpServletRequest, Model model) {	    
		logger.info("/user/rent");
		
	    model.addAttribute("request", httpServletRequest);
	    
	    
	    
	    String action = httpServletRequest.getParameter("action");
	    
	    //Bchain bchain = new Bchain();  // SOT Block chain RPC 통신 서버
	    //model.addAttribute("calltype",	"50");
	    //bchain.execute(model);	        
	    //model.addAttribute("calltype",	"51");
	    //bchain.execute(model);
	    
	    if (action.equals("rent")) {
		    //model.addAttribute("calltype",	"52");
		    //bchain.execute(model);
		    reservationCmd = new ReservationRentCmd();
			reservationCmd.execute(model);
	    } else {
		    //model.addAttribute("calltype",	"53");
		    //bchain.execute(model);
		    reservationCmd = new ReservationReturnCmd();
		    reservationCmd.execute(model);
	    }
	    
		reservationCmd = new ReservationContentCmd();
		reservationCmd.execute(model);
		
	    return "/user/reservation/main";
	}	
	
}


