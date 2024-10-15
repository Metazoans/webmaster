package chap13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MemberMain {
	public static void main(String[] args) {
		Set<Member> set = new HashSet<>();
		
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30));
		set.add(new Member("최길동", 25));
		set.add(new Member("최길동", 30));
		
		System.out.println("총 객체 수 : " + set.size());
		
		//set 전체 출력
		for(Member s : set) {
			System.out.println(s.name + " : " + s.age);
		}
		
		//Iterator(반복자)
		System.out.println("-------------------------------------------");
		Iterator<Member> iterator = set.iterator();
		while(iterator.hasNext()) {
			Member m = iterator.next();
			System.out.println(m.name + " : " + m.age);
		}
	}
}
