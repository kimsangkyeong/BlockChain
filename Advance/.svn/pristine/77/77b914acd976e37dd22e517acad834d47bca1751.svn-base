package com.sk.prj.bch;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

public class Bchain {
	public static Logger logger = LoggerFactory.getLogger(Bchain.class);
	
	private String destinationURL ;	
	
	public Bchain() {
		this.destinationURL = "http://169.56.103.195:8545";  // block chain 접속 정보
	}

	public Bchain(String _destinationURL) {
		this.destinationURL = _destinationURL;
	}

	public void execute(Model model) {
		logger.info("bitcoin HTTP Client check... .");
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest httpServletRequest = (HttpServletRequest) map.get("request");
		
		JSONObject bchInput = new JSONObject();
		JSONArray  tranInfoList = new JSONArray();
		JSONObject tranInfo = new JSONObject();
		ArrayList<String> accInfo4 = new ArrayList<String>();
//        int calltype = Integer.parseInt(httpServletRequest.getParameter("type"));        
        int calltype = Integer.parseInt((String)map.get("calltype"));        
		switch (calltype) {
		case 0:   // 블럭 번호
			ArrayList<String> queryInfo = new ArrayList<String>();

			bchInput.put("jsonrpc", "2.0");
			bchInput.put("method", "eth_blockNumber");
			bchInput.put("params",queryInfo);
			bchInput.put("id", 1);			
			break;
		case 1:  // 계정 정보 목록 
			ArrayList<String> queryInfo2 = new ArrayList<String>();

			bchInput.put("jsonrpc", "2.0");
			bchInput.put("method", "eth_accounts");
			bchInput.put("params",queryInfo2);
			bchInput.put("id", 2);			
			break;
		case 2:  // 특정 계좌 마지막 잔고 확인하기
			ArrayList<String> accInfo = new ArrayList<String>();
			accInfo.add("0xdeb154d99d7659f7776ed539f4d5272bc2507aa9");  //1. 계좌번호
			accInfo.add("latest");                                      //2. 마지막 정보

			bchInput.put("jsonrpc", "2.0");
			bchInput.put("method", "eth_getBalance");
			bchInput.put("params",accInfo);
			bchInput.put("id", 3);			
			break;
		case 3:  // 신규 계정 생성하기
			ArrayList<String> newInfo = new ArrayList<String>();
			newInfo.add("1234");                                        //1. 패스워드

			bchInput.put("jsonrpc", "2.0");
			bchInput.put("method", "personal_newAccount");
			bchInput.put("params",newInfo);
			bchInput.put("id", 4);		
			break;
		case 4:  // 계정 패스워드 풀기
			
			accInfo4.add("0xc55201d16c3c7168be0c46556569286cea41dbe1");   //1. 계좌정보
			accInfo4.add("testuser1");                                    //2. 패스워드
			accInfo4.add("60");                                           //3. delay time

			bchInput.put("jsonrpc", "2.0");
			bchInput.put("method", "personal_unlockAccount");
			bchInput.put("params",accInfo4);
			bchInput.put("id", 4);		
			break;
		case 5:  // 이더리움 이체하기 - 투표를 위한 임시 계정에 1 wei와 gas 가격1 ether를 이체한다.
            tranInfo.put("from", "0xc55201d16c3c7168be0c46556569286cea41dbe1");  //1. 송신 계좌
            tranInfo.put("to", "0xdeb154d99d7659f7776ed539f4d5272bc2507aa9");    //2. 수신 계좌
            tranInfo.put("gas", "0x15F90");                                      //3. gas 값
            tranInfo.put("gasPrice", "0x4A817C800");                             //4. gasprice
//            tranInfo.put("value", "web3.toWei(1,ether)");                          //5. 이체금액 -- 단위를 표현하기 위한 문자열 입력 불가로 함수 사용 불가. 직접 계산할 것.
            tranInfo.put("value", "100000000000000001");                         //5. 이체금액
//            tranInfo.put("value", "0xDE0B6B3A7640000");                          //5. 이체금액
            tranInfoList.add(tranInfo);                                          // array 추가 
            //------------------
			bchInput.put("jsonrpc", "2.0");
			bchInput.put("method", "eth_sendTransaction");
			bchInput.put("params",tranInfoList);
			bchInput.put("id", 5);		
			break;
		case 6:  // Pending Transaction
			ArrayList<String> queryInfo6 = new ArrayList<String>();

			bchInput.put("jsonrpc", "2.0");
			bchInput.put("method", "eth_pendingTransactions");
			bchInput.put("params",queryInfo6);
			bchInput.put("id", 6);		
			break;
		case 7:  // get Transaction Receipt 받기 ( sendTransaction의 결과 tx 정보 입력 )
			ArrayList<String> queryInfo7 = new ArrayList<String>();
            queryInfo7.add("0x1e873d19a37d13f5b0bfd5fac7d40543859ff91a5b5350614500533cac2ff34d"); //1. 트랜잭션 식별자
            
			bchInput.put("jsonrpc", "2.0");
			bchInput.put("method", "eth_getTransactionReceipt");
			bchInput.put("params",queryInfo7);
			bchInput.put("id", 7);		
			break;
		case 10:  // miner start : 성공하면, result - true, error, null
			ArrayList<String> exeInfo = new ArrayList<String>();
			
			bchInput.put("jsonrpc", "2.0");
			bchInput.put("method", "miner_start");
			bchInput.put("params",exeInfo);
			bchInput.put("id", 10);			
			break;
		case 11:  // miner stop : 성공하면, result - true, error, null
			ArrayList<String> exeInfo1 = new ArrayList<String>();
			
			bchInput.put("jsonrpc", "2.0");
			bchInput.put("method", "miner_stop");
			bchInput.put("params",exeInfo1);
			bchInput.put("id", 11);			
			break;
		case 50:  //CoinSend 1
			//ArrayList<String> accInfo4 = new ArrayList<String>();
			accInfo4.add("0x1d6721f7703bd3c317eb002273f12d3d339b67b5");   //1. 계좌정보
			accInfo4.add("clxhtm12");                                    //2. 패스워드
			accInfo4.add("60");                                           //3. delay time

			bchInput.put("jsonrpc", "2.0");
			bchInput.put("method", "personal_unlockAccount");
			bchInput.put("params",accInfo4);
			bchInput.put("id", 50);		
			break;
		case 51:  //CoinSend 2
			//JSONArray tranInfoList = new JSONArray();
			//JSONObject tranInfo = new JSONObject();
            tranInfo.put("from", "0x1d6721f7703bd3c317eb002273f12d3d339b67b5");  //1. 송신 계좌
            tranInfo.put("to", "0xb6d33b3d9d47b03797e769e4fa75b2e08c8afa9a");    //2. 수신 계좌
            tranInfo.put("gas", "0x15F90");                                      //3. gas 값
            tranInfo.put("gasPrice", "0x4A817C800");                             //4. gasprice
            tranInfo.put("value", "0x"+httpServletRequest.getParameter("value"));     //5. 이체금액
            logger.info("value {}.", "0x"+httpServletRequest.getParameter("value"));
            tranInfoList.add(tranInfo);                                          // array 추가 
            //------------------
			bchInput.put("jsonrpc", "2.0");
			bchInput.put("method", "eth_sendTransaction");
			bchInput.put("params",tranInfoList);
			bchInput.put("id", 51);		
			break;
		case 72:  // 투표하기 - 특정 계좌 마지막 잔고 확인하기
			logger.info("bitcoin - 72 잔고확인 - bchacnt {}",(String)map.get("bchacnt"));
			ArrayList<String> accInfo72 = new ArrayList<String>();
			accInfo72.add((String)map.get("bchacnt"));                    //1. 계좌번호 - 계정정보를 입력받아서 조회한다.
			accInfo72.add("latest");                                      //2. 마지막 정보

			bchInput.put("jsonrpc", "2.0");
			bchInput.put("method", "eth_getBalance");
			bchInput.put("params",accInfo72);
			bchInput.put("id", 72);			
			break;
		case 73:  // 투표하기 -  신규 계정 생성하기
			logger.info("bitcoin - 73 신규계정 생성 - pswd {}",(String)map.get("pswd"));
			ArrayList<String> newInfo73 = new ArrayList<String>();
			newInfo73.add((String)map.get("pswd"));                        //1. 패스워드 - 사용자의 로그인 passwd를 이용하여 계정을 생성한다.

			bchInput.put("jsonrpc", "2.0");
			bchInput.put("method", "personal_newAccount");
			bchInput.put("params",newInfo73);
			bchInput.put("id", 73);		
			break;
		case 74:  // 투표하기 -  계정 패스워드 풀기			
			logger.info("bitcoin - 74 계정패스워드 풀기 - bchacnt {}, pswd {} ",(String)map.get("bchacnt"), (String)map.get("pswd"));
			ArrayList<String> accInfo74 = new ArrayList<String>();
			accInfo74.add((String)map.get("bchacnt"));                     //1. 계좌정보 - 계정정보를 입력받아서 조회한다.
			accInfo74.add((String)map.get("pswd"));                        //2. 패스워드 - 계정 passwd를 이용하여 계정을 생성한다.
			//accInfo74.add("60");                                         //3. delay time - 숫자형으로 입력해야 함. 방법 몰라서 일단은 default 처리로 요청함
			
			bchInput.put("jsonrpc", "2.0");
			bchInput.put("method", "personal_unlockAccount");
			bchInput.put("params",accInfo74);
			bchInput.put("id", 74);		
			break;
		case 75:  // 투표하기 -  이더리움 이체하기 - 투표를 위한 일회용 계정에 1 wei와 gas 가격 0.01 ether를 이체한다.
			logger.info("bitcoin - 75 일회용계좌준비 - adminbchacnt {}, personbchacnt {} ",(String)map.get("adminbchacnt"), (String)map.get("personbchacnt"));
            tranInfo.put("from", (String)map.get("adminbchacnt"));       //1. 송신 계좌 - 공통 계정
            tranInfo.put("to", (String)map.get("personbchacnt"));        //2. 수신 계좌 - 일회용 계정
            tranInfo.put("gas", "0x15F90");                                      //3. gas 값
            tranInfo.put("gasPrice", "0x40000");                             //4. gasprice
            //tranInfo.put("value", "1000000000000001");                         //5. 이체금액
            tranInfo.put("value", "0x400000000001");                                  //5. 이체금액
            tranInfoList.add(tranInfo);                                          // array 추가 
            //------------------
			bchInput.put("jsonrpc", "2.0");
			bchInput.put("method", "eth_sendTransaction");
			bchInput.put("params",tranInfoList);
			bchInput.put("id", 75);		
			break;
		case 76:  // 투표하기 -  이더리움 이체하기 - 투표를 위해 투표자 일회용 계정에서 선택한 투표 대상 계정으로 1 wei를 이체한다.
			logger.info("bitcoin - 76 투표하기 - personbchacnt {}, votebchacnt {} ",(String)map.get("personbchacnt"), (String)map.get("votebchacnt"));
            tranInfo.put("from", (String)map.get("personbchacnt"));              //1. 송신 계좌 - 일회용 계정
            tranInfo.put("to", (String)map.get("votebchacnt"));                  //2. 수신 계좌 - 투표용 대상 계정
            tranInfo.put("gas", "0x15F90");                                      //3. gas 값
            tranInfo.put("gasPrice", "0x400000");                             //4. gasprice
            //tranInfo.put("value", "000000000000000001");                         //5. 이체금액 - 1 wei
            tranInfo.put("value", "0x1");                                        //5. 이체금액 - 1 wei
            tranInfoList.add(tranInfo);                                          // array 추가 
            //------------------
			bchInput.put("jsonrpc", "2.0");
			bchInput.put("method", "eth_sendTransaction");
			bchInput.put("params",tranInfoList);
			bchInput.put("id", 76);		
			break;
		default:
			break;
		}

		// bitcoin network call
		JSONObject bcnResult;
		bcnResult = CallForJsonRPC(bchInput);
		if ( bcnResult != null ) {
			logger.info("blockchain call ok! {}", bcnResult.toString());
			String msg = "blockchain ok! { " + bcnResult.toString() + " }";
			model.addAttribute("bchResultMsg", msg);
		} else {
		    model.addAttribute("bchResultMsg", "blockchain call error!" );
		}
		model.addAttribute("bchResult", bcnResult);
	}
	
