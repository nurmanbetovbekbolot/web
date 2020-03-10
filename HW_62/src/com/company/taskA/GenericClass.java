package com.company.taskA;

public class GenericClass<K, V> {
    private K key;
    private V value;

    public GenericClass(K key, V value) {
        this.key = key;
        this.value = value;
    }


    @Override
    public String toString() {
        return "GenericClass{" +
                "value=" + value +
                '}';
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void print() {
        System.out.println(key);
        System.out.println(value);
    }
}