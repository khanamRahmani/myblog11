public class ClassTest2 {
    public static void main(String[] args) {
        predicate<Integer>val=y->y%2==0;
        boolean result=val.test(10);
        System.out.println(result);
    }
}
