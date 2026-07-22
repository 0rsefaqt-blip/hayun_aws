package day03;

public class Ex06_반복문연습예제 {

	public static void main(String[] args) {
		/* 다음과 같이 출력되도록 코드를 작성하세요.
		 * 1234
		 * 5678
		 * 9101112
		 * 12141516
		 * 
		 * 숫자가 4의 배수가 아니면 ''을 출력하고 4의 배수이면 println()을 출력
		 * 
		 * 실행문 : 
		 * 1. i를 출력
		 * 2. i가 4의 배수이면 println() 엔터를 실행하고 아니면 print('') ""도 가능 공백을 실행
		 */
		for(int i=1; i<=16; ++i) {
			System.out.print(i);
			if(i%4==0) {
				System.out.println(); //엔터
			}
			else {
				System.out.print(' '); //공백
			}
		}
		//조건 연산자를 이용한 방법		
		for(int i=1; i<=16; ++i) {
			System.out.println("" + i + (i % 4 == 0 ? '\n' : ' '));
		}
	}

}
