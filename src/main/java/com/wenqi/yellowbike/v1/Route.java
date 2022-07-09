package com.wenqi.yellowbike.v1;

public enum Route {
    A_TO_B_1(14),
    A_TO_B_2(14),

    A_TO_C_1(5),
    A_TO_C_2(21),

    B_TO_C_1(9),
    B_TO_C_2(19),

    B_TO_A_1(14),
    B_TO_A_2(14),

    C_TO_A_1(5),
    C_TO_A_2(21),

    C_TO_B_1(9),
    C_TO_B_2(19);

    private int distance;

    Route(int i) {
        this.distance = i;
    }


    public int getDistance() {
        return distance;
    }
}
