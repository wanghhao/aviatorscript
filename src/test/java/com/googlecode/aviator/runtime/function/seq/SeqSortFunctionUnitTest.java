package com.googlecode.aviator.runtime.function.seq;

import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class SeqSortFunctionUnitTest {

    @Test
    public void testSort_Array() {
        Integer[] a = new Integer[10];
        int index = 0;
        for (int i = 9; i >= 0; i--) {
            a[index++] = i;
        }

        AviatorObject[] args = new AviatorObject[1];
        args[0] = new AviatorRuntimeJavaType(a);

        SeqSortFunction fun = new SeqSortFunction();
        AviatorObject result = fun.call(null, args);
        index = 0;
        Integer[] dup = (Integer[]) result.getValue(null);
        assertFalse(Arrays.equals(a, dup));
        for (int i : dup) {
            assertEquals(i, index++);
        }
    }


    @Test
    public void testSort_List() {
        List<Integer> a = new ArrayList<Integer>();
        int index = 0;
        for (int i = 9; i >= 0; i--) {
            a.add(i);
        }

        AviatorObject[] args = new AviatorObject[1];
        args[0] = new AviatorRuntimeJavaType(a);

        SeqSortFunction fun = new SeqSortFunction();
        AviatorObject result = fun.call(null, args);
        index = 0;
        List<Integer> dup = (List<Integer>) result.getValue(null);
        assertFalse(a.equals(dup));
        System.out.println(a);
        System.out.println(dup);
        for (int i : dup) {
            assertEquals(i, index++);
        }
    }


    @Test(expected = IllegalArgumentException.class)
    public void testSort_HashSet() {
        Set<Integer> a = new HashSet<Integer>();
        int index = 0;
        for (int i = 9; i >= 0; i--) {
            a.add(i);
        }

        AviatorObject[] args = new AviatorObject[1];
        args[0] = new AviatorRuntimeJavaType(a);

        SeqSortFunction fun = new SeqSortFunction();
        AviatorObject result = fun.call(null, args);
    }
}
