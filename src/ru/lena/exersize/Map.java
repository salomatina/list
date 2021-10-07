package ru.lena.exersize;

public class Map {
    List list = new List();

    public class Record {
        private final Object key;
        private Object value;

        public Record(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Object getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }

    public void put(Object key, Object value) {
        int index = getIndex(key);
        if (index != -1) {
            ((Record) list.get(index)).setValue(value);
        } else {
            Record rec = new Record(key, value);
            list.add(rec);
        }
    }

    public List getKeys() {
        List listOfKeys = new List();
        for (int i = 0; i < list.size(); i++) {
            Object keyFromTheRecord = ((Record) list.get(i)).getKey();
            listOfKeys.add(keyFromTheRecord);
        }
        return listOfKeys;
    }

    public boolean keyContains(Object key) {
        int index = getIndex(key);
        return index != -1;
    }

    public List getValues() {
        List listOfValues = new List();
        for (int i = 0; i < list.size(); i++) {
            Object valueFromTheRecord = ((Record) list.get(i)).getValue();
            listOfValues.add(valueFromTheRecord);
        }
        return listOfValues;
    }

    public List getEntries() {
        List listOfEntries = new List();
        for (int i = 0; i < list.size(); i++) {
            Object keyAndValue = ((Record) list.get(i)).getKey() + "==" + ((Record) list.get(i)).getValue();
        }
        return listOfEntries;
    }

    public int getIndex(Object key) {
        for (int i = 0; i < list.size(); i++) {
            if (((Record) list.get(i)).getKey() == key) {
                return i;
            }
        }
        return -1;
    }

    public Object get(Object key) {
        if (keyContains(key)) {
            int index = getIndex(key);
            return ((Record) list.get(index)).getValue();
        }
        return null;
    }

    public Object get(Object key, Object byDefault) {
        if (get(key) != null) {
            return get(key);
        }
        put(key, byDefault);
        return byDefault;
    }

    public Object remove(Object key) {
        int index = getIndex(key);
        if (index == -1) {
            return null;
        }
        Object removedObject = ((Record) list.get(index)).getValue();
        list.remove(index);
        return removedObject;
    }
    public int size(){
        return list.size();
    }
    public boolean isEmpty(){
        return list.size() == 0;
    }

//    public static void main(String[] args) {
//    Map map = new Map();
//    map.put(1,"a");
//    map.put(2,"b");
//    System.out.println(map.get(1));
//    System.out.println(map.get(2));
//    System.out.println(map.get(0));
//    map.put(1,"changed first elem");
//    System.out.println(map.get(1));
//    map.remove(1);
//    System.out.println(map.get(1));
//    System.out.println(map.get(1,"testing getter"));
//    }
}
