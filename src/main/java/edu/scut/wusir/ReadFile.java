package edu.scut.wusir;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Bryan-zhou
 * @date 2015年7月1日上午11:56:07
 **/
public class ReadFile {

	/**
	 * 连接用户数目
	 */
	private int conUserNum = 0;
	
	/**
	 * 连接成功数目
	 */
	private int conSUserNum = 0;
	
	/**
	 * 发送消息数目
	 */  
	private int sendMsgNum = 0; 
	
	/**
	 * 消息发送成功数目
	 */
	private int  sendSMsgNum = 0;
	
	/**
	 * 消息平均延时 
	 */
	private long sendMsgAVGDelay = 0;
	
	/**
	 * 消息最大延时
	 */
	private long sendMsgMaxDelay = 0;
	
	/**
	 * 消息发送最小延时
	 */
	private long sendMsgMinDelay = 0;
	
	/**
	 * 保存测试工具运行时的参数
	 */
	private String parameterSetting = "发送周期：1条/3s" + ",持续时间: 10s" ;
	
	public void start0(String filepath){


		BufferedReader br;
		String curline;
		int i = 0;
		try {
			br = new BufferedReader(new FileReader(filepath));

			while ((curline = br.readLine()) != null) {
				//System.out.println(curline);
				switch (dealLine(curline)){
				case 1:{
					// 连接用户数目
					conUserNum++;
					break;
				}
				case 2:{
					// 连接用户成功数目
					conSUserNum++;
					break;
				}
				case 3:{
					// 发送消息总数目
					sendMsgNum++;
					break;
				}
				case 4:{
					// 发送消息成功总数目
					sendSMsgNum++;
					break;
				}
				default: {
					
					break;
				}
				}
			}

			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		long sum = 0l;
		for(int jj= 0;jj<j;jj++){
			sum +=avgTemp[jj]; 
		}
		if(i!=0){
			if(j!=0)
				sendMsgAVGDelay = (sum10Temp/i+sum/j)/2;
			else{
				sendMsgAVGDelay = sum10Temp/i;
			}
		}
		else{
		
			if(j!=0)
				sendMsgAVGDelay = sum/j;
		}
		System.out.println("连接用户总数" + conUserNum);
		System.out.println("成功连接用户总数" + conSUserNum);
		System.out.println("互动室总数：10");
		System.out.println("互动室成员数目：10");
		//System.out.println("发送周期：1条/3s" + ",持续时间: 10s");
		System.out.println(parameterSetting);
		System.out.println("消息发送总数"+ sendMsgNum);
		System.out.println("消息发送成功总数" + sendSMsgNum);
		System.out.println("消息发送最大延时 " + (float)sendMsgMaxDelay/1000 + " 秒");
		System.out.println("消息发送平均延时 " + (float)sendMsgAVGDelay/1000 + " 秒");
		System.out.println("消息发送最小延时 " + (float)sendMsgMinDelay/1000 + " 秒");
	}
	
	/**
	 * 判断每行日志记录是否可用于统计
	 * @param curline
	 * @return
	 */
	private int dealLine(String curline){
		if(curline.contains(MsgKeyConstant.Handshake.getValue())){
			// 连接用户数目
			return 1;
		}else if(curline.contains(MsgKeyConstant.VerifySuc.getValue())){
			// 连接用户成功数目
			return 2;
		}else if(curline.contains(MsgKeyConstant.SendMsgNum.getValue())){
			// 发送消息总数目
			return 3;
		}else if(curline.contains(MsgKeyConstant.SendMsgSucNum.getValue())){
			// 发送消息成功总数目
			statistics(curline);
			
			return 4;
		}else if(curline.contains(MsgKeyConstant.SettingParameters.getValue())){
			/** 
			 *  测试工具运行参数
			 *   <br> 
			 *   包括useid起始和终止值，发送次数和发送间隔
			 */
			
			parameterSetting = curline ;
		}
		return 0;
	}
	
	private int ii = 0;
	/**
	 * 发送消息最大延时，最小延时和平均延时
	 * @param content
	 */
	private void statistics(String content){

		// String content = " WebsocketReceiveThread80 消息延时时间 15899 (毫秒)";
		int first = content.indexOf("消息延时时间");
		int last = content.indexOf("(毫秒)");
		String time_ = content.substring(first+6, last);
		long time0 = Long.parseLong(time_.trim());
		if(time0>sendMsgMaxDelay){
			sendMsgMaxDelay = time0;
		}else if(time0<sendMsgMinDelay){
			sendMsgMinDelay = time0;
		}
		if(ii == 0){
			sendMsgMinDelay = time0;
			ii++;
		}
		avgTime(time0);
		
	}

	private int i = 0;
	private int j = 0;
	private long[] avgTemp = new long[100];
	private long sum10Temp = 0l;
	private void avgTime(long delayTime){
		i++;
		if(i%100 == 0){
			sum10Temp += delayTime;
			avgTemp[j++] = sum10Temp/100;
			i = 0;
			sum10Temp = 0;
			//System.out.println("avgTemp[j++]="+avgTemp[j-1]+" j="+j);
		}else{
			sum10Temp += delayTime;
		}
		
	}

}
