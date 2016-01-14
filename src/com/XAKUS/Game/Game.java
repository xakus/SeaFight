package com.XAKUS.Game;

import com.XAKUS.Display.Display;
import com.XAKUS.Ship.Attacking;
import com.XAKUS.Ship.ResultOfAttack;
import com.XAKUS.Ship.Ships;

/**
 * Created by xakus on 30.11.2015.
 */
public class Game {
      static ResultOfAttack resultOfAttack;

      public static void atack(Attacking attacking, int x, int y) {

            resultOfAttack = Ships.attack(attacking, x, y);
            if(resultOfAttack == ResultOfAttack.KILLED_ALL) {
                  if(attacking == Attacking.COMPUTER) {
                        Display.writeText(Language.GetLanguage(4));
                  }
                  if(attacking == Attacking.PLAYER) {
                        Display.writeText(Language.GetLanguage(3));
                  }

            }
            if(resultOfAttack == ResultOfAttack.IT_WAS) {
                  Display.writeText(Language.GetLanguage(5));
            }

      }
}
