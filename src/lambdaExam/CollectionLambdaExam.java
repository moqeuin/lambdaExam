package lambdaExam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CollectionLambdaExam {

	public static void main(String[] args) {
		// 컬렉션 인터페이스에서 함수형 인터페이스를 사용한 디폴트메서드들 구현
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		list.forEach(i->System.out.print(i + ", "));
		// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
		
		System.out.println();
		
		// 2 또는 3의 배수를 제거
		list.removeIf(x->x%2==0 || x%3==0);
		System.out.print(list); //[1, 5, 7]
		
		System.out.println();
		
		// 10의 배수로 대체
		list.replaceAll(i->i*10);
		System.out.println(list); //[10, 50, 70]
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("1","1");
		map.put("2","2");
		map.put("3","3");
		map.put("4","4");
		map.put("5","5");
		
		map.forEach((k,v) -> System.out.print("{"+k+","+v+"},"));
		// {1,1},{2,2},{3,3},{4,4},{5,5},
		System.out.println();
	}

}