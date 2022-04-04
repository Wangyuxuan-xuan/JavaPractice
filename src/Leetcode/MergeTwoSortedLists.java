package Leetcode;


public class MergeTwoSortedLists {

    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();

        ListNode listNode = new ListNode(0);
        for (int i = 1; i < 5; i++) {
            listNode = new ListNode(i , listNode);
        }
        System.out.println(listNode);
//        mergeTwoSortedLists.mergeTwoLists([1 2 3] , [123])

        ListNode listNode1 = new ListNode(100);
        listNode1 = listNode;
        System.out.println(listNode1);
        listNode1 = listNode1.next;
        System.out.println(listNode1);
        System.out.println(listNode);
//        while (true){
//            if (listNode.next == null){
//                System.out.println(listNode.val);
//                break;
//            }
//
//
//            if (listNode.val == 2){
//                listNode = new ListNode(2,listNode);
//            }
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }


    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode list = new ListNode();

        while (true){
            if (list2.next == null){
                break;
            }
            int list2Current = list2.val;
            while (true){
                if (list1.next == null){
                    break;
                }
                int list1Current = list1.val;



                list1 = list1.next;
            }


            list2 = list2.next;
        }

        return list;
    }
}
