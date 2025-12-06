package observer;

import java.util.ArrayList;
import java.util.List;

public class K2559495_NotificationService {
    
    private List<K2559495_Observer> observers = new ArrayList<>();

    public void addObserver(K2559495_Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(K2559495_Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (K2559495_Observer observer : observers) {
            observer.update(message);
        }
    }
}