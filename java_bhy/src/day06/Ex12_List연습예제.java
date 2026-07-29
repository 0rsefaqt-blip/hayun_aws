package day06;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex12_List연습예제 {

	public static void main(String[] args) {
		//ArrayList를 이용하여 정수를 저장하는 list를 생성
		ArrayList<Integer>list = new ArrayList<Integer>();
		
		Scanner scan = new Scanner(System.in);
		//list에 숫자 3개 입력하여 저장
		for( ;list.size() <3 ; ) {
			System.out.print("정수 입력 : ");
			int num = scan.nextInt();
			list.add(num);	
		}
//		세번 반복하는 일을 위에 for문으로 한번만 하게
//		System.out.print("정수1 입력 : ");
//		int num = scan.nextInt();
//		System.out.print("정수2 입력 : ");
//		int num2 = scan.nextInt();
//		System.out.print("정수3 입력 : ");
//		int num3 = scan.nextInt();
//
//		list.add(num);
//		list.add(num2);
//		list.add(num3);
		
		//list에 있는 값을 콘솔에 출력
		System.out.println(list);
		
		

	}

}
