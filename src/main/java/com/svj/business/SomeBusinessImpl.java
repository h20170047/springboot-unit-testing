package com.svj.business;

import java.util.Arrays;

public class SomeBusinessImpl {

    public int calculateSum(int[] data){
        return Arrays.stream(data)
                .sum();
    }
}
