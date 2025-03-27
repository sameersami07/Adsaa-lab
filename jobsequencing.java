import java.util.*;
class Job{
    int id,deadline,profit;
    public Job(int id,int deadline,int profit){
        this.id=id;
        this.deadline=deadline;
        this.profit=profit;
    }
}
public class jobsequencing{
    public static void jobscheduling(Job[] jobs){
        Arrays.sort(jobs,(a,b)-> b.profit-a.profit);
        int n=jobs.length;
        boolean[] slot=new boolean[n];
        int totalprofit=0;
        List<Integer> scheduledjob=new LinkedList<>();
        for(Job job:jobs){
            for(int i=Math.min(n,job.deadline)-1;i>=0;i--){
                if(!slot[i]){
                    slot[i]=true;
                    scheduledjob.add(job.id);
                    totalprofit+=job.profit;
                    break;
                }
            }
        }
        System.out.println("scheduledjob:"+scheduledjob);
        System.out.println("totalprofit:"+totalprofit);
    }
    public static void main(String[] args){
        Job[] jobs={
            new Job(1,2,100),
            new Job(2,1,50),
            new Job(3,2,150),
            new Job(4,1,50),
            new Job(5,3,100)
        };
        jobscheduling(jobs);
    }
}
