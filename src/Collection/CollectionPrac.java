package Collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionPrac {

    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        Collection<Integer> collection1 = new ArrayList<>(collection);//addAll
        System.out.println(collection);
        System.out.println(collection1);
        System.out.println(collection.containsAll(collection1));

    }
}
