package com.XAKUS.Display;

import com.XAKUS.Game.Constants;
import com.XAKUS.Sea.Sea;

/**
 * Created by xakus on 18.11.2015.
 */
public abstract class Display {
      public static void drawFullDisplay(int[][] myMatrix, int[][] compMatrix) {

            System.out.println("\u001b[2J");
            System.out.print("                              ");
            for(int i = 0; i < myMatrix[0].length; i++) {
                  if(i > 9) {

                        System.out.print(" " + " " + (i + 1));
                  } else {
                        System.out.print(" " + " " + " " + (i + 1));
                  }
            }
            if(myMatrix[0].length >= 10) {
                  System.out.print("        ");
            } else {
                  System.out.print("         ");
            }
            for(int i = 0; i < compMatrix[0].length; i++) {
                  if(i > 9) {
                        System.out.print(" " + " " + (i + 1));
                  } else {
                        System.out.print(" " + " " + " " + (i + 1));
                  }
            }
            System.out.println();
            System.out.print("                              ");
            System.out.print(Constants.ANSI_CYAN + " |" + Constants.ANSI_RESET);
            ////// |___|___|___|___| .....
            for(int i = 0; i < myMatrix[0].length; i++) {
                  System.out.print(Constants.ANSI_CYAN + "___|" + Constants.ANSI_RESET);
            }
            System.out.print(Constants.ANSI_CYAN + "        |" + Constants.ANSI_RESET);
            for(int i = 0; i < compMatrix[0].length; i++) {
                  System.out.print(Constants.ANSI_CYAN + "___|" + Constants.ANSI_RESET);
            }
            System.out.println();
            for(int i = 0; i < myMatrix.length; i++) {
                  System.out.print("                              ");
                  System.out.print(Character.toString((char) (i + 65)) + Constants.ANSI_CYAN + "|");
                  for(int j = 0; j < myMatrix[i].length; j++) {
                        System.out.print(Constants.ANSI_CYAN + "_" + Constants.ANSI_RESET + getMySymbol(myMatrix[i][j]) + Constants.ANSI_CYAN + "_|" + Constants.ANSI_RESET);
                  }
                  System.out.print("       " + Character.toString((char) (i + 65)) + Constants.ANSI_CYAN + "|" + Constants.ANSI_RESET);
                  for(int j = 0; j < compMatrix[i].length; j++) {
                        System.out.print(Constants.ANSI_CYAN + "_" + Constants.ANSI_RESET + getCompSymbol(compMatrix[i][j]) + Constants.ANSI_CYAN + "_|" + Constants.ANSI_RESET);
                  }
                  System.out.println();
            }
      }

      public static void writeTextAndDisplay(String str) {
            drawFullDisplay(Sea.myMatrix, Sea.compMatrix);
            System.out.print("                              ");
            System.out.print("                                        ");
            System.out.println(Constants.ANSI_YELLOW + str + Constants.ANSI_RESET);
      }

      public static void writeText(String str) {
            System.out.print("                              ");
            System.out.print("                                        ");
            System.out.println(Constants.ANSI_YELLOW + str + Constants.ANSI_RESET);
      }

      private static String getMySymbol(int x) {
            String[] strings = new String[]{
                    "_",
                    "~",
                    "*",
                    "X",
                    "O"
            };
            String str = null;
            if(strings[x].equals("X")) {
                  str = Constants.ANSI_RED + strings[x] + Constants.ANSI_RESET;
            }
            if(strings[x].equals("O")) {
                  str = Constants.ANSI_YELLOW + strings[x] + Constants.ANSI_RESET;
            }
            if(strings[x].equals("*")) {
                  str = Constants.ANSI_YELLOW + strings[x] + Constants.ANSI_RESET;
            }
            if(strings[x].equals("_")) {
                  str = Constants.ANSI_CYAN + strings[x] + Constants.ANSI_RESET;
            }
            if(strings[x].equals("~")) {
                  str = Constants.ANSI_CYAN + strings[x] + Constants.ANSI_RESET;
            }
            return str;
      }

      private static String getCompSymbol(int x) {
            String[] strings = new String[]{
                    "_",
                    "~",
                    "*",
                    "X",
                    "_"
            };
            String str = null;
            if(strings[x].equals("X")) {
                  str = Constants.ANSI_RED + strings[x] + Constants.ANSI_RESET;
            }
            if(strings[x].equals("_")) {
                  str = Constants.ANSI_CYAN + strings[x] + Constants.ANSI_RESET;
            }

            if(strings[x].equals("*")) {
                  str = Constants.ANSI_YELLOW + strings[x] + Constants.ANSI_RESET;
            }
            if(strings[x].equals("~")) {
                  str = Constants.ANSI_CYAN + strings[x] + Constants.ANSI_RESET;
            }
            return str;
      }
}