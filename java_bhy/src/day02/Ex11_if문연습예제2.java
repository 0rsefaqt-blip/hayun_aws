package day02;

import java.util.Scanner;

public class Ex11_if문연습예제2 {

	public static void main(String[] args) {
		/* Ex08_콘솔입력연습예제를 참고해서 두 정수와 연산자를 입력해서 연산 결과를 출력하는 코드를 작성하세요
		 * - 연산자는 만 처리
		 * 
		 * 예시
		 * 정수1 입력: 1
		 * 연산자 입력: /
		 * 정수2 입력: 2
		 * 1/2 = 0.5
		 * 
		 * 예시
		 * 정수1 입력 : 1
		 * 연산자 입력 : ?
		 * 정수2 입력 : 2
		 * ?는 산술 연산자가 아닙니다.
		 */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요. : ");
		int num = scan.nextInt();
		//계산을 위해서 변수를 문자열이 아닌 문자로 (char) 바꾸고 
		System.out.print("연산자를 입력하세요. : "); 
		char op = scan.next().charAt(0);

		System.out.print("정수를 입력하세요. : ");
		int num2 = scan.nextInt();
		//문자열이 아닌 문자이기 때문에 ''안에 넣음
		if(op == '+') {
			//직접 계산을 하려면 ()안에 한번 더 넣기
			System.out.println("" + num + op + num2 + "=" + (num + num2));
		}
		else if(op == '-') {
			System.out.println("" + num + op + num2 + "=" + (num - num2));
		}
		else if(op == '*') {
			System.out.println("" + num + op + num2 + "=" + (num * num2));
		}
		else if(op == '/') {
			//나누기는 한쪽이 실수여야 계산이 되기 때문에 아무거나 하나를 실수변수로 바꿔준다
			System.out.println("" + num + op + num2 + "=" + (num / (double)num2));
		}
		else if(op == '%') {
			System.out.println("" + num + op + num2 + "=" + (num % num2));
		}
		else{
			System.out.println(op+ "는 산술연산자가 아닙니다");
		}

		

	}

}
