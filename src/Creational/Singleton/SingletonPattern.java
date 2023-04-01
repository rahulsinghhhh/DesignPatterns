package Creational.Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Lazy loading
 *
 * Implementation:
 * 1) Private Constructor - You can't create an instance directly
 * 2) Private Static Instance
 * 3) Factory Method for creation
 * 4) Needs to be thread safe - use synchronized block
 */
public class SingletonPattern {
    private static SingletonPattern obj;

    private SingletonPattern() {}

    public static SingletonPattern getInstance() {
        if (obj==null) {
            synchronized (SingletonPattern.class) {
                if (obj==null) {
                    obj = new SingletonPattern();
                }
            }

        }
        return obj;
    }
}

class Solution {
    public static void main(String args[]) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(newRunnable());
        }
        executorService.shutdown();
    }

    private static Runnable newRunnable() {
        return new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getId() + " Obj:"+SingletonPattern.getInstance());
            }
        };
    }
}


