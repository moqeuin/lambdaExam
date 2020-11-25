package lambdaExam;

public class LambdaExam {
	
	// 람다식 : 메서드를 하나의 식으로 표현하는 방법을 말한다.
	// 람다식도 하나의 익명객체로 취급하며 이러한 람다식을 참조변수를 참조하기 위해서 함수형 인터페이스를 사용한다.
	// 함수의 이름과 반환값을 제거하고 함수의 몸통사이에 ->를 끼워넣는다.
	// (a, b) -> a>b?a:b  매개변수의 타입은 생략가능하고 괄호{}안에 문장 한 개 일 경우에 괄호를 생략가능
	// 매개변수가 한 개 이면 괄호()생략가능 만약 타입을 지정했으면 생략이 안된다. (int i) -> a
	// 괄호 안에 문장이 리턴문이라면 괄호{}를 생략할 수 없다.
	
	// 매개변수로 람다식 사용 
	static void execute(MyFunction f) {
		f.run();
	}
	
	// 반환형을 람다식 사용
	static MyFunction getMyFunction() {
		MyFunction f = () -> System.out.println("f3.run()");
		return f;
	}
	
	public static void main(String[] args) {
		  	
		// 참조변수로 람다식 참조 
		MyFunction f1 = () -> System.out.println("f1.run()");
		// 참조변수로 익명함수 참조 
		MyFunction f2 = new MyFunction() {
							public void run() {
								System.out.println("f2.run()");
							}
						};
		// 함수로 리턴해서 람다식 참조
		MyFunction f3 = getMyFunction();
		
		f1.run();
		f2.run();
		f3.run();
		
		execute(f1);
		// 람다식 자체를 매개변수로 사용가능
		execute(()->System.out.println("run()"));
		
	}

}

// 함수형인터페이스
// 사용하기위해서 애너테이션을 달아야하고 람다식과 대응시키기 위해서 오직 하나의 추상메서드만 선언해야한다. 
@FunctionalInterface
interface MyFunction{
	void run();
}