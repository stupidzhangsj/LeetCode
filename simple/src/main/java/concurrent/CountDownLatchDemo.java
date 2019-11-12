package concurrent;

import java.util.concurrent.*;

/**
 * @author :zhangshengjun
 * @create 2019-11-01 9:11
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(21);
        //Executors
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 20, 60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(20), Executors.defaultThreadFactory());
        final long start = System.currentTimeMillis();
        System.out.println(start);
        for (int i = 1; i < 21; i++) {
            int num = i;
            threadPoolExecutor.execute(() -> {
                try {
                    Thread.sleep(4000);
                    System.out.println("Thread 【 " + num + " 】执行任务结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }
        System.out.println(System.currentTimeMillis() - start);
        latch.await();
        latch.await(15L, TimeUnit.SECONDS);
        System.out.println("主任务开始了");
        threadPoolExecutor.shutdown();
    }
}
