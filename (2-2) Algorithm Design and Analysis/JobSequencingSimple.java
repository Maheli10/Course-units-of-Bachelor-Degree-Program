import java.util.*;

class Job {
    String id;
    int deadline, profit;

    Job(String id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencingSimple {

    public static void scheduleJobs(ArrayList<Job> jobs) {

        // Step 1: Sort by profit (descending)
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        // Step 2: Find max deadline
        int maxD = 0;
        for (Job j : jobs) {
            if (j.deadline > maxD)
                maxD = j.deadline;
        }

        // Step 3: Create slot array
        String[] result = new String[maxD];
        boolean[] filled = new boolean[maxD];

        int totalProfit = 0;

        // Step 4: Assign jobs
        for (Job j : jobs) {
            for (int k = j.deadline - 1; k >= 0; k--) {
                if (!filled[k]) {
                    result[k] = j.id;
                    filled[k] = true;
                    totalProfit += j.profit;
                    break;
                }
            }
        }

        // Step 5: Print result
        System.out.println("Job Sequence:");
        for (String job : result) {
            if (job != null)
                System.out.print(job + " ");
        }

        System.out.println("\nTotal Profit: " + totalProfit);
    }

    public static void main(String[] args) {

        ArrayList<Job> jobs = new ArrayList<>();

        jobs.add(new Job("J1", 5, 200));
        jobs.add(new Job("J2", 3, 180));
        jobs.add(new Job("J3", 3, 190));
        jobs.add(new Job("J4", 2, 300));
        jobs.add(new Job("J5", 4, 120));
        jobs.add(new Job("J6", 2, 100));

        scheduleJobs(jobs);
    }
}