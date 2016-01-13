package com.XAKUS.Game;

/**
 * Created by xakus on 28.11.2015.
 */
public class Coordinate {
      private int x, y;
      private Positioning positioning;



      public Coordinate(int x, int y, Positioning positioning) {
            this.x = x;
            this.y = y;
            this.positioning = positioning;
      }



      public Positioning getPositioning() {
            return positioning;
      }



      public void setPositioning(Positioning positioning) {
            this.positioning = positioning;
      }



      public int getX() {
            return this.x;
      }



      public void setX(int x) {
            this.x = x;
      }



      public int getY() {
            return this.y;
      }



      public void setY(int y) {
            this.y = y;
      }



      public enum Positioning {
            HORIZONTAL,
            VERTICAL
      }
}
