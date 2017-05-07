package com.omisoft.basic_java.Threads.task4;


public class Test {

    public static void main(String[] args) {
	Thread t1 = new Thread(new ThreadNew(0,5,"Thread1"));
	Thread t2 = new Thread(new ThreadNew(0,5,"Thread2"));
	t1.start();
	t2.start();

    }

}
