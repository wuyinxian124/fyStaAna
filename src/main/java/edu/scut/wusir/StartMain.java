package edu.scut.wusir;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试结果统计与分析
 * @author wurunzhou
 *
 */
public class StartMain {


	//private static String filepath = "./fysocket20150702-115842.log";//fysocket20150630-044312.log";

	public static void main(String[] args) {
		new StartMain().beginOp();
	}
	
	private void beginOp(){

		// 测试路径 /home/wusir/project/git/github/fysocketMultiTest
		//  /home/wusir/project/git/github/fysocketAPPClient
		// /home/wusir/project/git/github/fysocketMultiTest
    	String filePath = "/home/wusir/project/测试结果/";
    	File f = null;  
    	f = new File(filePath);  
    	File[] files = f.listFiles(); // 得到f文件夹下面的所有文件。  
    	List<File> list = new ArrayList<File>();  
    	for (File file : files) {  
    	    if(file.isFile()&&!file.isHidden()&&file.getName().contains(".log")) { 
    	        list.add(file);  
    	    }  
    	}  
    	for(File file : files) {  
			if (file.getName().contains(".log")
					&& !file.getName().contains(".lck")) {
				System.out.println("开始读取日志" + file.getAbsolutePath());
				// System.out.println(file.getName().contains(".log"));
				new ReadFile().start0(file.getAbsolutePath());
			}
    	} 
    
	}

}
