package com.XAKUS.ComputerAI;

import com.XAKUS.Game.Coordinate;
import com.XAKUS.Game.Positioning;
import com.XAKUS.Sea.Sea;
import com.XAKUS.Ship.Attacking;
import com.XAKUS.Ship.ResultOfAttack;
import com.XAKUS.Ship.Ships;

import java.util.Random;

/**
 * Created by xakus on 17.01.2016.
 */
public class AI {
      private static int[][] compAttackMatrix = new int[Sea.myMatrix.length][Sea.myMatrix[0].length];
      private static int[][] smashMatrix      = new int[Sea.myMatrix.length][Sea.myMatrix[0].length];
      private static boolean isSmash          = false;
      private static boolean nextAttack       = true;
      private static Random  rnd              = new Random();

      public static void compAttack() {
            Coordinate     coordinate     = new Coordinate();
            ResultOfAttack resultOfAttack = ResultOfAttack.NULL;
            nextAttack = true;
            while(nextAttack) {
                  if(!isSmash) {
                        coordinate = getAttackCoordinate();
                        resultOfAttack = Ships.attack(Attacking.PLAYER, coordinate);
                        if(resultOfAttack == ResultOfAttack.WOUNDED) {
                              isSmash = true;
                        }
                        if(resultOfAttack == ResultOfAttack.PAST) {
                              smashMatrix[coordinate.getX()][coordinate.getY()] = 3;
                              nextAttack = false;
                        }

                  }
                  if(isSmash) {
                        attackSmash(coordinate, resultOfAttack);
                  }
            }
      }

