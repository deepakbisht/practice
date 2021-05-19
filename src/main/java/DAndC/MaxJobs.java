package DAndC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created By Deepak Bisht on 12/05/21
 */

class Activity
{
    int start, finish;

    // Constructor
    public Activity(int start, int finish)
    {
        this.start = start;
        this.finish = finish;
    }
}

// class to define user defined comparator
class Compare
{

    // A utility function that is used for sorting
    // activities according to finish time
    static void compare(Activity arr[], int n)
    {
        Arrays.sort(arr, new Comparator<Activity>()
        {
            @Override
            public int compare(Activity s1, Activity s2)
            {
                return s1.finish - s2.finish;
            }
        });
    }
}

public class MaxJobs {


    public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
        // Write your code here


        List<Integer> departureTime = new ArrayList<>();

        for (int i = 0; i < arrival.size(); i++) {
            departureTime.add(arrival.get(i) + duration.get(i));
        }

        int i=0;
        int count  = 1;
        for (int j = 1; j < arrival.size(); j++)
        {
            if (arrival.get(j) >= departureTime.get(i))
            {
                count++;
                i = j;
            }
        }
        return count;
    }

    static int find_maximum_jobs(List<Integer> arrival, List<Integer> duration)
    {
        List<Integer> departureTime = new ArrayList<>();
        List<ArrayList<Integer>> startEndTime = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < arrival.size(); i++) {
            departureTime.add(arrival.get(i) + duration.get(i));
           ArrayList<Integer> arrayList = new ArrayList<Integer>();
           arrayList.add(arrival.get(i));
           arrayList.add(arrival.get(i)+duration.get(i));
           startEndTime.add(arrayList);
        }

        ArrayList<Integer> queue = new ArrayList<Integer>();
        // Sort ranges by start day
        Collections.sort(startEndTime, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });

        // Stores the minimum and maximum
        // day in the ranges
        int min_day = startEndTime.get(0).get(0);
        int max_day = 0;
        for (int i = 0; i < 5; i++)
            max_day = Math.max(max_day, startEndTime.get(i).get(1));
        int index = 0, count_jobs = 0;

        // Iterating from min_day to max_day
        for (int i = min_day; i <= max_day; i++)
        {
            // Insert the end day of the jobs
            // which can be completed on
            // i-th day in a priority queue
            while (index < startEndTime.size() && startEndTime.get(index).get(0) <= i)
            {
                queue.add(startEndTime.get(index).get(1));
                index++;
            }
            Collections.sort(queue);

            // Pop all jobs whose end day
            // is less than current day
            while (queue.size() > 0 && queue.get(0) < i)
                queue.remove(0);

            // If queue is empty, no job
            // can be completed on
            // the i-th day
            if (queue.size() == 0)
                continue;
            // Increment the count of
            // jobs completed
            count_jobs++;

            // Pop the job with
            // least end day
            queue.remove(0);
        }
        // Return the jobs
        // on the last day
        return count_jobs;

    }

    public static void main(String[] args) {
        List<Integer> start = Arrays.asList(1,3,3,5,7);
        List<Integer> stay = Arrays.asList(2,2,1,2,1);

      System.out.println(maxEvents(start, stay));

   //     System.out.println(find_maximum_jobs(start, stay));

    }
}
