package club.nullbyte3.task2;

import java.util.List;
import java.util.Random;

public class SimulationTask {
    private static final Random rand = new Random();
    public static void main(String[] args) {
        EventList eventList = new EventList();
        for (int i = 0; i < 1000; i++) {
            eventList.addEvent(new Event(EventType.values()[rand.nextInt(EventType.values().length)], System.currentTimeMillis()));
        }
        eventList.printAllEventsInOrder();
    }

}
