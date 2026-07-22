package day03;

public class Ex12_반복문연습예제2 {

	public static void main(String[] args) {
		/* 다음과 같이 출력되도록 코드를 작성하세요
		 * 1
		 * 12
		 * 123
		 * 1234
		 * 12345
		 * 
		 * 
		 * a부터 까지 위와 같이 나오게 코드를 작성하세요.
		 */
		
		for(int i = 1; i<=5; i++) {
			for(int j = 1; j<=i; j++ ) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		//유니코드를 이용해서
		for(int i = 97; i<=97+25; i++) {
			for(int j = 97; j<=i; j++ ) {
				System.out.print((char)j+" ");
			}
			System.out.println();
		}
		//유니코드를 몰라도 a-z를 나열해서
		for(int i = 'a'; i<='z'; i++) {
			for(int j = 'a'; j<=i; j++ ) {
				System.out.print((char)j+" ");
			}
			System.out.println();
		}
		//char변수를 이용하여
		for(char i = 'a'; i<='z'; i++) {
			for(char j = 'a'; j<=i; j++ ) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}

}
