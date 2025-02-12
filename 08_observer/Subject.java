import java.util.*;

public abstract class Subject {
  
      private ArrayList<Observer> observers = new ArrayList<>();
  
      public void subscribe(Observer o) {
          observers.add(o);
      }
  
      public void unsubscribe(Observer o) {
          observers.remove(o);
      }
  
      public void notifyObservers() {}

      public ArrayList<Observer> observers() {
        return observers;
      }
  }
