package com.taweesak.viewmodelfragmentbasic;

public class ModelNumber {

    double numA,numB;
    int choice;

    public ModelNumber(double numA, double numB,int choice) {
        this.numA = numA;
        this.numB = numB;
        this.choice = choice;
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


    public double getPlusNumber(){
        return numA+numB;
    }

    public double getMinusNumber(){
        return numA-numB;
    }

    public double getMultiplyNumber(){
        return numA*numB;
    }

    public double getDivideNumber(){
        return numA/numB;
    }


}
