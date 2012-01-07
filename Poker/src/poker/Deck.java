/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.Random;

/**
 *
 * @author Grzegorz Kolasa
 */
public class Deck {
    private Card deck[];
    private int currentCard;
    public static final int CARDS_COUNT = 52;
    private Random rand;

    public Deck() {
        String faces[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String suits[] = {"S", "H", "D", "C"};
        this.deck = new Card[Deck.CARDS_COUNT];
        this.currentCard = 0;
        this.rand = new Random();
        for(int i=0; i<deck.length; i++){
            this.deck[i] = new Card(faces[i%13], suits[i/13]);
        }
    }
    
    public void shuffle(){
        this.currentCard = 0;
        Card tmp;
        for(int first=0; first<this.deck.length; first++){
            int second = this.rand.nextInt(Deck.CARDS_COUNT);
            tmp = this.deck[first];
            this.deck[first] = this.deck[second];
            this.deck[second] = tmp;
        }
    }
    
    public Card dealCard(){
        if(currentCard < this.deck.length){
            return this.deck[currentCard++];
        }
        else{
            return null;
        }
    }
}
