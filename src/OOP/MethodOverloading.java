package OOP;

public abstract class MethodOverloading {

    public static void main(String[] args) {

        DefaultScopeClass defaultScopeClass = new DefaultScopeClass();
    }

    public abstract int add(int a);

    /**
     * overloading with different number of parameters
     */
    public abstract int add (int a , int b);


    /**
     * Overloading with different type of parameters
     */
    public abstract int add(int a , float b);

    /**
     * Overloading with order of Data type of parameters.
     */
    public abstract int add(float a, int b);

    public abstract int add(float a);

    /**
     * Invalid overload , the argument list is the same
     */
//    public abstract int add(int b , int a);

    /**
     * Invalid overloading
     * When I say argument list, I am not talking about return type of the method,
     * for example if two methods have same name, same parameters and have different return type,
     * hen this is not a valid method overloading example. This will throw compilation error.
     */
//    public abstract float add(int a);
}
