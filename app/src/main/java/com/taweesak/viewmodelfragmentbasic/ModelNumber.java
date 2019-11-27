package com.taweesak.viewmodelfragmentbasic;

public class ModelNumber {

    int numA,numB;

    public ModelNumber(int numA, int numB) {
        this.numA = numA;
        this.numB = numB;
    }

    /*public int getNumA() {
        return numA;
    }

    public void setNumA(int numA) {
        this.numA = numA;
    }

    public int getNumB() {
        return numB;
    }

    public void setNumB(int numB) {
        this.numB = numB;
    }*/


    public int getPlusNumber(){
        return numA+numB;
    }

    public int getMinusNumber(){
        return numA-numB;
    }

    public int getMultiplyNumber(){
        return numA*numB;
    }

    public int getDivideNumber(){
        return numA/numB;
    }


}
