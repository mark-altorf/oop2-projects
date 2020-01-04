package model;

import java.time.LocalDate;

public class MakeGenericClass {

    GenericClass<String,String> genericClass = new GenericClass<>();

    public void method(){
        genericClass.add((String) new Object());
    }
}
