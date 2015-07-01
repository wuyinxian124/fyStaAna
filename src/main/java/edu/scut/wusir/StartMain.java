package edu.scut.wusir;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 测试结果统计与分析
 * @author wurunzhou
 *
 */
public class StartMain {


	private static String filepath = "./fysocket20150630-044312.log";

	public static void main(String[] args) {
		new ReadFile().start0(filepath);
	}
	

}
