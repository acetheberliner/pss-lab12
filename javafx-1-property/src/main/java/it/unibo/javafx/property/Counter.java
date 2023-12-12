package it.unibo.javafx.property;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Counter {
    private final IntegerProperty value;

    public Counter() {
        this.value = new SimpleIntegerProperty(0);
    }

    public void increment() {
        this.value.set(this.value.add(1).get());
    }

    public void decrement() {
        this.value.set(this.value.subtract(1).get());
    }

    public IntegerProperty counterProperty() {
        return this.value;
    }
}
