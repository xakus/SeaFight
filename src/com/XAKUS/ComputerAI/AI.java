package com.XAKUS.ComputerAI;

import com.XAKUS.Game.Coordinate;
import com.XAKUS.Sea.Sea;

import java.util.Random;

/**
 * Created by xakus on 17.01.2016.
 */
public class AI {
    private static int[][] compAttackMatrix = new int[Sea.myMatrix.length][Sea.myMatrix[0].length];
    private static int[][] smashMatrix = new int[Sea.myMatrix.length][Sea.myMatrix[0].length];
    private static boolean isSmash = false;

    private static Random rnd = new Random();

    public static Coordinate getAttackCoordinate() {
        Coordinate attackCordinate = new Coordinate();

        int requiredNumber = 3;
        int count = 0;
        int rndNumber = 0;

        if (getNumberCount(3) != 0) {
            requiredNumber = 3;
            count = getNumberCount(requiredNumber);

        } else {
            requiredNumber = 2;
            count = getNumberCount(requiredNumber);
            }


        rndNumber = rnd.nextInt(count) + 1;
        int c = 0;

        for (int i = 0; i < compAttackMatrix.length; i++) {
            for (int j = 0; j < compAttackMatrix[i].length; j++) {
                if (compAttackMatrix[i][j] == requiredNumber) {
                    c++;
                    if (c == rndNumber) {
                        attackCordinate.setX(i);
                        attackCordinate.setY(j);
                        compAttackMatrix[i][j] = 0;
                        return attackCordinate;
                    }
                }
            }
        }
        return attackCordinate;
    }


    private static int getNumberCount(int num) {
        int number = 0;
        for (int i = 0; i < compAttackMatrix.length; i++) {
            for (int j = 0; j < compAttackMatrix[i].length; j++) {
                if (compAttackMatrix[i][j] == num) {
                    number++;
                }
            }
        }
        return number;
    }

    public static void initAttackMatrix() {
        for (int i = 0; i < compAttackMatrix.length; i++) {
            for (int j = 0; j < compAttackMatrix[i].length; j++) {
                if (((i + j) % 2) == 0) {
                    compAttackMatrix[i][j] = 3;
                } else {
                    compAttackMatrix[i][j] = 2;
                }
            }
        }
        //compAttackMatrix=
        //3 2 3 2 3 2 3 2 3 2 3 2 3 2...
        //2 3 2 3 2 3 2 3 2 3 2 3 2 3...
        //3 2 3 2 3 2 3 2 3 2 3 2 3 2...
        //2 3 2 3 2 3 2 3 2 3 2 3 2 3...
        //3 2 3 2 3 2 3 2 3 2 3 2 3 2...
        //2 3 2 3 2 3 2 3 2 3 2 3 2 3...
    }
}
