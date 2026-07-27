package day04;

public class Ex02_배열 {

	public static void main(String[] args) {
		/* 자바에서는 배열보다 리스트를 많이 쓰기 때문에 배열은 기본 사용법만 기억하자 
		 * 왜냐면 js의 배열처럼 기능들이 있어서 java의 배열은 기능이 없음
		 * */
	      /* 배열 p.211
	       * - 같은 형태의 자료를 여러개 관리 할 때 사용
	       *  => js는 한 배열에 숫자도 넣고 문자도 넣고 객체도 넣을 수 있음
		 *      let arr = [1, 'a', {}]
	       * - 예 : 학생들의 국어 성적을 관리, 학생 정보를 관리
	       * - 연속된 공간에 배열을 생성 => 탐색이 빠름
	       * - 왜?
	       *   - 반복문을 사용할 수 있기 때문
	       * - 선언 방법 p.212
	       *   1. 자료형 [] 배열명 = new 자료형[크기];
	       *   2. 자료형 배열명 [] = new 자료형[크기];  
	       *   3. 자료형 [] 배열명 = {값1, 값2, 값3};
	       *   4. 자료형 [] 배열명 = new int[]{값1, 값2, 값3};
	       *   1과 2는 약간 차이가 있음
	       * - 배열 사용 p.213
	       *   - 배열명[번지]를 이용하여 값을 가져오거나 수정
	       *   - 번지는 0번지부터 크기-1번지까지 가능
	       *   - 잘못된 번지를 입력하면 예외가 발생
	       * - 배열의 길이
	       *   - 배열명.length
	       * */
		//korScores1과 num1은 int를 공통으로 사용 =>int num1은 배열이 아님
		  int korScores1 [], num1;
		  //korScores2와 num2는 int[]을 공통으로 사용  => num2는 int [] num2;
		  int [] korScores2, num2;
		  
		  int [] korScores3 = {1, 2, 3};
//		  korScores3 = {4, 5, 6}; //에러발생. 선언과 동시에 초기화 할때만 사용
		  
		  int [] korScores4 = new int[]{1, 2, 3};
		  korScores4 = new int[] {4, 5, 6};
		  
		  korScores4[0] = 7;
		  korScores4[1] = 8;
		  korScores4[2] = 9;
//		  korScores4[3] = 10; 
		  
		  for(int i = 0; i <korScores4.length; i++) {
			  System.out.println(korScores4[i]);
		  }
	      //nums1 : 배열, nums2 : 변수
	      int [] arr1 = new int[3], /*int [] */nums1;
	      int arr2 [] = new int[3], /*int */nums2;
	      //nums1 = 10;//배열 nums1에 10(주소)으로 저장. 에러 발생
	      nums2 = 10;//정수 변수 nums2에 10을 저장. 에러 발생 X
	      
	      int [] arr3 = {1,2,3};
	      int [] arr4 = new int[] {1,2,3};

	      //arr3 = {4,5,6}; //배열 선언 이후에는 이 방법으로 재할당이 안됨
	      arr4 = new int[] {4,5,6};//배열 선언 이후에도 이 방법으로 재할당이 가능
	      System.out.println(arr4[0]);
	      //System.out.println(arr4[3]);//실행시 예외가 발생
	      
	   }

}
