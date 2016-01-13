package com.XAKUS.Game;

import com.XAKUS.Ship.Attacking;
import com.XAKUS.Ship.Ships;

/**
 * Created by xakus on 30.11.2015.
 */
public class Game {
      public static void atack(Attacking attacking, int x, int y) {

            Ships.attack(attacking, x, y);

      }
}
