package com.co.reto.model;

public class StateModel {
    private boolean stateOperation;
    public StateModel(boolean stateOperation) {
        this.stateOperation = stateOperation;
    }

    public boolean isStateOperation() {
        return stateOperation;
    }

    public void setStateOperation(boolean stateOperation) {
        this.stateOperation = stateOperation;
    }
}
