package concurrency;

class SynchronizationExample{
    private static final Object obj = new Object();

    public static void main(String[] ar){

        new Thread(new Runnable() {
            @Override
            public void run() {
                SynchronizationExample sy1 = new SynchronizationExample();
                sy1.hello();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                SynchronizationExample sy2 = new SynchronizationExample();
                sy2.hello();
            }
        }).start();

    }

    private void hello(){
        synchronized (obj) {
            System.out.println("Thread :"+Thread.currentThread().getName() + " Inside");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread :"+Thread.currentThread().getName() + " Leaving");
        }
    }
}
