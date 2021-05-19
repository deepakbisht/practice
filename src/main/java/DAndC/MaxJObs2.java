package DAndC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created By Deepak Bisht on 12/05/21
 */

class PresentationTime {

    int departure;
    int arrival;

    PresentationTime(int arrival, int departure) {
        this.departure = departure;
        this.arrival = arrival;
    }

    @Override
    public String toString() {
        return "PresentationTime{" +
                "departure=" + departure +
                ", arrival=" + arrival +
                '}';
    }
}
public class MaxJObs2 {

    static int maxEvents(List<Integer> arrival, List<Integer> duration) {
        List<Integer> departureTime = new ArrayList<>();

        for (int i = 0; i < arrival.size(); i++) {
            departureTime.add(arrival.get(i) + duration.get(i));
        }
        return 0;
    }


    static int eventsThatCanBeScheduled(List<Integer> arrival, List<Integer> duration)
    {

        List<Integer> departureTime = new ArrayList<>();

        for (int i = 0; i < arrival.size(); i++) {
            departureTime.add(arrival.get(i) + duration.get(i));
        }

        ArrayList<PresentationTime> finalPresentations = new ArrayList<>();


        PriorityQueue<PresentationTime> queueByArrrival = new PriorityQueue<>(
                (company1, company2) -> company1.departure - company2.departure);

        for (int i = 0; i < arrival.size(); i++) {
            queueByArrrival.add(new PresentationTime(arrival.get(i), departureTime.get(i)));
        }

        PresentationTime firstPresentation = queueByArrrival.poll();
        int startTime = firstPresentation.arrival;
        int endTime = firstPresentation.departure;
        finalPresentations.add(new PresentationTime(startTime, endTime));

        while (!queueByArrrival.isEmpty()) {
            PresentationTime presentationTime = queueByArrrival.poll();
            if (presentationTime.arrival >= endTime) {
                startTime = presentationTime.arrival;
                endTime = presentationTime.departure;
                finalPresentations.add(new PresentationTime(startTime, endTime));
            }
        }
       return finalPresentations.size();
    }

    public static void main(String[] args)
    {

        int s[] = { 1, 1, 1, 1, 4 };
        int f[] = { 10, 3, 6, 2, 2};


        // Function call
        System.out.println(eventsThatCanBeScheduled(Arrays.asList(1, 3, 6, 7, 10, 12), Arrays.asList(5, 3, 12, 3, 2, 2)));
    }
}
