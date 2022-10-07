package com.svj.business;

import java.util.Arrays;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(){
        int[] data= someDataService.getData();
        return Arrays.stream(data)
                .sum();
    }
}
