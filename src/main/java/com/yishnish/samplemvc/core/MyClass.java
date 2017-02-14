package com.yishnish.samplemvc.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyClass {

    private MyOtherClass myOtherClass;

    @Autowired
    public MyClass(MyOtherClass myOtherClass) {
        this.myOtherClass = myOtherClass;
    }

    public int myMethod(int parameter){
        return parameter;
    }

    public String myOtherMethod(String value) {
        return myOtherClass.myMethod(value);
    }
}

