package chap06;

public class StudentMain {

	public static void main(String[] args) {
		/*
		//객체 생성
		Student st1 = new Student("240901", "강땡땡");
		System.out.println(st1.stNo);
		System.out.println(st1.name);
		st1.study();
		
		Student st2 = new Student("240902", "김땡떙");
		System.out.println(st2.stNo);
		System.out.println(st2.name);
		st2.study();
		*/
		
		//실행클래스
		//학생 이름 국어 영어 수학 총점 평균 등급 출력
		//학생 5명
		Student[] std = new Student[5];
		
		for(int i = 0; i < 5; i++) {
			int ranNum1 = (int)(Math.random() * 51) + 50;
			int ranNum2 = (int)(Math.random() * 51) + 50;
			int ranNum3 = (int)(Math.random() * 51) + 50;
			std[i] = new Student("학번" + (i + 1), "학생" + (i + 1), ranNum1, ranNum2, ranNum3);
		}
		
		for(Student i : std) {
			System.out.printf("%s : %4d : %4d : %4d : %5d :  %5.2f : %s\n", i.sname, i.kor, i.eng, i.math, i.sum(), i.avg(), i.grade());
		}
		
	}

}
