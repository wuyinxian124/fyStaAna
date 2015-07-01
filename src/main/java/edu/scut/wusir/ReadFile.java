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
	
	public void start0(String filepath){


		BufferedReader br;
		String curline;
		int i = 0;
		try {
			br = new BufferedReader(new FileReader(filepath));

			while ((curline = br.readLine()) != null) {
				System.out.println(curline);
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
		}finally{
			if( i!= 0){
				avgTemp[j] += sum10Temp/i;
			}
			
		}
		long sum = 0l;
		for(int jj= 0;jj<=j;jj++){
			 sum +=avgTemp[jj]; 
		}
	
		sendMsgAVGDelay = sum/j;
		
		System.out.println("连接总数" + conUserNum);
		System.out.println("消息连接成功总数" + conSUserNum);
		System.out.println("消息发送总数"+ sendMsgNum);
		System.out.println("消息发送成功总数" + sendSMsgNum);
		System.out.println("消息发送最大延时" + sendMsgMaxDelay);
		System.out.println("消息发送平均延时" + sendMsgAVGDelay);
		System.out.println("消息发送最小延时" + sendMsgMinDelay);
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
		}
		return 0;
	}
	
	/**
	 * 发送消息最大延时，最小延时和平均延时
	 * @param content
	 */
	private void statistics(String content){
		//String content = "WebsocketReceiveThread38 处理时间 15031 微妙";
		int first = content.indexOf("处理时间");
		int last = content.indexOf("微妙");
		String time_ = content.substring(first+4, last);
		long time0 = Long.parseLong(time_.trim());
		if(time0>sendMsgMaxDelay){
			sendMsgMaxDelay = time0;
		}else if(time0<sendMsgMinDelay){
			sendMsgMinDelay = time0;
		}
		avgTime(time0);
		
	}
	private int i = 0;
	private int j = 0;
	private long[] avgTemp = new long[10];
	private long sum10Temp = 0l;
	private void avgTime(long delayTime){
		i++;
		if(i%50 == 0){
			avgTemp[j++] += sum10Temp/50;
			i = 0;
		}else{
			sum10Temp += delayTime;
		}
	}
}
