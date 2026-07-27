package day04;

public class Ex09_클래스연습예제 {
	
	public static void main(String[] args) {
	
		
		/*1학년 1반 1번 홍길동 학생 객체(인스턴스)를 생성하세요.*/
		student hong = new student(1, 1, 1, "홍길동");
		//홍길동 학생의 정보를 출력하세요.
		hong.print();
		//홍길동 학생의 국어, 영어, 수학점수를 100, 90, 80으로 변경
		hong.updateScore(100,90,80);
		//변경된 학생의 정보를 출력하세요.
		hong.print();
	}
}
/* 학생의 성적을 관리하기 위한 학생 클래스를 만드세요.
 * - 클래스명 : student
 * - 학생의 학년, 반, 번호, 이름, 국어성적, 영어성적, 수학성적을 관리하는 필드를 선언하세요.
 */

class student{
	
	//필드
	int grade, classNum, num;
	String name;
	int koScore, enScore, maScore;
	//메서드
	//학생의 학년, 반, 번호, 이름, 국어, 영어, 수학 성적을 콘솔에 출력하는 메서드
	//매개변수: 없음
	//리턴타입: 없음 => void
	//메서드명: print
	void print() {
		System.out.println(grade + "학년"+classNum+"반"+num+"번"+name);
		System.out.println("국어성적 : "+koScore);
		System.out.println("영어성적 : "+enScore);
		System.out.println("수학성적 : "+maScore);
	}
	/*기능 : 주어진 국어, 영어, 수학 성적으로 학생의 국어, 영어, 수학 성적을 바꾸는 메서드
	 * 매개변수 : 성적 
	 * 리턴타입 : 없음
	 * 메서드명 : updateScore
	 */
	void updateScore(int koScore1, int enScore1, int maScore1) {
		koScore = koScore1;
		enScore = enScore1;
		maScore = maScore1;
	}
	
	
	//생성자
	//학생의 기본 학년, 반, 번호는 1학년 1반 1번
	student() {
		grade = 1;
		classNum = 1;
		num = 1;
	}
	public student(int grade1, int classNum1, int num1, String name1) {
		grade = grade1;
		classNum = classNum1;
		num = num1;
		name = name1;
	}
	
}