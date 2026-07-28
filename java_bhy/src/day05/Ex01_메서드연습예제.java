package day05;

public class Ex01_메서드연습예제 {

	public static void main(String[] args) {
		// 예제목적 : return을 만나면 메서드를 빠져나온다는 것을 보여주기 위한 예제
		// => return이 끝에만 있는 것이 아님 중간에 있을수도 있다
		int num1 =8, num2 = 12;
		System.out.println(num1+"과 "+num2+"의 최소공배수 : "+lcm(num1,num2));

	}
	/* 기능: 두 정수의 최소 공배수를 구하는 메서드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 최소 공배수 => 정수 => int
	 * 메서드명 : lcm
	 */
//	static int lcm(int num1, int num2) {
//		int lcm = 1;
//		for(int i = num1; ; i+= num1) {
//			if(i % num2 == 0) {
//				lcm = i;
//				break;
//			}
//		}
//		return lcm; //얘를 어떤 방식으로 바꿀수있는지 설명하기위해 진행하는 예제
//	}
	static int lcm(int num1, int num2) {
//		int lcm = 1;
		for(int i = num1; i<=num1*num2 ; i+= num1) { //조건식을 추가
			if(i % num2 == 0) {
				return i;
//				lcm = i;
//				break;
			}
		}
		return num1*num2; //어떤경로에서도 return으로 빠져나가야하기때문에 하나를 더 추가 식이 참이 아닐경우를대비
//		return lcm; 
	}
}
