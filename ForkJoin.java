package Task5_4;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.RecursiveTask;


class ForkJoin extends RecursiveTask<Integer> {
    private int from, to;
    private ArrayList<Integer> array;
    static final int NUM_THREAD = 8;

    public ForkJoin(ArrayList array, int from, int to) {
        this.array = array;
        this.from = from;
        this.to = to;
    }

    @Override
    protected Integer compute() {
        int localSum = 0;
        if ((to - from) < 20) {
            for (int i = from; i < to; i++) {
                localSum += array.get(i);
            }


        } else {
            int mid = (to + from) / 2;

            ForkJoin first = new ForkJoin(array, from, mid);
            first.fork();
            ForkJoin second = new ForkJoin(array, mid, to);
            second.fork();

            localSum= first.join() + second.join();
        }
        return localSum;
    }


    public static void fillArray(ArrayList array, int elements) {
        Random random = new Random();
        for (int i = 0; i < elements; i++) {
            array.add(random.nextInt(101));
        }
    }
}
