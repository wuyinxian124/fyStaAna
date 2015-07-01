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

		BufferedReader br;
		String curline;
		int i = 0;
		try {
			br = new BufferedReader(new FileReader(filepath));

			while ((curline = br.readLine()) != null) {
				System.out.println(curline);
				if(i++==5) break;
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