	// Block Chain JSON-RPC 통신용 공통 프로그램 util
	protected JSONObject CallForJsonRPC(JSONObject input) {
		JSONObject output = new JSONObject();
		
//		String destinationURL = "http://192.168.223.123:8545";  // const로 정의 필요 util.constnat

		// 입력변수 체크하기
		if ( input == null ) {
			logger.info("executeBch : input data is null!");
			return null;
		} 

		// 요청 준비하기
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost httpPost = new HttpPost(destinationURL);		
		httpPost.setHeader("content-type", "application/json");
	    // json to string
		String jsonInput = input.toString();
		logger.info("input {}. {}", destinationURL, jsonInput);
	    // set http body entity		
        try {
			httpPost.setEntity(new StringEntity(jsonInput));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        // call http request & response        
		try {
			HttpResponse httpResponse;
			httpResponse = httpClient.execute(httpPost);
			logger.info(" respond code : " + httpResponse.getStatusLine().getStatusCode() );
	        logger.info("..response : {} ", httpResponse.toString());

	        // http body data to string
		    String json_string = EntityUtils.toString(httpResponse.getEntity());
			logger.info("json_string : {}", json_string);
            // string to json
			try {
		        JSONParser jsonParser = new JSONParser();
				output = (JSONObject) jsonParser.parse(json_string);
				logger.info("..to json : {}", output.toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return output;		
	}
}
