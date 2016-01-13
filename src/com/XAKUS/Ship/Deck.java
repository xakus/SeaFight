package com.XAKUS.Ship;

/**
 * Created by xakus on 19.11.2015.
 */
public class Deck {
      private int  x;
      private int  y;
      private byte isLive;



      public Deck(int x, int y) {
            this.x = x;
            this.y = y;
            isLive = (byte) 4;
      }



      public byte isLive() {
            return isLive;
      }



      public void setIsLive(byte isLive) {
            this.isLive = isLive;
      }



      public int getY() {
            return y;
      }



      public void setY(int y) {
            this.y = y;
      }



      public int getX() {
            return x;
      }



      public void setX(int x) {
            this.x = x;
      }
}
