package model;

import java.util.ArrayList;

public class GenericClass<T, U> {

    ArrayList<T> myT = new ArrayList<>();

    public T getMyS(int index) {
        return myT.get(index);
    }

    public void add(T myT) {
        this.myT.add(myT);
    }

    public void print(T s){
        System.out.println(s);

    }

    public void doeIets(U u){
        System.out.println(u);
    }
}
