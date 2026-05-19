package concurrency;

public class MainConcurrency {
    public static void main(String[] args) {
        System.out.println("I am Main thread - starting");
        Thread t1 = new Thread(() ->{
            for(int i=0;i<5;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + i);
            }
        });
        t1.setDaemon(true);
        t1.start();
        System.out.println("I am Main thread - ending");
    }
}
