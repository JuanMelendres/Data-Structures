/**
 * This class is responsible for initiating, selecting the algorithm
 * and doing the step work for the simulation
 */
public class Simulation {

    private static Algorithm algorithm; // object used for polymorphism
    public static int time;   // current time of the simulation
    public static String algorithmType = "FCFS";  // default algroithm type
    public static int quantum = 2;  // quantum time for round robin algorithm
    public static boolean finished = false; // show that the simulation is finished
    public static boolean stoped = true;  // show that the simulation is stoped

    /**
     * reset the simulation
     */
    public static void reset(){
       time = 0;  // reset the simulation time
       finished = false;  // simulation is not finished
    }

    /**
     * @return the current ready queue of the working algorithm
     */
    public static Queue getReadyQueue(){
        return algorithm.getReadyQueue();
    }

    /**
     * let the selected algorithm finish a step
     * @return the current job worked by the algorithm
     */
    public static Job workStep(){
        Job job;
        if(time == 0){
            selectAlgorithm();
        }  // select and init the algorithm
        job = algorithm.nextStep(time);
        if(algorithm.isFinished()){
            finished = true;
        }
        return job;
    }

    /**
     * select and initiate the selected algorithm
     */
    private static void selectAlgorithm(){
        if(algorithmType.equals("FCFS")){  // first come first served
            algorithm = new FCFS(MainQueue.get());
        }
        else{ // shortest job first
            algorithm = new SJF(MainQueue.get());
        }
    }

}
