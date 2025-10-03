// Java Example: Observer Pattern
import java.util.*;

interface Observer {
    void update(String videoTitle);
}

class Subscriber implements Observer {
    String name;
    Subscriber(String name) { this.name = name; }
    public void update(String videoTitle) {
        System.out.println(name + " got notified: New video - " + videoTitle);
    }
}

class YouTubeChannel {
    private List<Observer> subscribers = new ArrayList<>();
    
    void subscribe(Observer o) { subscribers.add(o); }
    void unsubscribe(Observer o) { subscribers.remove(o); }
    
    void uploadVideo(String title) {
        System.out.println("Channel uploaded: " + title);
        notifySubscribers(title);
    }

    private void notifySubscribers(String title) {
        for(Observer o : subscribers) {
            o.update(title);
        }
    }
}

public class YouTubeObserverSystem {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel();
        Subscriber s1 = new Subscriber("Alice");
        Subscriber s2 = new Subscriber("Bob");
        
        channel.subscribe(s1);
        channel.subscribe(s2);
        
        channel.uploadVideo("Design Patterns Tutorial");

        channel.unsubscribe(s2);
        channel.uploadVideo("Observer Pattern Deep Dive");
    }
}
