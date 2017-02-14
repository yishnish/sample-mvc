package com.yishnish.samplemvc.core;

import com.yishnish.samplemvc.MyTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@ContextConfiguration(classes = {AppContextConfig.class})
public class MyClassTest extends MyTestCase{

    @Autowired
    private MyClass myClass;

    @Test
    public void testSomething() {
        assertThat(myClass.myMethod(12), equalTo(12));
        assertThat(myClass.myOtherMethod("hi"), equalTo("hi"));
    }
}
