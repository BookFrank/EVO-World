package com.tazine.evo.concurrent.pool.priority;

import java.util.concurrent.TimeUnit;

/**
 * MyPriorityTask
 *
 * @author jiaer.ly
 * @date 2020/03/26
 */
public class MyPriorityTask implements Runnable, Comparable<MyPriorityTask> {

    private String name;

    private int prority;

    public MyPriorityTask(String name, int prority) {
        this.name = name;
        this.prority = prority;
    }

    @Override
    public int compareTo(MyPriorityTask o) {
        if (this.getPrority() < o.getPrority()) {
            return 1;
        } else if (this.getPrority() > o.getPrority()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public void run() {
        System.out.println(name + " priority=" + prority);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrority() {
        return prority;
    }

    public void setPrority(int prority) {
        this.prority = prority;
    }
}
