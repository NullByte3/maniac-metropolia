package club.nullbyte3.task2;

import java.util.List;
import java.util.PriorityQueue;

public class EventList {
    private final PriorityQueue<Event> eventQueue;

    public EventList() {
        eventQueue = new PriorityQueue<>();
    }

    public List<Event> getEventQueue() {
        return List.copyOf(eventQueue);
    }

    public void addEvent(Event event) {
        eventQueue.add(event);
    }

    public Event getNextEvent() {
        return eventQueue.poll();
    }

    public void printAllEventsInOrder() {
        while (!eventQueue.isEmpty()) {
            System.out.println(eventQueue.poll());
        }
    }
}
