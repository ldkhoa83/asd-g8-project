package org.miu.asd.framework.domain;

public interface Observable {

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
