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
public class Player {

    private int playerNum;
    private String playerName;
    private boolean actionReq = true;
    private boolean folded = false;
    public ArrayList<Card> hand = new ArrayList<Card>();
    private int chips = 1000;
    private boolean isHuman;
    private boolean isOut = false;
    private int handRank = 0;
    private int highCard;
    private int lastBetAmt = 0;
    private boolean allIn = false;

    public boolean isAllIn() {
        return allIn;
    }

    public void setAllIn(boolean allIn) {
        this.allIn = allIn;
    }

    public Player(int num, String name, boolean human) {
        playerNum = num;
        playerName = name;
        isHuman = human;
    }

    void giveCard(Card card) {
        hand.add(card);
    }

    void takeCards() {
        hand.clear();
    }

    void actionFold() {
        folded = true;
    }

    void resetFoldFlag() {
        folded = false;
    }

    int actionCall(int currentBet) {
        chips = chips - currentBet;
        return currentBet;
    }

    void addToChips(int pot) {
        chips = chips + pot;
    }

    void takeFromChips(int bet) {
        chips = chips - bet;
    }

    int bigBlind() {
        chips = chips - 2;
        return 2;
    }

    int smallBlind() {
        chips = chips - 1;
        return 1;
    }

    /**
     * @return the playerNum
     */
    public int getPlayerNum() {
        return playerNum;
    }

    /**
     * @param playerNum the playerNum to set
     */
    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }

    /**
     * @return the playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @param playerName the playerName to set
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * @return the actionReq
     */
    public boolean isActionReq() {
        return actionReq;
    }

    /**
     * @param actionReq the actionReq to set
     */
    public void setActionReq(boolean actionReq) {
        this.actionReq = actionReq;
    }

    /**
     * @return the folded
     */
    public boolean isFolded() {
        return folded;
    }

    /**
     * @param folded the folded to set
     */
    public void setFolded(boolean folded) {
        this.folded = folded;
    }

    /**
     * @return the chips
     */
    public int getChips() {
        return chips;
    }

    /**
     * @param chips the chips to set
     */
    public void setChips(int chips) {
        this.chips = chips;
    }

    /**
     * @return the isHuman
     */
    public boolean isHuman() {
        return isHuman;
    }

    /**
     * @param isHuman the isHuman to set
     */
    public void setHuman(boolean isHuman) {
        this.isHuman = isHuman;
    }

    /**
     * @return the isOut
     */
    public boolean isOut() {
        return isOut;
    }

    /**
     * @param isOut the isOut to set
     */
    public void setOut(boolean isOut) {
        this.isOut = isOut;
    }

    /**
     * @return the handRank
     */
    public int getHandRank() {
        return handRank;
    }

    /**
     * @param handRank the handRank to set
     */
    public void setHandRank(int handRank) {
        this.handRank = handRank;
    }

    /**
     * @return the highCard
     */
    public int getHighCard() {
        return highCard;
    }

    /**
     * @param highCard the highCard to set
     */
    public void setHighCard(int highCard) {
        this.highCard = highCard;
    }

    public int getLastBetAmt() {
        return lastBetAmt;
    }

    public void setLastBetAmt(int lastBetAmt) {
        this.lastBetAmt = lastBetAmt;
    }
}
