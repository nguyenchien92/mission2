package com.example.nguyen.mission2.network;

public enum BackStack {
    GO_BACK_STACK(1), WITHOUT_BACK_STACK(0);

    private int value;

    BackStack(int value) {
        this.value = value;
    }
}
