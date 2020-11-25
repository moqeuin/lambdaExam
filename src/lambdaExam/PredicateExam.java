package lambdaExam;

import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateExam {

	public static void main(String[] args) {
		// 16진수를 10진수로 변환
		Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);
		// 10진수 -> 2진수
		Function<Integer, String> g = (i) -> Integer.toBinaryString(i);
		
		// andThen : f를 먼저 처리하고 처리한 결과를 매개변수로 g에게 전해주고 g를 처리한 결과를 다시 h에게 전해준다. 
		Function<String, String> h = f.andThen(g);
		// compose : 반대의 과정을거친다.(g -> f)
		Function<Integer, Integer> h2 = f.compose(g);
		
		System.out.println(h.apply("FF")); // 11111111
		System.out.println(g.apply(2)); // 0010 -> 10
		System.out.println(h2.apply(2)); // 16(*1) -> 16
		
		Function<String, String> f2 = x -> x; // 항등함수
		System.out.println(f2.apply("aaa")); //aaa
		
		
		
		Predicate<Integer> p = i -> i < 100;
		Predicate<Integer> q = i -> i < 200;
		Predicate<Integer> r = i -> i%2 == 0; // 짝수
		Predicate<Integer> notP = p.negate(); // predicate의 디폴트 메서드, not이랑 같다
		
								//i >= 100		// i < 200 또는 짝수 
		Predicate<Integer> all = notP.and(q.or(r));
		System.out.println(all.test(150)); // true
		System.out.println(all.test(201));  // false
		System.out.println(all.test(202));  // true
		
		String str1 = "abc";
		String str2 = "abc";
		
		// isEqual는 두 대상을 비교할 때 쓰이면 람다식을 대입하는 것과 같다
		Predicate<String> p2 = Predicate.isEqual(str1);
		boolean result = p2.test(str2);
		System.out.println(result); // true
	}

}
