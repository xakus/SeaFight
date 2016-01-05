package com.XAKUS.Sea;

import com.XAKUS.Ship.Ships;

/**
 * Created by xakus on 20.11.2015.
 */
public class Sea {

    SeaResolution resolution;

  public static   int[][] myMatrix;
    public static  int[][] compMatrix;
    private   Sea(SeaResolution resolution){
        this.resolution=resolution;
        switch (resolution) {
            case R_5X5:
                myMatrix=new int[5][5];
                compMatrix=new int[5][5];
                break;
            case R_10X10:
                myMatrix=new int[10][10];
                compMatrix=new int[10][10];
                break;
            case R_15X15:
                myMatrix=new int[15][15];
                compMatrix=new int[15][15];
                break;
        }

    }
    public static void createSea(SeaResolution resolution){
        new Sea(resolution);
        for(int i=0;i<myMatrix.length;i++){
            for (int j=0;j<myMatrix[i].length;j++){
                myMatrix[i][j]=0;
                compMatrix[i][j]=0;
            }
        }
        Ships.createShips(resolution);
    }

}
