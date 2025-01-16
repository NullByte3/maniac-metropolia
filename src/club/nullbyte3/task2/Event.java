package club.nullbyte3.task2;

// a code that vents so it was given the name "E" + "vent"
// I'm joking, this is NOT REAL, I know what an event is.
// It's something that is fired in the damn system and listened to or subscribed to by others.

public class Event implements Comparable<Event> {
    private final EventType type;
    private final long eventTime;

    public Event(EventType type, long eventTime) {
        this.type = type;
        this.eventTime = eventTime;
    }

    public EventType getType() {
        return type;
    }

    public long getEventTime() {
        return eventTime;
    }

    @Override
    public String toString() {
        return "{eventType: " + type + ", eventTime: " + eventTime + "}";
    }

    @Override
    public int compareTo(Event other) {
        return Long.compare(this.eventTime, other.eventTime);
    }
}
