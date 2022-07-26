
public class GuideToTheGalaxyMain {

        public static void main(String args[]) throws InterruptedException {
            Thread thread = new Thread((Runnable) new SimpleGUI());
            thread.start();
            synchronized (thread) {
                thread.wait();
            }
        }


}


