package ex02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TextLoop implements Runnable {

  public static final int COUNT = 10;

  private final String name;

  public TextLoop(String name) {
    this.name = name;
  }

  public static void main(String args[]) {
    if (args.length < 1 || (!args[0].equals("0") && !args[0].equals("1"))) {
      System.out.println("USAGE: java TextLoop <mode>");
      System.out.println(" mode 0: without threads");
      System.out.println(" mode 1: with threads");
    } else if (args[0].equals("0")) {
      for (int i = 0; i < COUNT; i++) {
        Runnable r = new TextLoop("Thread " + i + ".");
        r.run();
      }
    } else {
      ExecutorService e = Executors.newFixedThreadPool(5);
      for (int i = 0; i < COUNT; i++) {
        Runnable r = new TextLoop("Thread " + i + ".");
        e.execute(r);
      }
      e.shutdown();
    }
  }

  @Override
  public void run() {
    for (int i = 0; i < COUNT; i++) {
      System.out.println("Loop: " + name + ", iteration: " + i);
    }
  }
}

