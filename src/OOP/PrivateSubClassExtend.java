package OOP;

public class PrivateSubClassExtend extends PrivateSubClass{

    public int addSubClass(){
        this.addPublic(0);
//        addPrivate(int)' has private access in 'OOP.PrivateSubClass'
//        Sub class cannot access private method or attributes from superclass
//        this.addPrivate(0);
        return 0;
    }

    /**
     *
     */
    @Override
    public int addPublic(int a) {
        return super.addPublic(a);
    }

    /**
     * We cannot override private method in superclass also
     */
//    @Override
    public int addPrivate(int a) {
        return super.addPublic(a);
    }
}
