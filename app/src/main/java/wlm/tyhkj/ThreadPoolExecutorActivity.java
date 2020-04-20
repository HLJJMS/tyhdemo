package wlm.tyhkj;

import androidx.appcompat.app.AppCompatActivity;;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorActivity extends AppCompatActivity {
    private static ExecutorService pool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_pool_executor);
        Log.e("UI线程名字", Thread.currentThread().getName());
      linkedBlockingQueueThread();
    }


    //    直接提交队列：设置为SynchronousQueue队列，SynchronousQueue是一个特殊的BlockingQueue，它没有容量，没执行一个插入操作就会阻塞，需要再执行一个删除操作才会被唤醒，反之每一个删除操作也都要等待对应的插入操作。
    //    做多开两个线程杀死一个开一个
    private void synchronousQueueThread() {
        pool = new ThreadPoolExecutor(1, 2, 1000, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 3; i++) {
            pool.execute(new ThreadTask());
        }

    }

    private void arrayBlockingQueueThread() {
        pool = new ThreadPoolExecutor(1, 2, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            pool.execute(new ThreadTask());
        }

    }

    private void linkedBlockingQueueThread() {
        pool = new ThreadPoolExecutor(10, 20, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 15; i++) {
            pool.execute(new ThreadTask());
        }

    }




























    public class ThreadTask implements Runnable {


        @Override
        public void run() {
            Log.e("线程名字", Thread.currentThread().getName());
        }
    }
}
