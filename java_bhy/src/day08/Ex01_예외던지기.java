package day08;

import java.util.ArrayList;
import java.util.Random;

import org.w3c.dom.ranges.RangeException;

public class Ex01_예외던지기 {

	public static void main(String[] args) {
		/* 에외처리 방법
		 * 1. 직접 처리
		 *  => 문제가 발생한 곳에서 직접 해결
		 *  => try catch문으로
		 * 2. 예외를 넘기기
		 *  => 문제가 발생하면 일을 시킨 곳에게 문제를 넘김
		 *  => throws => 나 이런 예외 발생할 수 있으니 사용할 때 조심해줘라고 얘기를 해야 함
		 *  - 얘기를 안해도 되는 경우
		 *   => RuntimeException 예외들 자동으로 넘기기 해줌 => 에외처리를 하지 않아도 에러가 발생하지 않는 예외들 
		 *   (1/0)같은 경우 빨간줄이 뜨지 않지만 sysout 실행시키면 0으로 나눠지지않는다는 오류문구가 뜸 
		 *   
		 * 3. 예외던지기
		 * - 개발자가 필요에 의해 예외를 발생시킴 (일부러)
		 * - throw (넘기기는 s붙임) 
		 *
		 *   
		 *  
		 */
		try {// 3. 트라이캐치써줘야됨
			System.out.println(createRandomArray(1, 2, 3));//원래 이것만 있었는데 
			
		}catch (Exception e) {
			//e.getMessage() : 예외 객체를 생성할 때 지정한 문구를 가져옴
			System.out.println(e.getMessage());
			//예외가 발생한 곳들을 추적해서 콘솔에 출력. 프로그램 중단이 아님 빨간글씨가 뜨는건 어디서 발생한것인지 알려주는것
			e.printStackTrace();//또 자주쓰는거 프로그램이 종료되지않고 알려주기만 하는거 어디서 중단됐는지 알고싶어서 추가한것
		}
		System.out.println("프로그램 종료");

	}
	
	//min ~ max 사이의 중복되지 않은 정수 size 개를 만들어서 리스트로 리턴하는 메서드
	public static ArrayList<Integer> createRandomArray(int min, int max, int size) throws Exception{ //2. 뜨로우스 익셉셥 써주고
		
		//중복되지 않게 size개만큼 만들 수 없으면 예외를 발생 시킴
		//중복되지 않게 만들 수 있는 숫자의 개수 : max - min+1
		if(max - min+1 < size) {
//			RuntimeException e = 
//					new RuntimeException(max - min +1 +"개의 중복되지 않은 수"
//							+size+"개를 만들 수 없습니다.");
//			throw e;
			//위 세줄을 두줄로 줄일 수 있다 
			throw new Exception(max - min +1 +"개의 중복되지 않은 수 "
					+size+"개를 만들 수 없습니다."); //1. 런타임글씨 지우면
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		while (list.size() < size) {
			Random random = new Random();
			int num = random.nextInt(min, max +1);
			
			if(!list.contains(num)) {
				list.add(num);
			}
		}
		return list;
	}

}
