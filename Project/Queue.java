import java.util.ArrayList;

/**
 * Queue is an array list of jobs, used to provide some helpful methods
 * to make using list of jobs much easier.
 */
public class Queue{

    private ArrayList<Job> mainList;  // Queue is a list of jobs
    private int number; // max number of jobs in the queue

    /**
     * create an empty queue with size for a specific number of jobs
     * @param number number of jobs
     */
    public Queue(int number){
        this.mainList = new ArrayList<Job>(number);
        this.number = number;
    }

    /**
     * create a queue and fill it with a given list of jobs
     * @param list list of jobs for the queue
     */
    public Queue(ArrayList<Job> list){
        this.mainList = new ArrayList<Job>(list.size());
        this.mainList.addAll(list);
    }

    /**
     * fill the queue with jobs with random data
     * @param number number of jobs in the queue
     */
    public void fill(){
        for(int i=0; i < this.number; i++){
            Job temp = new Job(i+1); // job number starts from 1 not 0
            this.mainList.add(i, temp);
        }
    }

    /**
     * @param num number of the job in the queue
     * @return selected job
     */
    public Job getJob(int num){
        return this.mainList.get(num);
    }

    /**
     * remove selected job from the queue
     * @param num number of the selected job to be removed
     */
    public void removeJob(int num){
        this.mainList.remove(num);
    }

    /**
     * add job to the end of the queue
     * @param job job to be added
     */
    public void addJob(Job job){
        this.mainList.add(job);
    }

    /**
     * replace the job at a specific place of the queue
     * @param i place of job to be replaced
     * @param job new job to replace with
     */
    public void set(int i , Job job){
        this.mainList.set(i, job);
    }

    /**
     * check if the queue is empty
     * @return true if empty
     */
    public boolean isEmpty(){
        return (this.mainList.isEmpty());
    }

    /**
     * @return the size of the queue
     */
    public int size(){
        return this.mainList.size();
    }

    /**
     * remove all the elements of the queue
     */
    public void clearQueue(){
        for(int i =0; i < this.mainList.size(); i++){
           mainList.remove(i);
        }
    }

    /**
     * order the jobs inside the queue by arrive time
     */
    public void OrderedByArrive(){
        for(int i=0; i < this.mainList.size()-1; i++){
            for(int j=i+1; j < this.mainList.size(); j++){
                Job j1 = this.mainList.get(i);
                Job j2 = this.mainList.get(j);
                if(j2.isFirst(j1)){
                    this.mainList.set(i, j2);
                    this.mainList.set(j, j1);
                }
            }
        }
    }

    /**
     *  order the jobs inside the queue by shortest burst
     */
    public void OrderedByShortest(){
        for(int i=0; i < this.mainList.size()-1; i++){
            for(int j=i+1; j < this.mainList.size(); j++){
                Job j1 = this.mainList.get(i);
                Job j2 = this.mainList.get(j);
                if(j2.isShort(j1)){
                    this.mainList.set(i, j2);
                    this.mainList.set(j, j1);
                }
            }
        }
    }

    /**
     * order the jobs inside the queue by priority
     */
    public void OrderedByPriority(){
        for(int i=0; i < this.mainList.size()-1; i++){
            for(int j=i+1; j < this.mainList.size();j++){
                Job j1 = this.mainList.get(i);
                Job j2 = this.mainList.get(j);
                if(j2.isPrior(j1)){
                    this.mainList.set(i, j2);
                    this.mainList.set(j, j1);
                }
            }
        }
    }

    /**
     * order the jobs inside the queue by the shortest remaining time
     */
    public void OrderedByShortRemain(){
        for(int i=0; i < this.mainList.size()-1; i++){
            for(int j=i+1; j < this.mainList.size(); j++){
                Job j1 = this.mainList.get(i);
                Job j2 = this.mainList.get(j);
                if(j2.isShortRemain(j1)){
                    this.mainList.set(i, j2);
                    this.mainList.set(j, j1);
                }
            }
        }
    }

    /**
     * create a copy of a queue with all jobs data
     * @param list queue to be copied
     * @return complete separated copy of the queue
     */
    public Queue getCopy (){
        return new Queue(this.mainList);
    }

    /**
     * create a copy of a queue with only the start data of every job.
     * note: this is used for restarting the same simulation by taking
     * a copy of the start data of the queue to use it in another simulation.
     * @param list queue to be copied
     * @return clear copy of the queue
     */
    public Queue getClearCopy(){
        ArrayList<Job> list = new ArrayList<Job>(this.mainList.size());
        for(int i=0; i < this.mainList.size(); i++){
            Job temp = this.mainList.get(i).getClearCopyJob();  // copy only start data of the job
            list.add(temp);
        }
        return new Queue(list);
    }

    /**
     * Show queue content (every job details)
     * improved version of toString method but used for testing.
     * @param list Queue to show it's content
     */
    public void showQueue(int simulationTime){
        if(this.mainList.isEmpty()){
            System.out.println("Empty Queue");
            return;
        } // if queue is empty
        System.out.println("number of jobs " + this.mainList.size());
        System.out.println("# "+" Arrive "+" Burst "+" Priority "+" Start "+" Wait "+" Remain "+" Finish "+" Turn "+" % ");
        for(int i=0; i < this.mainList.size(); i++){ // show every job data
            Job temp = this.mainList.get(i);
            System.out.print(temp.jobNumber + "    " + temp.arrivalTime + "    " + temp.burst +"     ");
            System.out.print(temp.priority + "    " + temp.getStart() + "    " + temp.getWaitTime(simulationTime)+ "    ");
            System.out.print(temp.getRemainTime() + "     " + temp.getFinish() + "    " + temp.getTurnaround(simulationTime)+ "   ");
            System.out.println(temp.getPercent());
        }
    }

}
