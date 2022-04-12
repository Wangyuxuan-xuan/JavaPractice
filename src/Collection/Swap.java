package Collection;

public class Swap {

    public static void main(String[] args) {

        int a = 1 ;
        int b = 2 ;

        System.out.println("a : " + a);
        System.out.println("b : " + b);

        a = swap(b,b = a);

        System.out.println("a : " + a);
        System.out.println("b : " + b);

    }

    /**
     * A trick to swap in Java
     */
    public static int swap(int a , int b){
        return a;
    }
}
