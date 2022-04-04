package Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ArrayListPrac{

    public static void main(String[] args) {
        normalSort();
        customSort();
    }


    /**
     * For normal arrayList , to perform sort
     * call sort function and pass Comparator.naturalOrder() or Comparator.reverseOrder()
     * To perform custom sort , call new Comparator<Integer>() and implement it .
     * Note that when calling abs() , should use Math.abs()
     */
    static void normalSort(){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(10);
        arrayList.add(-12);
        System.out.println(arrayList);

        arrayList.sort(Comparator.naturalOrder());
        arrayList.sort(Comparator.reverseOrder());
        Collections.sort(arrayList);
        Collections.sort(arrayList,Comparator.reverseOrder());

        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1) - Math.abs(o2);
            }
        });
        System.out.println(arrayList);


    }

    /**
     * For arrayList with custom elements , to perform sort ,
     * the custom class must implement Comparable Interface
     * and override compareTo method
     * return positive number if current object is bigger than param object.
     */
    static void customSort(){
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student(19,90,"John"));
        studentArrayList.add(new Student(30,95,"Eric"));
        studentArrayList.add(new Student(-12,10,"Amy"));
        studentArrayList.add(new Student(15,100,"Anda"));
        Collections.sort(studentArrayList);
        System.out.println(studentArrayList);
    }
}
