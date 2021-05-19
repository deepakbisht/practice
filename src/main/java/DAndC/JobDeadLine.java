package DAndC;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created By Deepak Bisht on 24/04/21
 */
public class JobDeadLine {

    public static int findMaxDeadline(List<Job> arr) {
        int ans = Integer.MIN_VALUE;
        for (Job temp : arr)
            ans = Math.max(temp.deadline, ans);
        return ans;
    }

    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("J1", 77, 3),
                new Job("J2", 21, 2),
                new Job("J3", 42, 1),
                new Job("J4", 54, 3),
                new Job("J5", 15, 4),
                new Job("J6", 29, 6),
                new Job("J7", 88, 3),
                new Job("J8", 14, 5));

        Collections.sort(jobs);

        int maxDeadline = findMaxDeadline(jobs);
        DisjointSet dsu = new DisjointSet(maxDeadline);

        for (Job temp : jobs) {
            // Find the maximum available free slot for
            // this job (corresponding to its deadline)
            int availableSlot = dsu.find(temp.deadline);


            // If maximum available free slot is greater
            // than 0, then free slot available
            if (availableSlot > 0) {
                // This slot is taken by this job 'i'
                // so we need to update the greatest free
                // slot. Note that, in merge, we make
                // first parameter as parent of second
                // parameter.  So future queries for
                // availableSlot will return maximum slot
                // from set of "availableSlot - 1"
                dsu.merge(dsu.find(availableSlot - 1),
                        availableSlot);
                for (int i : dsu.parent) {
                    System.out.print(i + " ");
                }
                System.out.println(temp.id + " ");
            }
        }

    }
}

class Job implements Comparable {
    String id;
    int cost;
    int deadline;

    public Job(String id, int cost, int deadline) {
        this.id = id;
        this.cost = cost;
        this.deadline = deadline;
    }

    @Override
    public int compareTo(Object o) {
        Job job = (Job) o;
        return job.cost - this.cost;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                ", cost=" + cost +
                ", deadline=" + deadline +
                '}' + "\n";
    }
}