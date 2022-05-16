package com.company;

public class Task1 implements Runnable{
    Thread thread;

    Task1(String name){
        thread = new Thread(this, name);
    }

    public static Task1 createAndStart(String Name){
        Task1 myThread = new Task1(Name);
        myThread.thread.start();
        return myThread;
    }

    public void run(){
        System.out.println(thread.getName() + "starts to operate");
        try{
            for(int count = 0; count <10; count++){
                Thread.sleep(100);
                System.out.println(thread.getName() + "is executed, the counter value: " + count);
            }
        }catch (InterruptedException e){
            System.out.println(thread.getName() + "has been interrupted");
        }
        System.out.println(thread.getName() + "finishes running");
    }
}

class MoreThreads {
    public static void main(String[] args)  {
        System.out.println("The main thread starts running.");
        Task1 myThread1 = Task1.createAndStart("Child thread #1");
        Task1 myThread2 = Task1.createAndStart("Child thread #2");
        Task1 myThread3 = Task1.createAndStart("Child thread #3");

        try{
            myThread1.thread.join();
            myThread2.thread.join();
            myThread3.thread.join();
        } catch(InterruptedException e) {
            System.out.println(" The main thread has been  terminated");
        }


        System.out.println("The main thread is exiting");
    }
}
