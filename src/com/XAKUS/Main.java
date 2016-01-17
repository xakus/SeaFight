package com.XAKUS;

import com.XAKUS.ComputerAI.AI;
import com.XAKUS.Display.Display;
import com.XAKUS.Game.Coordinate;
import com.XAKUS.Game.Game;
import com.XAKUS.Game.Language;
import com.XAKUS.Sea.Sea;
import com.XAKUS.Sea.SeaResolution;
import com.XAKUS.Ship.Attacking;
import com.XAKUS.Ship.Ships;

import java.util.Scanner;

public class Main {

      public static void main(String[] args) throws InterruptedException {

            Scanner sc = new Scanner(System.in);
            Sea.createSea(SeaResolution.R_10X10);
            Language.setLang(Language.Lang.RUSSIAN);
            Display.writeText(Language.GetWord(0));
            Display.writeText(Language.GetWord(1));
            AI.initAttackMatrix();
            Coordinate c = new Coordinate();/////TEST
            for (int i = 0; i < Sea.myMatrix.length * Sea.myMatrix.length; i++) {
                  Display.writeTextAndDisplay(Language.GetWord(2));
                  Thread.sleep(0);
                  c = AI.getAttackCoordinate();
                  Ships.attack(Attacking.PLAYER, c.getX(), c.getY());
            }
            boolean start = true;
            while(start) {
                  Display.writeTextAndDisplay(Language.GetWord(2));
                  int x = Integer.parseInt(sc.next()) - 1;
                  int y = Integer.parseInt(sc.next()) - 1;
                  Game.atack(Attacking.COMPUTER, x, y);

            }
      }
}
