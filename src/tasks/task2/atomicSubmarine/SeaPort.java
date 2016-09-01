package tasks.task2.atomicSubmarine;

/**
 * Created by Egor on 02.09.2016.
 */
public class SeaPort {
    @Military(country = Countries.BELARUS)
    private static AtomicSubmarine[] submarines = new AtomicSubmarine[2];

    public static void startAllSubmarines(){
        for (AtomicSubmarine submarine: submarines) {
            submarine.startAllSystems();
        }
    }

    public static void main(String[] args) {
        submarines[0] = new AtomicSubmarine("ASHO");
        submarines[1] = new AtomicSubmarine("DANISHO");
        startAllSubmarines();
    }
}
