package lambdaExam;

import java.util.function.Function;
import java.util.function.Supplier;

public class ReferenceExam {

	public static void main(String[] args) {
		
		// 메서드 참조
		// 하나의 메서드만 호출하는 람다식을 클래스이름::메서드이름, 참조변수::메서드이름으로 표현가능
		
		// 반환값과 매개변수 여부만 가지고 변수로 참조
		// 입력값 -> 출력값 인 모든 메서드는 참조가능
		Function<String, Integer> f = Integer::parseInt;
		Function<String, String> f2 = testClass::testStr;
		System.out.println(f.apply("2")); 
		
		// 참조객체에대한 메소드도 참조할 수 있다.
		String str = new String("test");
		Function<String, Integer> f3 = str::indexOf;
		System.out.println(f3.apply("t")); // 0
		
		//생성자 메서드 참조
		
		Function<Integer, int[]> f4 = int[]::new;
		Supplier<testClass> s = testClass::new;
	}
		
}
class testClass{
	int n = 0;
	public testClass() {
	
	}
	public testClass(int n) {
		this.n = n;
	}
	
	
	static String testStr(String str) {
		return str;
	}
}
