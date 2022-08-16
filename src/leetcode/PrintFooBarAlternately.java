package leetcode;

import java.util.concurrent.atomic.AtomicBoolean;

public class PrintFooBarAlternately {
	private int n;
    AtomicBoolean hasDoneFirst = new AtomicBoolean(false);

    public PrintFooBarAlternately(int n) {
        this.n = n;
    }
    
    public void foo(Runnable printFoo) throws InterruptedException {

        synchronized(this) {
            for (int i = 0; i < n; i++) {
                while (hasDoneFirst.get()) {
                    wait();
                }
                printFoo.run();
                hasDoneFirst.set(true);
                notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        synchronized(this) {
            for (int i = 0; i < n; i++) {
                while(!hasDoneFirst.get()) {
                    wait();
                }
                printBar.run();
                hasDoneFirst.set(false);
                notify();
            }
        }
    }
}
