package io.github.unknowingtea.evedata.sourcing;

public interface Collector<T> {
    void add(T t);
}
