package com.XAKUS;

import com.XAKUS.ComputerAI.AI;
import com.XAKUS.Display.Display;
import com.XAKUS.Display.SeaFightForm;
import com.XAKUS.Game.Coordinate;
import com.XAKUS.Game.Game;
import com.XAKUS.Game.Language;
import com.XAKUS.Sea.Sea;
import com.XAKUS.Sea.SeaResolution;
import com.XAKUS.Ship.Attacking;
import com.XAKUS.Ship.ResultOfAttack;

import javax.swing.*;
import java.util.Scanner;

public class Main {

      public Main(){
            JFrame frame = new JFrame("SeaFight");
            frame.setContentPane(new SeaFightForm().getView());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            
            
      }
      public static void main(String[] args) throws InterruptedException {
            new Main();
            ResultOfAttack resultOfAttack = ResultOfAttack.NULL;
            Scanner sc = new Scanner(System.in);
            Sea.createSea(SeaResolution.R_10X10);
            Language.setLang(Language.Lang.RUSSIAN);
            Display.writeText(Language.GetWord(0));
            Display.writeText(Language.GetWord(1));
            AI.initAttackMatrix();
            Coordinate c = new Coordinate();/////TEST
            for (int i = 0; i < Sea.myMatrix.length * Sea.myMatrix.length; i++) {

                  //Thread.sleep(1000);
                  resultOfAttack = AI.compAttack();
                  Display.writeText(Language.GetWord(2));
                  if(resultOfAttack == ResultOfAttack.KILLED_ALL) {
                        System.exit(1);
                  }
                  int y = Integer.parseInt(sc.next()) - 1;

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
