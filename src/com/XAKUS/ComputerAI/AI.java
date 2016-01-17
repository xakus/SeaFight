package com.XAKUS.ComputerAI;

import com.XAKUS.Sea.Sea;

/**
 * Created by xakus on 17.01.2016.
 */
public class AI {
      private static int[][] compAttackMatrix = new int[Sea.myMatrix.length][Sea.myMatrix[0].length];
      private static int[][] smashMatrix      = new int[Sea.myMatrix.length][Sea.myMatrix[0].length];

      public static void initAttackMatrix() {

            for(int i = 0; i < compAttackMatrix.length; i++) {
                  for(int j = 0; j < compAttackMatrix[i].length; j++) {
                        if(((i + j) % 2) == 0) {
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
