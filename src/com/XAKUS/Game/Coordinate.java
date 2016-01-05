package com.XAKUS.Game;

/**
 * Created by xakus on 28.11.2015.
 */
public class Coordinate {
    public enum  Positioning{
        HORIZONTAL,
        VERTICAL
    }
    private int  x,y;
    private  Positioning positioning;
    public  Coordinate(int x,int y,Positioning positioning){
        this.x=x;
        this.y=y;
        this.positioning=positioning;
    }

    public Positioning getPositioning() {
        return positioning;
    }

    public void setPositioning(Positioning positioning) {
        this.positioning = positioning;
    }

    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}
