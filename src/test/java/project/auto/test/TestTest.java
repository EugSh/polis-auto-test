package project.auto.test;

import com.sun.tools.javac.util.Assert;
import junit.framework.AssertionFailedError;
import org.junit.Test;

public class TestTest {

    @Test
    public void test(){
//        Assert.error("123");
//        System.out.println(1+123);
        is(true);
    }

    public boolean is(boolean t){
        if (t) {
            return true;
        }
        throw new AssertionFailedError("not true");
    }
}
