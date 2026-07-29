package day06;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex14_List연습예제2 {

	public static void main(String[] args) {
		/* 3개의 중복되지 않은 정수를 입력받는 코드를 작성하세요.
		 * - 단, 1~9 사이의 정수
		 * - 중복 입력하면 다시 입력
		 * - 리스트.contains(숫자)
		 */

//		//ArrayList 생성(정수)
//		ArrayList<Integer>list = new ArrayList<Integer>();
//		Scanner scan = new Scanner(System.in);
//		//반복 : 리스트에 3개가 저장될 때까지
//		for( ;list.size() <3 ; ) {
//			System.out.print("정수 입력 : ");
//			//정수를 입력 받음
//			int num = scan.nextInt();
//			if(num <1 || num >9 ) {
//				System.out.println("숫자는 1~9 사이의 수를 입력해야 합니다.");
//				continue;
//			}
//			//입력받은 정수가 리스트에 없으면 추가
//			if(list.contains(num) ) {
//				continue;
//			}			
//			list.add(num);
//		}
//		System.out.println(list);

		//답
		System.out.println("중복되지않은 정수 3개 입력 : ");
		ArrayList<Integer>list = inputNums(3, 1, 9);
		System.out.println(list);

	}

	// size개 만큼 숫자를 입력받아 중복되지 않게 리스트에 담아 돌려주는 메서드
	public static ArrayList<Integer> inputNums(int size, int min, int max) {
		
		ArrayList<Integer>list = new ArrayList<Integer>();
		

		Scanner scan = new Scanner(System.in);
		//반복 : 리스트에 3개가 저장될 때까지
		for( ;list.size() <size ; ) {
			//정수를 입력 받음
			int num = scan.nextInt();
			//입력받은 정수가 리스트에 없으면 추가
			if(!list.contains(num) ) {
				list.add(num);				
			}
		}
		return list;
	}
}
