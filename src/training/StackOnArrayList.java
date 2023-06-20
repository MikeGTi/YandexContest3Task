package training;

import java.util.ArrayList;


public class StackOnArrayList<T> {
    public static void main(String[] args) {
        StackOnArrayList<Integer> stackOnArrayList = new StackOnArrayList();
        System.out.println("stackOnArrayList is empty: " + stackOnArrayList.isEmpty());

        stackOnArrayList.push(1);
        stackOnArrayList.push(2);
        stackOnArrayList.push(3);
        System.out.println(stackOnArrayList);
        System.out.println("stackOnArrayList is empty: " + stackOnArrayList.isEmpty());
        System.out.println("stackOnArrayList size: " + stackOnArrayList.size());

        System.out.println("deleted: " + stackOnArrayList.pop());
        System.out.println(stackOnArrayList);
        System.out.println("stackOnArrayList is empty: " + stackOnArrayList.isEmpty());
        System.out.println("stackOnArrayList size: " + stackOnArrayList.size());

        System.out.println("deleted: " + stackOnArrayList.pop());
        System.out.println("deleted: " + stackOnArrayList.pop());
        System.out.println(stackOnArrayList);
        System.out.println("stackOnArrayList is empty: " + stackOnArrayList.isEmpty());
        System.out.println("stackOnArrayList size: " + stackOnArrayList.size());
    }

    private ArrayList<T> list = new ArrayList<>();

    public void push(T entry) {
        list.add(entry);
    }

    public T pop(){
        list.trimToSize();
        if (this.isEmpty()) {
            return null;
        } else {
            return list.remove(list.size()-1);
        }
    }

    public void clean(){
        list.clear();
    }

    public boolean isEmpty(){
        if (list == null) return true;
        return list.isEmpty();
    }

    public Integer size(){
        return list.size();
    }

    @Override
    public String toString() {
        return "training.StackOnArrayList{" +
                "list=" + list +
                '}';
    }
}
