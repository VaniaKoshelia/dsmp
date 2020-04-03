package com.koshelia.prim;

import lombok.Data;

@Data
public class Rib {

    private int weight;
    private boolean isIncluded = false;
    private boolean isPrinted = false;

    public Rib(int weight) {
        this.weight = weight;
    }

}