package day02;

import java.util.Scanner;

public class Ex07_콘솔입력 {
	
	public static void main(String[] args) {
	      /* 자바에서 콘솔창에서 입력을 하는 방법
	       * Scanner 이용하기
	       * - Scanner를 이용하여 정수, 실수, 문자열을 입력 받을 수 있음
	       *   - 정수 : nextInt()
	       *   - 실수 : nextDouble(), nextFloat()
	       *   - 문자열 : next(), nextLine()
	       *   - 문자 : next().charAt(0)
	       *   
	       * println() : 안에 있는 내용을 콘솔에 출력하고 엔터 다음줄에 나옴
	       * print() : 안에 있는 내용만 콘솔에 출력
	       */

			//스캐너 만들기 시작하려면 필수로 있어야하는 한줄
	      Scanner scan = new Scanner(System.in); //외우기
	      System.out.print("정수 입력 : ");
	      int num = scan.nextInt();
	      System.out.println("입력된 정수 : " + num);
	      
	      System.out.print("실수 입력 : ");
	      double num2 = scan.nextDouble();
	      System.out.println("입력된 실수 : " + num2);
	      
	      //next() : 공백을 제거한 문자열로 단어를 입력받음
	      System.out.print("문자열 입력 : ");
	      String str1 = scan.next();
	      System.out.println("입력된 문자열 : " + str1);
	      //nextLine() : 공백을 포함한 문자열 한줄을 입력받음. 엔터 입력 주의
	      System.out.print("문자열 입력 : ");
	      
	      scan.nextLine();//위에서 입력한 엔터를 비우기 위해서
	      String str2 = scan.nextLine();
	      System.out.println("입력된 문자열 : " +  str2);
	      
	      System.out.print("문자 입력 : ");
	      char ch = scan.next().charAt(0);//문자열에서 0번지에(첫번째) 글자를 가져옴
	      System.out.println("입력된 문자 : " + ch);
	   }

}
