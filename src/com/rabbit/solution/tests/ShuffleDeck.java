package com.rabbit.solution.tests;

import java.util.Random;

public class ShuffleDeck {
    int[] deck;
    Random rand;
    public ShuffleDeck(int[] deck) {
        this.deck = deck;
        this.rand = new Random();
    }
    public void shuffle() {
        for (int i = deck.length - 1; i >= 0; i--) {
            swap(i, rand.nextInt() % (i + 1));
        }
    }

    private void swap(int a, int b) {
        int tmp = deck[a];
        deck[a] = deck[b];
        deck[b] = tmp;
    }
}
