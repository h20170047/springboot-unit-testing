package com.svj.business;


import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    private final List<String> mockList = mock(List.class);

    @Test
    public void sizeBasic(){
        when(mockList.size()).thenReturn(5);
        assertEquals(5, mockList.size());
    }

    @Test
    public void returnDiffValues(){
        when(mockList.size()).thenReturn(5).thenReturn(7);
        assertEquals(5, mockList.size());
        assertEquals(7, mockList.size());
    }

    @Test
    public void returnWithParams(){
        when(mockList.get(0)).thenReturn("svj");
        assertEquals("svj", mockList.get(0));
        assertEquals(null, mockList.get(1));
    }

    @Test
    public void returnWithGenericParameters(){
        // argument matcher- anyInt()
        when(mockList.get(anyInt())).thenReturn("svj");
        assertEquals("svj", mockList.get(0));
        assertEquals("svj", mockList.get(1));
    }

    @Test
    public void MethodBeingCalledVerified(){
        // SUT
        String value= mockList.get(0);
        String value2= mockList.get(0);

        // Verify
//        verify(mockList).get(0);
        verify(mockList, times(2)).get(0);
        verify(mockList, atLeast(1)).get(0);
        verify(mockList, atLeastOnce()).get(0);
        verify(mockList, atMost(2)).get(0);
        verify(mockList, never()).get(1);
    }

    @Test
    public void arguementCapturing(){
        // SUT
        mockList.add("Something1");
        mockList.add("Something2");
//        @Captor
        ArgumentCaptor<String> captor= ArgumentCaptor.forClass(String.class);
        verify(mockList, times(2)).add(captor.capture());
        List<String> allValues = captor.getAllValues();
        assertEquals("Something1", allValues.get(0));
        assertEquals("Something2", allValues.get(1));
    }

    @Test
    public void testSpy(){
        List spyList= spy(LinkedList.class);
        spyList.add("Obj1");
        System.out.println(spyList.get(0));
        System.out.println(spyList.size());
        spyList.add("2nd Obj");
        spyList.add("3rd instance");
        System.out.println(spyList.size());
        when(spyList.size()).thenReturn(5);
        System.out.println(spyList.size());
        spyList.add("4");
        System.out.println(spyList.size());
        verify(spyList).add("4");
    }
}
