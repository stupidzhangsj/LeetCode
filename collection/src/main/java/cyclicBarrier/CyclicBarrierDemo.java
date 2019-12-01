package cyclicBarrier;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @author :zhangshengjun
 * @create 2019-10-29 15:54
 **/
public class CyclicBarrierDemo {
    // 请求的数量
    private static final int threadCount = 3;
    private volatile static int num = 0;
    private static Semaphore semaphore = new Semaphore(1);
    // 需要同步的线程数量
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 1; i < threadCount; i++) {
            final int threadNum = i;
            if (i > 3 && i % 3 == 1) {
                Thread.sleep(5000);
            }
            threadPool.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException | BrokenBarrierException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
    }

    public static void test(int threadnum) throws InterruptedException, BrokenBarrierException {
        System.out.println("threadnum: 【" + threadnum + "】 is ready");
        try {
            if(threadnum % 2 == 0) {
                Thread.sleep(25000);
            }
            num = cyclicBarrier.await();
            System.out.println("threadnum: 【" + threadnum + "】acquire 后剩余数量: " + num);
            System.out.println("-----------threadnum: 【" + threadnum + "】 is finish---------, cur :" + num);
        } catch (Exception e) {
            System.out.println("-----CyclicBarrierException------");
        }
    }
}
