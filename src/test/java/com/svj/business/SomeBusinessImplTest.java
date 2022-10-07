package com.svj.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplTest {

    @InjectMocks
    private SomeBusinessImpl someBusiness;
    @Mock
    private SomeDataService mockInstance;

    @Test
    void calculateSum() {
        when(mockInstance.getData()).thenReturn(new int[]{1,2,3});
        int expected= 6;
        assertEquals(expected, someBusiness.calculateSum());
    }

    @Test
    void calculateSumOfEmptyArray() {
        when(mockInstance.getData()).thenReturn(new int[]{});
        int expected= 0;
        assertEquals(expected, someBusiness.calculateSum());
    }

    @Test
    void calculateSumOfSingleElementArray() {
        when(mockInstance.getData()).thenReturn(new int[]{5});
        int expected= 5;
        assertEquals(expected, someBusiness.calculateSum());
    }
}