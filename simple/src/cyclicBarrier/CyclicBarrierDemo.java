package cyclicBarrier;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @author :zhangshengjun
 * @create 2019-10-29 15:54
 **/
public class CyclicBarrierDemo {
    // 请求的数量
    private static final int threadCount = 550;
    // 需要同步的线程数量
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 1; i < threadCount; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
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
            /**等待60秒，保证子线程完全执行结束*/
            cyclicBarrier.await(5, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("-----CyclicBarrierException------");
        }
        System.out.println("threadnum: 【" + threadnum + "】 is finish" + new Date());
    }

}
