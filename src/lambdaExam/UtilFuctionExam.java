package lambdaExam;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class UtilFuctionExam {

	public static void main(String[] args) {
		
		// 함수형 인터페이스를 매번 필요할 때마다 선언하는 것은 번거롭기 때문에
		// java.util.funtion패키지의 인터페이스를 사용하는 것이 효율적이다
		// 함수의 형태를 미리 정해놓고 사용
		
		// 매개변수 x, 반환형 o(지정), get()
		Supplier<Integer> s = () -> (int)(Math.random()*100)+1;
		// 매개변수 o(지정), 반환형 x, test()
		Consumer<Integer> c =  i -> System.out.print(i + ", ");
		// 매개변수(지정)o, 반환형 boolean, accept()
 		Predicate<Integer> p = i -> i%2==0;
 		// 매개변수(지정) o, 반환형(지정),apply()
 		Function<Integer, Integer> f = i -> i/10*10; // i의 일의 자리를 없앤다
 		
 		List<Integer> list = new ArrayList<Integer>();
 		makeRandomList(s, list);
 		System.out.println(list);
 		printEvenNum(p, c, list);
 		List<Integer> newList = doSomething(f, list);
 		System.out.println(newList);
 		
	}

	
	static <T> void makeRandomList(Supplier<T> s, List<T> list) {
		for (int i = 0; i < 10; i++) {
			list.add(s.get());
		}
	}
		
	static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
		System.out.print("[");
		for (T i : list) {
			// 짝수일 때 출력
			if(p.test(i))
				c.accept(i);
		}
		System.out.println("]");
	}
	
	// 1의 자리를 없애고 list 반환
	static <T> List<T> doSomething(Function<T, T> f, List<T> list){
		List<T> newList = new ArrayList<T>(list.size());
		for (T i : list) {
			newList.add(f.apply(i));
		}
		return newList;
	}
}
