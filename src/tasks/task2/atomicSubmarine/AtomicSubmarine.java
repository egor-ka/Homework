package tasks.task2.atomicSubmarine;

/**
 * Created by Egor on 02.09.2016.
 */
public class AtomicSubmarine {

    private class AtomicSubmarineEngine {
        private static final int POWER = 9000;
        private static final int TANK_SIZE_TONS = 50;

        private boolean working = false;

        public void startEngine(){
            if (!working) {
                working = true;

            } else {
                System.out.println("Engine is already working");
            }
        }

        public void stopEngine(){
            if (working) {
                working = false;
            } else {
                System.out.println("Engine is already stopped");
            }
        }

        public boolean isWorking(){
            return working;
        }

    }

    private String name;
    private AtomicSubmarineEngine firstEngine = new AtomicSubmarineEngine();
    private AtomicSubmarineEngine secondEngine = new AtomicSubmarineEngine();

    public AtomicSubmarine(String name) {
        this.name = name;
    }

    public void startAllSystems(){
        firstEngine.startEngine();
        secondEngine.startEngine();
        System.out.println("Submarine " + name + ": All systems are working");
    }

    public String getSystemsState(){
        return "firstEngine working:" + firstEngine.isWorking() + "\nsecondEngine working:" + secondEngine.isWorking();
    }
}