      private static Coordinate getAttackCoordinate() {
            Coordinate attackCordinate = new Coordinate();

            int requiredNumber = 3;
            int count          = 0;
            int rndNumber      = 0;

            if(getNumberCount(3) != 0) {
                  requiredNumber = 3;
                  count = getNumberCount(requiredNumber);

            } else {
                  requiredNumber = 2;
                  count = getNumberCount(requiredNumber);
            }

            rndNumber = rnd.nextInt(count) + 1;
            int c = 0;

            for(int i = 0; i < compAttackMatrix.length; i++) {
                  for(int j = 0; j < compAttackMatrix[i].length; j++) {
                        if(compAttackMatrix[i][j] == requiredNumber) {
                              c++;
                              if(c == rndNumber) {
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

      private static void attackSmash(Coordinate coor, ResultOfAttack result) {
            boolean smashContine = true;
            while(smashContine) {
                  if(coor.getX() != -1 && coor.getY() != -1) {
                        if(result == ResultOfAttack.WOUNDED) {
                              smashMatrix[coor.getX()][coor.getY()] = 1;
                              if(coor.getX() - 1 >= 0) {
                                    if(smashMatrix[coor.getX() - 1][coor.getY()] == 0) {
                                          smashMatrix[coor.getX() - 1][coor.getY()] = 2;
                                    }
                              }
                              if(coor.getX() + 1 < smashMatrix.length) {
                                    if(smashMatrix[coor.getX() + 1][coor.getY()] == 0) {
                                          smashMatrix[coor.getX() + 1][coor.getY()] = 2;
                                    }
                              }
                              if(coor.getY() - 1 >= 0) {
                                    if(smashMatrix[coor.getX()][coor.getY() - 1] == 0) {
                                          smashMatrix[coor.getX()][coor.getY() - 1] = 2;
                                    }
                              }
                              if(coor.getY() + 1 < smashMatrix.length) {
                                    if(smashMatrix[coor.getX()][coor.getY() + 1] == 0) {
                                          smashMatrix[coor.getX()][coor.getY() + 1] = 2;
                                    }
                              }
                        }
                        smashSort();
                  }
                  coor = getSmashCoordinate();

                  System.out.println("getX=" + coor.getX() + " getY=" + coor.getY());
                  result = Ships.attack(Attacking.PLAYER, coor);

                  if(result == ResultOfAttack.PAST || result == ResultOfAttack.KILLED || result == ResultOfAttack.KILLED_ALL) {
                        smashContine = false;

                  }
                  if(result == ResultOfAttack.PAST) {
                        nextAttack = false;
                  }
                  if(result == ResultOfAttack.KILLED) {
                        isSmash = false;
                  }
            }

            if(result == ResultOfAttack.KILLED) {
                  for(int i = 0; i < smashMatrix.length; i++) {
                        for(int j = 0; j < smashMatrix[i].length; j++) {
                              if(smashMatrix[i][j] == 1) {
                                    smashMatrix[i][j] = 3;
                                    if(i - 1 >= 0) {
                                          if(smashMatrix[i - 1][j] != 1) {
                                                smashMatrix[i - 1][j] = 3;
                                          }
                                    }

                                    if(i - 1 >= 0 && j - 1 >= 0) {
                                          if(smashMatrix[i - 1][j - 1] != 1) {
                                                smashMatrix[i - 1][j - 1] = 3;
                                          }
                                    }
                                    if(j - 1 >= 0) {
                                          if(smashMatrix[i][j - 1] != 1) {
                                                smashMatrix[i][j - 1] = 3;
                                          }
                                    }

                                    if(i + 1 < smashMatrix.length) {
                                          if(smashMatrix[i + 1][j] != 1) {
                                                smashMatrix[i + 1][j] = 3;
                                          }
                                    }

                                    if(i - 1 >= 0 && j + 1 < smashMatrix[i].length) {
                                          if(smashMatrix[i - 1][j + 1] != 1) {
                                                smashMatrix[i - 1][j + 1] = 3;
                                          }
                                    }
                                    if(j + 1 < smashMatrix[i].length) {
                                          if(smashMatrix[i][j + 1] != 1) {
                                                smashMatrix[i][j + 1] = 3;
                                          }
                                    }

                                    if(i + 1 < smashMatrix.length && j - 1 >= 0) {
                                          if(smashMatrix[i + 1][j - 1] != 1) {
                                                smashMatrix[i + 1][j - 1] = 3;
                                          }
                                    }
                                    if(i + 1 < smashMatrix.length && j + 1 < smashMatrix[i].length) {
                                          if(smashMatrix[i + 1][j + 1] != 1) {
                                                smashMatrix[i + 1][j + 1] = 3;
                                          }
                                    }
                              }
                        }
                  }
//            for (int i = 0; i < smashMatrix.length; i++) {
//                for (int j = 0; j < smashMatrix[i].length; j++) {
//                    if (smashMatrix[i][j] == 1) {
//                        smashMatrix[i][j] = 3;
//                    }
//                }
//            }
                  for(int i = 0; i < smashMatrix.length; i++) {
                        for(int j = 0; j < smashMatrix[i].length; j++) {
                              if(smashMatrix[i][j] == 3) {
                                    compAttackMatrix[i][j] = 0;
                              }
                        }
                  }

            }

      }

      private static Coordinate getSmashCoordinate() {
            Coordinate coordinate = new Coordinate();
            for(int i = 0; i < smashMatrix.length; i++) {
                  for(int j = 0; j < smashMatrix[i].length; j++) {
                        if(smashMatrix[i][j] == 2) {
                              coordinate.setX(i);
                              coordinate.setY(j);
                              smashMatrix[i][j] = 3;
                              compAttackMatrix[i][j] = 0;
                              return coordinate;
                        }
                  }
            }
            return coordinate;
      }

      private static void smashSort() {
            int         count       = 0;
            int         x           = -1, y = -1;
            Positioning positioning = Positioning.NULL;
            for(int i = 0; i < smashMatrix.length; i++) {
                  for(int j = 0; j < smashMatrix[i].length; j++) {
                        if(smashMatrix[i][j] == 1) {
                              count++;
                        }
                  }
            }
            if(count > 1) {
                  for(int i = 0; i < smashMatrix.length; i++) {
                        for(int j = 0; j < smashMatrix[i].length; j++) {
                              if(smashMatrix[i][j] == 1) {
                                    if(x == -1 && y == -1) {
                                          x = i;
                                          y = j;
                                    } else {
                                          if(x == i) {
                                                positioning = Positioning.VERTICAL;
                                                break;
                                          }
                                          if(y == j) {
                                                positioning = Positioning.HORIZONTAL;
                                                break;
                                          }
                                    }
                              }
                        }
                  }
                  for(int i = 0; i < smashMatrix.length; i++) {
                        for(int j = 0; j < smashMatrix[i].length; j++) {
                              if(smashMatrix[i][j] == 1) {
                                    if(positioning == Positioning.HORIZONTAL) {
                                          if(j - 1 >= 0) {
                                                if(smashMatrix[i][j - 1] == 2) {
                                                      smashMatrix[i][j - 1] = 3;
                                                      compAttackMatrix[i][j - 1] = 0;
                                                }
                                          }
                                          if(j + 1 < smashMatrix[i].length - 1) {
                                                if(smashMatrix[i][j + 1] == 2) {
                                                      smashMatrix[i][j + 1] = 3;
                                                      compAttackMatrix[i][j + 1] = 0;
                                                }
                                          }

                                    }
                                    if(positioning == Positioning.VERTICAL) {
                                          if(i - 1 >= 0) {
                                                if(smashMatrix[i - 1][j] == 2) {
                                                      smashMatrix[i - 1][j] = 3;
                                                      compAttackMatrix[i - 1][j] = 0;
                                                }
                                          }
                                          if(i + 1 < smashMatrix.length - 1) {
                                                if(smashMatrix[i + 1][j] == 2) {
                                                      smashMatrix[i + 1][j] = 3;
                                                      compAttackMatrix[i + 1][j] = 0;
                                                }
                                          }

                                    }
                              }
                        }
                  }
            }
      }

      private static int getNumberCount(int num) {
            int number = 0;
            for(int i = 0; i < compAttackMatrix.length; i++) {
                  for(int j = 0; j < compAttackMatrix[i].length; j++) {
                        if(compAttackMatrix[i][j] == num) {
                              number++;
                        }
                  }
            }
            return number;
      }

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
            for(int i = 0; i < compAttackMatrix.length; i++) {
                  for(int j = 0; j < compAttackMatrix[i].length; j++) {
                        smashMatrix[i][j] = 0;
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
