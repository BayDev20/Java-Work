public class App {

    public static void main(String[] args) {
        CountingThread upCount = new CountingThread("Count Up Thread", true);
        CountingThread downCount = new CountingThread("Count Down Thread", false);

        upCount.start();
        downCount.start();
    }

    static class CountingThread extends Thread {
        private final boolean isUpCount;

        public CountingThread(String name, boolean isUpCount) {
            super(name);
            this.isUpCount = isUpCount;
        }

        @Override
        public void run() {
            if (isUpCount) {
                for (int i = 1; i <= 20; i++) { // loops through up count
                    System.out.println(getName() + ": " + i);
                    try {
                        Thread.sleep(1000); // Sleep in ATTEMPT to maintain concurrency
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                for (int i = 20; i >= 0; i--) { // Loops through down count
                    System.out.println(getName() + ": " + i);
                    try {
                        Thread.sleep(1000); // Sleep in ATTEMPT to maintain concurrency
                    } catch (InterruptedException e) { // 
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}