package com.learn.base.worker;

import java.util.concurrent.Executors;

public class ExecutorService {
    private static final int NUMBER_OF_THREADS = 2;
    private static final java.util.concurrent.ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static void run(Runnable runnable) {
        if (runnable != null) {
            databaseWriteExecutor.execute(runnable);
        }
    }
}
