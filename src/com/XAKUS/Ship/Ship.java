package com.XAKUS.Ship;

import com.XAKUS.Game.Coordinate;

/**
 * Created by xakus on 19.11.2015.
 */
public class Ship {

    private int countDeck;
    private Deck[] deck;

    public Ship(int countDeck) {
        this.countDeck = countDeck;
        deck = new Deck[countDeck];
    }

    public int getCountDeck() {
        return countDeck;
    }

    public Deck[] getDeck() {
        return deck;
    }

    int i = 0;

    public void setDeck(Coordinate coordinate) {
        int x = coordinate.getX(), y = coordinate.getY();


        for (int i = 0; i < countDeck; i++) {
            deck[i] = new Deck(x, y);
            if (coordinate.getPositioning() == Coordinate.Positioning.VERTICAL) {
                y++;
            } else {
                x++;
            }

        }
    }
}
