package Collection;

import java.util.Comparator;
import java.util.LinkedList;

public class LinkListPractice {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.sort(Comparator.naturalOrder());
        linkedList.offer(4);
        System.out.println(linkedList.indexOf(4));
        System.out.println(linkedList.get(4) == 4);
    }





}
