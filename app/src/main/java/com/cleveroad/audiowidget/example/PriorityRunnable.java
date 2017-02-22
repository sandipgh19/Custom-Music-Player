package com.cleveroad.audiowidget.example;

import android.os.Process;

/**
 * Created by sandip on 2/22/2017.
 */

abstract class PriorityRunnable implements Runnable {
    private int threadPriority;

    public PriorityRunnable() {
        threadPriority = Process.THREAD_PRIORITY_BACKGROUND;
    }

    public PriorityRunnable(@ProcessPriority int threadPriority) {
        this.threadPriority = threadPriority;
    }

    @Override
    public void run() {
        Process.setThreadPriority(threadPriority);
        runImpl();
    }

    protected abstract void runImpl();
}