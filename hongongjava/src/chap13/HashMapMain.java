package chap13;

import java.util.*;

public class HashMapMain {
	public static void main(String[] args) {
		// map : 키와 값으로 구성된 entry 저장
		Map<String, Integer> map = new HashMap<>();
		
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95);
		System.out.println("총 Entry 수: " + map.size());
		
		System.out.println("홍길동 : " + map.get("홍길동"));
		System.out.println();
		
		Set<String> keySet = map.keySet();
		for(String key : keySet) {
			System.out.println(key + " : " + map.get(key));
		}
		/*
		Iterator<String> keyIr = keySet.iterator();
		while(keyIr.hasNext()) {
			String key = keyIr.next();
			Integer value = map.get(key);
			System.out.println("\t" + key + " : " + value);
		}
		*/
		System.out.println();
		
		map.remove("홍길동");
		System.out.println("총 Entry 수: " + map.size());
		
		//객체 하나씩 처리
		//var == Set<Map.Entry<String, Integer>> => map이 <String, Integer>로 이루어진 것을 알고 있기 때문에 사용 가능
		//java 버전 낮으면 사용 불가
		var entrySet = map.entrySet();
		for(var entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		/*
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIr = entrySet.iterator();
		
		while(entryIr.hasNext()) {
			Map.Entry<String, Integer> entry = entryIr.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t" + key + " : " + value);
		}
		*/
		System.out.println();
		
		map.clear();
		System.out.println("총 Entry 수: " + map.size());
		
		
		
		
		
		
	}
}
