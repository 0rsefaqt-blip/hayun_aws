package day07;

import java.util.HashSet;
import java.util.Random;

import org.xml.sax.HandlerBase;

public class Ex01_Set {

	public static void main(String[] args) {
		/* Set
		 *  - 중복 허용 x => 순서 보장 x
		 */
		//중복되지않은 3개의 숫자를 생성(1~9)
		HashSet<Integer> set = new HashSet<Integer>();
		int min = 1, max = 9;
		
		Random random = new Random();
		//반복 : 3개가 저장될때까지
		while(set.size()<3) {
			//랜덤 수 생성
			int num = random.nextInt(min, max +1);
			//셋에 저장
			set.add(num);
		}
		System.out.println(set);
	}

}
