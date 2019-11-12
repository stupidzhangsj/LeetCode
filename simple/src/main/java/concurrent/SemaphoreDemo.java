package concurrent;

import java.util.concurrent.*;

/**
 * Semaphore demo
 *
 * @author :zhangshengjun
 * @create 2019-10-31 10:37
 **/
public class SemaphoreDemo {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(10);
        CountDownLatch latch = new CountDownLatch(20);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 20, 60L, TimeUnit.SECONDS,
                new SynchronousQueue<>(), Executors.defaultThreadFactory());

        for (int i = 1; i < 25; i++) {
            int num = i;
            threadPoolExecutor.execute(() -> {
                boolean result = false;
                try {
                    System.out.println("thread---" + num );
                    result = semaphore.tryAcquire(2, 2L, TimeUnit.SECONDS);
                    if (result) {
                        System.out.println("thread-" + num + "-请求数量 -2");
                        System.out.println("thread-" + num + "-请求后剩余数量--" + semaphore.availablePermits());
                    }
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (result) {
                        semaphore.release(1);
                        System.out.println("thread-" + num + "-释放数量 +1");
                        System.out.println("thread-" + num + "-释放后剩余数量--" + semaphore.availablePermits());
                    }
                    latch.countDown();
                }
            });
        }
        latch.await();
        threadPoolExecutor.shutdown();
    }
}
