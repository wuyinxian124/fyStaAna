package edu.scut.wusir;

import java.util.Random;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}

	public void testLaa(){
		grading('A');
		grading('C');
		grading('E');
		grading('G');


	}
	public void testmeme(){
		
		String content = "WebsocketReceiveThread38 处理时间 15031 微妙";
		int first = content.indexOf("处理时间");
		int last = content.indexOf("微妙");
		String time_ = content.substring(first+4, last);
		long time0 = Long.parseLong(time_.trim());
		System.out.println(time0);
	}
	public void testAvg(){
		  Random randomno = new Random();
	      
		for(int i = 0;i < 100;i++){
			
			long delayTime = randomno.nextInt( 2900 - 800) + 800;  
			avgTime(delayTime);

		}
		long sum = 0l;
		for(int jj= 0;jj<=j;jj++){
			 sum +=avgTemp[jj]; 
		}
	
		System.out.println( sum/j);
	}
	
	public void testproduct(){
		  Random randomno = new Random();
	      
		for(int i = 0;i < 10;i++){
			
			long delayTime = randomno.nextInt( 2900 - 800) + 800;  
			System.out.println(delayTime);
		}
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
	
	public   void grading(char grade) {

		int success;
		switch (grade) {
		case 'A':
			System.out.println("Excellent grade");
			success = 1;
			break;
		case 'B':
			System.out.println("Very good grade");
			success = 1;
			break;
		case 'C':
			System.out.println("Good grade");
			success = 1;
			break;
		case 'D':
		case 'E':
		case 'F':
			System.out.println("Low grade");
			success = 0;
			break;
		default:
			System.out.println("Invalid grade");
			success = -1;
			break;
		}

		passTheCourse(success);

	}

	public   void passTheCourse(int success) {
		switch (success) {
		case -1:
			System.out.println("No result");
			break;
		case 0:
			System.out.println("Final result: Fail");
			break;
		case 1:
			System.out.println("Final result: Success");
			break;
		default:
			System.out.println("Unknown result");
			break;
		}

	}

}
