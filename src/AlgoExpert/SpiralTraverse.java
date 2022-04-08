package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralTraverse {

    public static void main(String[] args) {
        int[][] twoDArray = new int[][]{{1,2,3},{8,9,4},{7,6,5}};

        List<Integer> list = spiralTraverse(twoDArray);

        System.out.println(list.toString());
    }

    public static List<Integer> spiralTraverse(int[][] array) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        int rowPointer = 0 , columnPointer = 0;
        int arrayTop = 0 , arrayBottom = array.length - 1 ,arrayLeft = 0 , arrayRight = Integer.MAX_VALUE;
        String direction = "right";

        for (int[] ints : array) {
            arrayRight = Math.min(arrayRight, ints.length -1);
        }
        for (int i = 0; i < array.length * array.length; i++) {
            while (direction.equals("right") && columnPointer <= arrayRight){
                arrayList.add(array[rowPointer][columnPointer]);
                if (columnPointer == arrayRight){
                    direction = "down";
                    arrayTop += 1;
                    rowPointer = arrayTop;
                    break;
                }
                columnPointer ++ ;
            }

            while (direction.equals("down") && rowPointer <= arrayBottom){
                arrayList.add(array[rowPointer][columnPointer]);

                if (rowPointer == arrayBottom){
                    direction = "left";
                    arrayRight -= 1;
                    columnPointer = arrayRight;
                    break;
                }
                rowPointer ++ ;
            }

            while (direction.equals("left") && columnPointer >= arrayLeft){
                arrayList.add(array[rowPointer][columnPointer]);

                if (columnPointer == arrayLeft){
                    direction = "up";
                    arrayBottom -= 1;
                    rowPointer = arrayBottom;
                    break;
                }
                columnPointer--;
            }

            while (direction.equals("up") && rowPointer >= arrayTop){
                arrayList.add(array[rowPointer][columnPointer]);

                if (rowPointer == arrayTop){
                    direction = "right";
                    arrayLeft += 1;
                    columnPointer = arrayLeft;
                    break;
                }
                rowPointer--;
            }
        }
        return arrayList;
    }
}
