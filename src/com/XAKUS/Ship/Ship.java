package com.XAKUS.Ship;

import com.XAKUS.Game.Coordinate;
import com.XAKUS.Game.Positioning;

/**
 * Created by xakus on 19.11.2015.
 */
public class Ship {

      int i = 0;
      private int    countDeck;
      private Deck[] deck;
      private boolean isKilled = false;
      private Positioning position;

      public Ship(int countDeck) {
            this.countDeck = countDeck;
            deck = new Deck[countDeck];
      }

      public boolean isKilled() {
            return isKilled;
      }

      public void setIsKilled(boolean isKilled) {
            this.isKilled = isKilled;
      }

      public Positioning getPosition() {
            return position;
      }
      public int getCountDeck() {
            return countDeck;
      }

      public Deck[] getDeck() {
            return deck;
      }

      public void setDeck(Coordinate coordinate) {
            this.position = coordinate.getPositioning();
            int x = coordinate.getX(), y = coordinate.getY();

            for(int i = 0; i < countDeck; i++) {
                  deck[i] = new Deck(x, y);
                  if (coordinate.getPositioning() == Positioning.VERTICAL) {
                        y++;
                  } else {
                        x++;
                  }

            }
      }
}
