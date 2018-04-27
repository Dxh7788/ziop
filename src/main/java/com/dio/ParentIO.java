package com.dio;

/**
 * @author xh.d
 * @date 2018/1/5 18:03
 */

/**
 * root io
 * generation泛型
 * ジェネリックプログラミング
 * */
public class ParentIO<K,V> {
    private K key;
    private V value;

    private ParentIO parentIO;
    private ParentIO() {
    }

    public ParentIO getInstance(K key,V value){
        if (parentIO==null){
            parentIO = new ParentIO();
            parentIO.setKey(key);
            parentIO.setValue(value);
        }else {
            parentIO.setKey(key);
            parentIO.setValue(value);
        }
        return parentIO;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
