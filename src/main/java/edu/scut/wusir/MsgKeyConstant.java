package edu.scut.wusir;

/**
 * @author Bryan-zhou
 * @date 2015年7月1日下午4:22:06
 **/
public enum MsgKeyConstant {

	/**
	 * 测试工具运行参数
	 * <br>
	 * 包括useid起始和终止值，发送次数和发送间隔
	 */
	SettingParameters("设置参数connectNum"),
	
	/**
	 * 消息发送成功总数目
	 */
	SendMsgSucNum("消息延时时间"),
	
	/**
	 * 发送消息总数目
	 */
	SendMsgNum("发送消息"),
	
	/**
	 * 握手成功状态，表示真正实现握手的连接数目
	 */
	VerifySuc("onVerify : 验证成功"),
	
	SendVerifyNum("verify : 发送用户验证消息"),
	
	/**
	 * 握手成功，表示用户已经连接消息系统服务器
	 */
	HansShakeSuc("onHandshake : 握手成功"),
	/**
	 * 开始握手标志，用来统计有多少用户连接
	 */
	Handshake("startHandshake");
	
	private MsgKeyConstant(String value){
		this.value_ = value;
	}
	
	private String value_;
	
	public String getValue(){
		return value_;
	}

}
