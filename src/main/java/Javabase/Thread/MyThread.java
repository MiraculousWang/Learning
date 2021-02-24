package Javabase.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/*
 *
 * https://thinkwon.blog.csdn.net/article/details/104863992
 */


public class MyThread extends Thread {

  @Override
  public void run(){
    System.out.println("my thread [ " + Thread.currentThread().getId() + " ] run");
  }

  public static void main(String[] args){
    System.out.println("main Thread start");
    new MyThread().start();
    System.out.println("main Thread end 1");
    new Thread(new MyRunable()).start();
    System.out.println("main Thread end 2");
    FutureTask<Integer> myFutureTask = new FutureTask<Integer>(new MyCellable());
    new Thread(myFutureTask).start();
//      myFutureTask.get() == 1;
    System.out.println("main Thread end 3");

    ExecutorService executorService = Executors.newSingleThreadExecutor();
    for (int i=0; i < 5;i++){
      executorService.execute(new Runnable() {
        @Override
        public void run() {
          System.out.println(Thread.currentThread().getName() + " running ");
        }
      });
    }


  }

}

class MyRunable implements Runnable{

  @Override
  public void run() {
    System.out.println("My Runable { " + Thread.currentThread().getId() + " } run");

  }
}

class MyCellable implements Callable<Integer>{

  @Override
  public Integer call() throws Exception {
    System.out.println("My Cellable { " + Thread.currentThread().getId() + " } run");
    return 1;
  }
}