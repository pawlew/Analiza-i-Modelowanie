/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.ArrayList;

/**
 *
 * @author siesiek
 */
public class Table {

    public ArrayList<Player> Players = new ArrayList<Player>();
    public ArrayList<Card> CommCards = new ArrayList<Card>();
    public ArrayList<Card> BurnCards = new ArrayList<Card>();
    private int pot;
    private int hotSeat;
    private int round = 0;
    private int currentBet;
    private int prevBet;
    private boolean gameStatus;
    private int dealer = -1;
    private int playerActionsReq;
    private String sActions = "";

    public String getsActions() {
        return sActions;
    }

    public void setsActions(String sActions) {
        this.sActions = sActions;
    }

    int givePot() {
        return pot;
    }

    void addToPot(int n) {
        pot = pot + n;
    }

    void decActionsReq() {
        --playerActionsReq;
    }

    void addCommCards(Card c) {
        CommCards.add(c);
    }

    void clearCommCards() {
        CommCards.clear();
    }

    void addBurnCard(Card c) {
        BurnCards.add(c);
    }

    void clearBurnCards() {
        BurnCards.clear();
    }

    /**
     * @return the pot
     */
    public int getPot() {
        return pot;
    }

    /**
     * @param pot the pot to set
     */
    public void setPot(int pot) {
        this.pot = pot;
    }

    /**
     * @return the hotSeat
     */
    public int getHotSeat() {
        return hotSeat;
    }

    /**
     * @param hotSeat the hotSeat to set
     */
    public void setHotSeat(int hotSeat) {
        this.hotSeat = hotSeat;
    }

    /**
     * @return the gameStatus
     */
    public boolean isGameStatus() {
        return gameStatus;
    }

    /**
     * @param gameStatus the gameStatus to set
     */
    public void setGameStatus(boolean gameStatus) {
        this.gameStatus = gameStatus;
    }

    /**
     * @return the dealer
     */
    public int getDealer() {
        return dealer;
    }

    /**
     * @return the new dealer
     */
    // nextDealer fixes the array out of bounds error. -Ross Larson
    public int nextDealer() {
        int newDeal = ++dealer % Players.size();
        return newDeal;
    }

    /**
     * @return the small blind player
     */
    // getSmall should return the player number next to dealer. 
    // It should fix the array out of bounds error. -Ross Larson
    public int getSmall() {
        int smallGuy = (1 + getDealer()) % Players.size();
        return smallGuy;
    }

    /**
     * @return the big blind player
     */
    // getSmall should return the player number two away from dealer. 
    // It should fix the array out of bounds error. -Ross Larson
    public int getBig() {
        int bigGuy = (2 + getDealer()) % Players.size();
        return bigGuy;
    }

    /**
     * @return the player next to the big blind (for first choice)
     */
    // getSmall should return the player number two away from dealer. 
    // It should fix the array out of bounds error. -Ross Larson
    public int getFirstBet() {
        int betGuy = (3 + getDealer()) % Players.size();
        return betGuy;
    }

    /**
     * @param dealer the dealer to set
     */
    public void setDealer(int dealer) {
        this.dealer = dealer;
    }

    /**
     * @return the playerActionsReq
     */
    public int getPlayerActionsReq() {
        return playerActionsReq;
    }

    /**
     * @param playerActionsReq the playerActionsReq to set
     */
    public void setPlayerActionsReq(int playerActionsReq) {
        this.playerActionsReq = playerActionsReq;
    }

    /**
     * @return the round
     */
    public int getRound() {
        return round;
    }

    /**
     * @param round the round to set
     */
    public void setRound(int round) {
        this.round = round;
    }

    /**
     * @return the currentBet
     */
    public int getCurrentBet() {
        return currentBet;
    }

    /**
     * @param currentBet the currentBet to set
     */
    public void setCurrentBet(int currentBet) {
        this.currentBet = currentBet;
    }

    public int getPrevBet() {
        return prevBet;
    }

    public void setPrevBet(int prevBet) {
        this.prevBet = prevBet;
    }
}
