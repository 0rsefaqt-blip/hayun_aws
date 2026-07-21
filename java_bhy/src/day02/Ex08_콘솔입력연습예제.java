package day02;

import java.util.Scanner;

public class Ex08_콘솔입력연습예제 {

	public static void main(String[] args) {
		//다음과 같이 입력이 되도록 코드를 작성해서 입력받으세요.
		/*- 정수 연산자 정수 순으로 입력.
		 * - scanner를 이용하여 1, +, 2를 입력받음
		 * 예시
		 * 정수를 입력하세요: 1
		 * 연산자를 입력하세요: +
		 * 정수를 입력하세요.: 2
		 * 결과 : 1 +2
		 * 
		 * */

		  Scanner scan = new Scanner(System.in);
	      
		  System.out.print("정수를 입력하세요. : ");
	      int num = scan.nextInt();
	      
	      System.out.print("연산자를 입력하세요. : "); //문자열도 되고 문자도 됨
	      String operator = scan.next();
	      
	      System.out.print("정수를 입력하세요. : ");
	      int num2 = scan.nextInt();
	      
	      System.out.println( num  + operator + num2 );
	      
	}

}
