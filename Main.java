package Task5_4;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

import static Task5_4.ForkJoin.NUM_THREAD;
import static Task5_4.ForkJoin.fillArray;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        fillArray(arrayList,1_000);

        ForkJoinPool pool = new ForkJoinPool(NUM_THREAD);
        Integer sum = pool.invoke(new ForkJoin(arrayList,0, 42));
        System.out.println(sum + "result");
    }
}
