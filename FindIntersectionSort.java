import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class FindIntersectionSort {

    public static boolean binarySearch(int n, List<Integer> l){
        if (l.size() == 1){
            if (l.get(0) == n)
                return true;
            else
                return false;
        }
        int beg = 0;
        int end = l.size()-1;
        int mid = l.size()/2;
        int counter =0, swap =0;
        boolean found = false;
        while (beg < end){

            if(n == l.get(mid))
                return true;
            else if (l.get(mid) < n){
                beg = mid + 1;
            } else if (l.get(mid) > n){
                end = mid - 1;
            }
            mid = (beg + end)/2;
        }
        return false;
    }


    public static void main(String[] args) {
        // generating lists
        Random rand = new Random();
        int aSize = rand.nextInt(50);
        int bSize = rand.nextInt(50);
        if(aSize== 0|| bSize ==0) {
            System.out.println("no intersection, list is empty");
            return;
        }

        List<Integer> shorter = new ArrayList<>();
        List<Integer> longer = new ArrayList<>();
        List<Integer> intersection = new ArrayList<>();

        // filling lists with random numbers and determining which is shorter
        if (aSize <= bSize){
            for (int n =0; n< aSize; n++){
                shorter.add(rand.nextInt(50));
            }
            for (int n =0; n< bSize; n++){
                longer.add(rand.nextInt(50));
            }
        }else {
            for (int n =0; n< aSize; n++){
                longer.add(rand.nextInt(100));
            }
            for (int n =0; n< bSize; n++){
                shorter.add(rand.nextInt(100));
            }
        }


        // algorithm
        System.out.println("sizes: "+shorter.size()+ " " +longer.size());
        shorter.sort(Comparator.naturalOrder());
        
        System.out.println("shorter");
        shorter.forEach(integer -> System.out.print(integer+" "));
        
        System.out.println("\nlonger");
        longer.forEach(integer -> System.out.print(integer+" "));
        
        System.out.println("\nintersection");
        longer.forEach(integer -> {
            if (binarySearch(integer,shorter))
                intersection.add(integer);
        });


        intersection.forEach(integer -> System.out.print(integer+" "));





    }
}
