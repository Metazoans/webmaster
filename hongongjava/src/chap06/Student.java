package chap06;

public class Student {
	/*
	//필드(속성)
	String stNo;
	String name;
	
	//생성자(객체 생성) -> 객체의 속성을 초기화
	Student(String stNo, String name) {
		this.stNo = stNo; //this = 현재 객체를 의미
		this.name = name;
	}
	
	//메소드(기능)
	void study() {
		System.out.println("공부합니다");
	}
	*/
	
	
	//필드 : 학번 이름 국어 영어 수학
	String sid;
	String sname;
	int kor;
	int eng;
	int math;
	
	//생성자 : 필드 초기화
	Student(){};
	Student(String sid, String sname, int kor, int eng, int math) {
		this.sid = sid;
		this.sname = sname;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	//메소드 : 총점 평균 등급
	int sum() {
		int sum = kor + eng + math;
		return sum;
	}
	double avg() {
		double avg = sum() / 3.0;
		return avg;
	}
	String grade() {
		String grade = "";
		int avgVal = (int)(avg() / 10);
		
		switch(avgVal) {
		case 10:
		case 9: grade = "A"; break;
		case 8: grade = "B"; break;
		case 7: grade = "C"; break;
		case 6: grade = "D"; break;
		default: grade = "F";
		}
		
		
		return grade;
	}
	
	
	
	
	
		
		
}
