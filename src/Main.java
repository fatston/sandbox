import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello world!");
        List<Integer> integers = new ArrayList<>();
        integers.add(5);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(1);

        // alternate between peaks and valleys
        // peak - number that is higher than 2 adjacent numbers
        // valley - number that is lower than 2 adjacent numbers

        // arrange such that it's alternate between peaks and valleys

        // {3,1,4,2,5}

        // {1,5,2,4,3}

        /*System.out.println(randomIntegers);

        Collections.sort(randomIntegers);

        System.out.println(randomIntegers);

        List<Integer> response = new ArrayList<>();
        while (!randomIntegers.isEmpty()) {
            // get last item
            int lastIndex = randomIntegers.size()-1;
            response.add(randomIntegers.get(lastIndex));
            randomIntegers.remove(lastIndex);

            if (randomIntegers.isEmpty()) {
                break;
            }
            // get first item
            response.add(randomIntegers.get(0));
            randomIntegers.remove(0);

        }

        System.out.println("response: " + response);*/

        System.out.println("before: " + integers);
        michelle(integers);
        System.out.println("after:" + integers);


        List<Integer> integers1 = new ArrayList<>();
        integers1.add(1);
        integers1.add(2);
        integers1.add(3);
        integers1.add(4);
        integers1.add(5);
        System.out.println("before: " + integers1);
        michelle(integers1);
        System.out.println("after:" + integers1);

        List<Integer> integers2 = new ArrayList<>();
        integers2.add(1);
        integers2.add(2);
        integers2.add(3);
        integers2.add(4);
        integers2.add(5);
        System.out.println("before: " + integers2);
        michelle(integers2);
        System.out.println("after:" + integers2);


    }


    public static void michelle(List<Integer> integers) {

        // {5,2,3,4,1}



        // case 1: left small right big OR left big right small - swap with next one


        for (int i = 0; i < integers.size(); i++) {
            // edge case: either end: do nothing
            if (i == 0 || i == integers.size()-1) {
                continue; // todo change this probably for the last item
            }
            int left = integers.get(i-1);
            int mid = integers.get(i);
            int right = integers.get(i+1);

            // case: already peak
            if (left < mid && right < mid) {
                continue;
            }
            // case: already trough
            if (left > mid && right > mid) {
                continue;
            }

            // case 1: left small right big OR left big right small - swap with next one
            swap(integers, i);

        }




    }

    public static void swap(List<Integer> integers, int indexToSwap) {
        // assert that this is not the last item in the list
        assert(indexToSwap < integers.size());
        int first = integers.get(indexToSwap);
        integers.set(indexToSwap, integers.get(indexToSwap+1));
        integers.set(indexToSwap+1, first);
    }
}