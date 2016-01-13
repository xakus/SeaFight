package com.XAKUS.Game;

import com.XAKUS.Ship.Ship;

import java.util.List;

/**
 * Created by xakus on 30.11.2015.
 */
public class Game {
      public static void atack(int x, int y, int[][] matrix, List<Ship> list) {
            switch(matrix[x][y]) {
                  case 0:
                        matrix[x][y] = 1;
                        break;
                  case 1:
                        matrix[x][y] = 1;
                        break;
                  case 2:
                        matrix[x][y] = 2;
                        break;
                  case 3:
                        matrix[x][y] = 3;
                        break;
                  case 4:
                        matrix[x][y] = 3;
                        break;
            }

      }
}
