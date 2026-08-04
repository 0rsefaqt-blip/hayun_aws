package day10_exam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ex01_학생관리프로그램시험용 {// 검색기능 삭제기능 구현

	public static void main(String[] args) {
		StudentProgram promgram = new StudentProgram();
		promgram.run();
	}

}

class StudentProgram {

	private Scanner scan = new Scanner(System.in);
	StudentManager manager = new StudentManager(null);

	public void run() {

		Student std = new Student(2, 1, 5, "김수현");
		std.updateScore(95);
		System.out.println(std);
		manager.insertStudent(std);

		Student std2 = new Student(2, 1, 12, "최민수");
		std2.updateScore(88);
		System.out.println(std2);
		manager.insertStudent(std2);

		Student std3 = new Student(1, 3, 2, "이영희");
		std3.updateScore(77);
		System.out.println(std3);
		manager.insertStudent(std3);

		System.out.println();
		System.out.println("검색할 학생 정보 입력");

		while (true) {

			try {
				// 학년, 반, 번호를 입력
				System.out.print("학년 : ");
				int grade = scan.nextInt();
				System.out.print("반  : ");
				int classNum = scan.nextInt();
				System.out.print("번호 : ");
				int num = scan.nextInt();
				Student searchStudent = new Student(grade, classNum, num, null);
				manager.searchStudent(searchStudent);
				break;
			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력해주세요.");
				scan.nextLine();
			}
		}

		// 검색 기능 구현
		System.out.println();
		System.out.println("삭제할 학생 정보 입력");

		while (true) {
			try {
				// 학년, 반, 번호를 입력
				System.out.print("학년 : ");
				int grade = scan.nextInt();
				System.out.print("반 : ");
				int classNum = scan.nextInt();
				System.out.print("번호 : ");
				int num = scan.nextInt();

				Student deleteStudent = new Student(grade, classNum, num, null);

				manager.deleteStudent(deleteStudent);
				break;

			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력해주세요.");
				scan.nextLine();
			}
		}

		// 삭제 기능 구현
		System.out.println();

		System.out.println("== 정렬 ==");
		// 정렬
		manager.sort();
		manager.printStudents();
	}

}

class StudentManager {

	// 학생 목록
	List<Student> list;

	// 학생 목록이 있으면 가져와서 관리
	public StudentManager(List<Student> list) {
		// 넘겨준 학생 목록이 없으면 새 학생 목록을 만듬
		if (list == null) {
			this.list = new ArrayList<Student>();
			return;
		}
		// 학생 목록이 있으면 받아와서 사용
		this.list = list;

	}

	public void deleteStudent(Student deleteStudent) {

	    if (list.remove(deleteStudent)) {
	        System.out.println("삭제완료");
	    } else {
	        System.out.println("등록된 학생이 없습니다.");
	    }

	}
	public void searchStudent(Student searchStudent) {
		int index = list.indexOf(searchStudent);
		// 리스트의 indexof를 이용하여 위치를 찾은 후

		// 해당 번지가 -1이면 없다고 출력
		if (index == -1) {
			System.out.println("등록된 학생이 없습니다.");
		}
		// -1이 아니면 해당 번지의 학생정보를 출력
		else {
			System.out.println(list.get(index));

		}

	}

	public boolean insertStudent(Student std) {
		// 리스트에 std가 등록됐지는 확인해서 등록되어 있으면 false를 리턴
		// Student.equals()를 오버라이딩해서 처리해야 함
		if (list.contains(std)) {
			return false;
		}
		// 등록이 안되어 있으면 리스트에 학생을 추가하고 true를 리턴
		// List.add()는 추가한 후 추가하면 true를 리턴,
		// return list.add(std);
		list.add(std);
		return true;
	}

	public void printStudents() {
		sort();
		if (list.size() == 0) {
			System.out.println("등록된 학생이 없습니다.");
		}
		for (Student std : list) {
			System.out.println(std);
		}
	}

	public void sort() {
		// 출력전 학년, 반, 번호 순으로 정렬
		list.sort(
				// 학년을 기준으로 정렬
				Comparator.comparing(Student::getGrade)
						// 학년이 같으면 반을 기준으로 정렬
						.thenComparing(Student::getClassNum)
						// 반이 같으면 번호를 기준으로 정렬
						.thenComparing(Student::getNum)
		// 내림차순은 .reverse()추가
		);
	}

	public boolean updateScore(Student std, int score) {
		if (std == null) {
			return false;
		}
		// 등록된 학생이 아니면
		// indexOf는 몇번지에 있는지 알려줌. -1 => 없음
		int index = list.indexOf(std);
		if (index == -1) {
			return false;
		}
		// index 번지에 있는 학생 성적을 수정
		// list.get(index) => 수정할 학생 정보
		list.get(index).updateScore(score);
		return true;
	}

	public Object getList() {
		return this.list;
	}

	// 기능들

}

class Student {

	private int grade, classNum, num;
	private String name;
	private int score;

	public Student(int grade, int classNum, int num, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}

	@Override
	public String toString() {
		return grade + "학년 " + classNum + "반 " + num + "번 " + name + "- 점수 : " + score;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classNum == other.classNum && grade == other.grade && num == other.num;
	}

	public void updateScore(int score) {
		this.score = score;

	}

	public int getGrade() {
		return grade;
	}

	public int getClassNum() {
		return classNum;
	}

	public int getNum() {
		return num;
	}

}