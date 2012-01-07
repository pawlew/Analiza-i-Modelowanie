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
public class PlayerAI {

    public static int[] PlayerAI1(int playerPos, Analyzer myAnalyzer, Table myTable) {

        int currentHandRank = 0;
        int[] playerAction = new int[2];
        playerAction[0] = 0;
        playerAction[1] = 0;

        /*
         * //Player Round 0 - Hold 1 - Flop 2 - Turn 3 - River
         */

        int tableStatus = myTable.getRound();
        int currBet = myTable.getCurrentBet();
        int myChips = myTable.Players.get(playerPos).getChips();

        switch (tableStatus) {
            case 0:
                playerAction = preFlop(playerPos, myTable.Players.get(playerPos).hand, currBet);
                break;
            case 1:
                currentHandRank = myAnalyzer.getFlopRank(playerPos);
                playerAction = postFlop(currentHandRank, currBet);
                break;
            case 2:
                currentHandRank = myAnalyzer.getTurnRank(playerPos);
                playerAction = postFlop(currentHandRank, currBet);
                break;
            case 3:
                currentHandRank = myAnalyzer.getRiverRank(playerPos);
                playerAction = postFlop(currentHandRank, currBet);
                break;
            default:
                currentHandRank = myAnalyzer.getRiverRank(playerPos);
                playerAction = postFlop(currentHandRank, currBet);
                break;
        }

        //This is the code to check to see if the AI is calling on a zero dollar amount
        if (currBet == 0 && playerAction[0] == 0) {
            playerAction[0] = 3;
            playerAction[1] = 0;
        }

        //check to see if the AI is Raising zero on a betting round 
        if (currBet != 0 && playerAction[0] == 1) {
            playerAction[0] = 1;
            playerAction[1] = currBet * 2;
        }
        //Bet if the current raise is zero
        if (currBet == 0 && playerAction[0] == 1) {
            playerAction[0] = 2;
            playerAction[1] = 2;
        }

        //All in buddy!!
        if (playerAction[1] >= myChips) {
            playerAction[1] = myChips;
            myTable.Players.get(playerPos).setAllIn(true);
        }
        return playerAction;
    }

    /*
     * 0 - No hand 1 - Pair 2 - Two pair 3 - Three of a kind 4 - Straight 5 -
     * Flush 6 - Full house 7 - Four of a kind 8 - Straight Flush 9 - Royal
     * Flush
     *
     * Select an action to play based on the rank of the current cards. Action
     * is returned by a number: 4 = Fold 0 = Call 1 = Raise 3 = Check 2 = bet
     */
    // Pre-Flop
    public static int[] preFlop(int pos, ArrayList<Card> hand, int currBet) {
        int[] playerAction = new int[2];

        String suite1 = hand.get(0).toString().substring(1, 2);
        String fCard1 = hand.get(0).toString().substring(0, 1);
        String suite2 = hand.get(1).toString().substring(1, 2);
        String fCard2 = hand.get(1).toString().substring(0, 1);

        int card1 = 0;
        if (fCard1.contains("A")) {
            card1 = 14;
        } else if (fCard1.contains("K")) {
            card1 = 13;
        } else if (fCard1.contains("Q")) {
            card1 = 12;
        } else if (fCard1.contains("J")) {
            card1 = 11;
        } else {
            card1 = Integer.parseInt(fCard1);
        }

        int card2 = 0;
        if (fCard2.contains("A")) {
            card2 = 14;
        } else if (fCard2.contains("K")) {
            card2 = 13;
        } else if (fCard2.contains("Q")) {
            card2 = 12;
        } else if (fCard2.contains("J")) {
            card2 = 11;
        } else {
            card2 = Integer.parseInt(fCard2);
        }

        //Any pair above 6 suited or other wise, RAISE!!
        if (card1 == card2 && card1 > 6) {
            playerAction[0] = 1;
            playerAction[1] = currBet;
            return playerAction;
        }
        if (card1 == card2 && card1 <= 6 && pos <= 5) {
            //System.out.println("In the top 5 seats with any pair less than 6 suited or other wise, CALL!!\n");
            playerAction[0] = 0;
            playerAction[1] = currBet;
            return playerAction;
        }
        //9 through Ace suited, RAISE!!
        if (((card1 >= 9 && card1 <= 14) && (card2 >= 9 && card2 <= 14))
                && suite1 == suite2) {
            playerAction[0] = 1;
            playerAction[1] = currBet;
            return playerAction;
        }
        //Queen through Ace non suited, CALL/CHECK!
        if (((card1 >= 12 && card1 <= 14) && (card2 >= 12 && card2 <= 14))
                && suite1 != suite2) {
            playerAction[0] = 0;
            playerAction[1] = currBet;
            return playerAction;
        }
        //Any cards above 10 suited or other wise, CALL/CHECK!
        if (card1 > 10 && card2 > 10) {
            playerAction[0] = 1;
            playerAction[1] = currBet;
            return playerAction;
        }
        //Cards connected by one non suited, CALL/CHECK!
        if ((card1 - card2 == 1 || card2 - card1 == 1)
                && suite1 != suite2) {
            playerAction[0] = 0;
            playerAction[1] = currBet;
            return playerAction;
        }
        //Nothing in hand, FOLD!
        playerAction[0] = 4;
        playerAction[1] = 0;
        return playerAction;
    }

    // Post-Flop
    public static int[] postFlop(int currentHandRank, int currBet) {
        int[] playerAction = new int[2];

        switch (currentHandRank) {
            case 0: //No hand, Fold!
                playerAction[0] = 4;
                playerAction[1] = 0;
                break;
            case 1: //Pair, Call/Check!
                playerAction[0] = 0;
                playerAction[1] = currBet;
                break;
            case 2: //Two pair, Call/Check!
                playerAction[0] = 0;
                playerAction[1] = currBet;
                break;
            case 3: //Three of a kind, Call/Check!
                playerAction[0] = 0;
                playerAction[1] = currBet;
                break;
            case 4: //Straight, Call/Check!
                playerAction[0] = 0;
                playerAction[1] = currBet;
                break;
            case 5: //Flush, Raise!
                playerAction[0] = 1;
                playerAction[1] = currBet;
                break;
            case 6: //Full house, Raise!
                playerAction[0] = 1;
                playerAction[1] = currBet;
                break;
            case 7: //Four of a kind, Raise!
                playerAction[0] = 1;
                playerAction[1] = currBet;
                break;
            case 8: //Straight Flush, Raise!
                playerAction[0] = 1;
                playerAction[1] = currBet;
                break;
            case 9: //Royal Flush, Raise!
                playerAction[0] = 1;
                playerAction[1] = currBet;
                break;
            default: //Fold!
                playerAction[0] = 4;
                playerAction[1] = 0;
                break;
        }
        return playerAction;
    }
}
