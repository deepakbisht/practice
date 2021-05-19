package StackAndQueue;

import java.util.Arrays;
import java.util.List;

/**
 * Created By Deepak Bisht on 30/05/20
 */
public class CircularPath {

    static class PetrolPump {
        public int petrol;
        public int distance;
        public PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    static int startingPoint(List<PetrolPump> petrolPumpList) {
        int start = 0;
        int end = 1;
        int size = petrolPumpList.size();
        int curr_petrol = petrolPumpList.get(start).petrol - petrolPumpList.get(start).distance;
        while (end != start || curr_petrol < 0) {
            while (curr_petrol < 0) {
                curr_petrol -= petrolPumpList.get(start).petrol - petrolPumpList.get(start).distance;
                ;
                start = (start + 1) % size;
                if (start == 0) {
                    return -1;
                }
            }
            curr_petrol += petrolPumpList.get(end).petrol - petrolPumpList.get(end).distance;
            end = (end + 1) % size;
        }
        return start;
    }

    public static void main(String[] args)
    {

        List<PetrolPump> arr = Arrays.asList(new PetrolPump[]{
                new PetrolPump(4, 5),
                new PetrolPump(4, 5),
                new PetrolPump(8, 9),
                new PetrolPump(6, 5),
                new PetrolPump(10, 5)
    }) ;

        int start = startingPoint(arr);

        System.out.println(start == -1 ? "No Solution" : "Start = " + start);

    }
}
