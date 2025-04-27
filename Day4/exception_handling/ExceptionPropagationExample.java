package exception_handling;

public class ExceptionPropagationExample {

    public static void method1() {
        System.out.println("Inside method1");
        int result = 10 / 0; 
        System.out.println("After exception in method1 (this will not be reached)");
    }

    public static void method2() {
        System.out.println("Inside method2");
        method1(); 
        System.out.println("After method1 in method2 (this will not be reached)");
    }

    public static void main(String[] args) {
        System.out.println("Inside main");
        try {
            method2(); 
        } catch (ArithmeticException e) {
            System.err.println("Handled exception in main");
        }
        System.out.println("Exiting main");
    }
}