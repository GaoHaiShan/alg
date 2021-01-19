package com.haishan.alg.thread;

/**
 * 三个线程顺序打印
 */
public class Test1 {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private final Object lock3 = new Object();

    private volatile int num = 0;

    void thread1ExecutorMethod(){
        synchronized (lock1){
            while (num < 100) {
                System.out.println(Thread.currentThread().getName()+"-->"+(num++));
                synchronized (lock2){
                    lock2.notify();
                }
                try {
                    lock1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
        synchronized (lock2){
            lock2.notifyAll();
        }
        synchronized (lock3){
            lock3.notifyAll();
        }
    }

    void thread2ExecutorMethod(){
        synchronized (lock2){
            while (num < 100){
                System.out.println(Thread.currentThread().getName()+"-->"+(num++));
                synchronized (lock3){
                    lock3.notify();
                }
                try {
                    lock2.wait();
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
        synchronized (lock1){
            lock1.notifyAll();
        }
        synchronized (lock3){
            lock3.notifyAll();
        }
    }

    void thread3ExecutorMethod(){
        synchronized (lock3){
            while (num < 100){
                System.out.println(Thread.currentThread().getName()+"-->"+(num++));
                synchronized (lock1){
                    lock1.notify();
                }
                try {

                    lock3.wait();
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
        synchronized (lock1){
            lock1.notifyAll();
        }
        synchronized (lock2){
            lock2.notifyAll();
        }
    }

    public static void main(String[] args) {

        Test1 test1 = new Test1();

        Thread t1 = new Thread(()->{
            test1.thread1ExecutorMethod();
        },"t1");

        Thread t2 = new Thread(()->{
            test1.thread2ExecutorMethod();
        },"t2");

        Thread t3 = new Thread(()->{
            test1.thread3ExecutorMethod();
        },"t3");

        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();
    }
}
