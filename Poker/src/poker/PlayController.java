/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.Scanner;

/**
 *
 * @author siesiek
 */
public class PlayController {

    private int[] action;

    public int[] getAction(Table t, int pNum) {
        action[0] = -1;

        Scanner po = new Scanner(System.in);
        final String choices[] = {"call", "c", "fold", "f", "raise", "r", 
				"check", "ck", "chipcount", "-cc", "help", "-h", "quit", "-q", 
				"bet", "b", "rules", "-rl"};
        String i = po.next().toLowerCase();
        if (i.equalsIgnoreCase("rules") || i.equalsIgnoreCase("-rl")) {
            String helpText = "You have several options.\n"
                    + "In Texas Hold'em, players are always faced with the ability to choose\n"
                    + "one of three options:\n"
                    + "Check (or call).\n"
                    + "Bet (or raise).\n"
                    + "Fold.\n"
                    + "To call is simply to match the previous bet made (a check is the same\n"
                    + "thing, only when no bet has been made: in other words, a check is a \n"
                    + "call for free).\n"
                    + "To fold is to throw away your hand and wait until the next deal to \n"
                    + "play again. Folding is always free.\n"
                    + "If there has been no bet made yet, you have the option to bet. \n"
                    + "Once a bet is made, players to follow now have the option to raise \n"
                    + "the bet.\n"
                    + "In No-Limit a minimum bet is equal to the size of the big blind, \n"
                    + "while a maximum bet is the total amount of all of your chips. \n"
                    + "Once a bet has been made, the minimum you can raise is the size of the\n"
                    + "last bet. So if your opponent bets $5, the minimum raise you can make \n"
                    + "is $5 (for a total bet of $10). Again, the maximum raise is the total \n"
                    + "of whatever you have in front of you.\n";
            System.out.print(helpText);

            // Array returns negative first value, telling the while loop in
            // TestRunner that an actual decision hasn't been made yet.
            action[0] = -1;
            action[1] = 0;
            return action;

            // *** HELP ***
        } else if (i.equalsIgnoreCase("-h") || i.equalsIgnoreCase("help")) {
            System.out.println("The input must"
                    + " be one of these options:");
            for (String choice : choices) {
                System.out.print(choice + " ");
            }
            System.out.println("\nPlease input an option; '-h' or 'help' for"
                    + "help; 'q' or 'quit' to quit; or 'rules' to learn about to bet.");
            // Array returns negative first value, telling the while loop in
            // TestRunner that an actual decision hasn't been made yet.
            action[0] = -1;
            action[1] = 0;
            return action;

            // *** FOLD ***
        } else if (i.equalsIgnoreCase("f") || i.equalsIgnoreCase("fold")) {
            t.setsActions(t.getsActions() + "Player " + (pNum + 1) + " ("
                    + t.Players.get(pNum).getPlayerName() + ") Folded\n");
            action[0] = 4;
            action[1] = 0;
            return action;

            // *** CALL ***
        } else if (i.equalsIgnoreCase("c") || i.equalsIgnoreCase("call")) {
            // If the bet is zero, we send a "check" signal to the program,
            // Since a "call" on a zero bet is really a check.
            // We also remind the user of their error.
            if (t.getCurrentBet() == 0) {
                System.out.println("Where did you learn how to play poker, "
                        + "fool?\n  A call on a zero bet is a 'check'!\n"
                        + "Get it right next time!");
                t.setsActions(t.getsActions() + "Player " + (pNum + 1) + " ("
                        + t.Players.get(pNum).getPlayerName() + ") Checked\n");
                action[0] = 3;
                action[1] = 0;
                return action;
            }
            // If you call and the bet is more than (or equal to) your chips.
            // you're 'all in'.
            if (t.getCurrentBet() >= t.Players.get(pNum).getChips()) {
                System.out.println("ALL IN!");
                action[0] = 0;
                action[1] = t.Players.get(pNum).getChips();
                t.Players.get(pNum).setAllIn(true);
                t.setsActions(t.getsActions() + "Player " + (pNum + 1) + " ("
                        + t.Players.get(pNum).getPlayerName() + ") Called "
                        + "and is ALL IN!\n");
                return action;
            }
            // If player has enough chips to call, allow the player to call.
            if (t.getCurrentBet() < t.Players.get(pNum).getChips()) {
                action[0] = 0;
                // Bet amount is current bet minus what the player has already
                // put into the pot.
                action[1] = t.getCurrentBet()
                        - t.Players.get(pNum).getLastBetAmt();
                t.Players.get(pNum).setLastBetAmt(t.getCurrentBet());
                t.setsActions(t.getsActions() + "Player " + (pNum + 1) + " ("
                        + t.Players.get(pNum).getPlayerName() + ") Called\n");
                return action;
            }
            // If none of these "call" conditions are met, put out an Error
            // message and try again.
            System.out.print("'Call' Invalid! What's the deal?");
            // Array returns negative first value, telling the while loop in
            // TestRunner that an actual decision hasn't been made yet.
            action[0] = -1;
            action[1] = 0;
            return action;


            // *** RAISE ***
        } else if (i.equalsIgnoreCase("r") || i.equalsIgnoreCase("raise")) {
            if (t.getCurrentBet() == 0) {
                System.out.println("Current bet is zero!  Use 'bet' instead!");
                // Array returns negative first value, telling the while loop in
                // TestRunner that an actual decision hasn't been made yet.
                action[0] = -1;
                action[1] = 0;
                return action;
            }
            System.out.println("The Current Bet is: $" + t.getCurrentBet());
            System.out.println("The minimum amount to raise is: $"
                    + (t.getCurrentBet()));
            System.out.print("How much would you like to raise? :");
            Scanner raiseGetter = new Scanner(System.in);
            int rAmt;
            try {
                rAmt = raiseGetter.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.print("Invalid input! Fat fingers!");
                // Array returns negative first value, telling the while loop in
                // TestRunner that an actual decision hasn't been made yet.
                action[0] = -1;
                action[1] = 0;
                raiseGetter.nextLine();
                return action;
            }

            // If the raise is less than the current bet, it's no good!

            if (rAmt < t.getCurrentBet()) {
                System.out.println("Invalid amount!  You must raise by at "
                        + "least $" + t.getCurrentBet());
                // Array returns negative first value, telling the while loop in
                // TestRunner that an actual decision hasn't been made yet.
                action[0] = -1;
                action[1] = 0;
                raiseGetter.nextLine();
                return action;
            }

            // If the total bet (current bet plus raise) is less than the 
            // total chips the player has, allow the bet and indicate the 
            // action in the actions list on the console.

            if ((rAmt + (t.getCurrentBet()
                    - t.Players.get(pNum).getLastBetAmt()))
                    < t.Players.get(pNum).getChips()) {
                action[0] = 1;
                action[1] = (t.getCurrentBet()
                        - t.Players.get(pNum).getLastBetAmt()) + rAmt;
                t.Players.get(pNum).setLastBetAmt(rAmt);
                t.setCurrentBet(t.getCurrentBet() + rAmt);
                t.setsActions(t.getsActions() + "Player " + (pNum + 1)
                        + " (" + t.Players.get(pNum).getPlayerName()
                        + ") Raised by: " + rAmt + "\n");
                raiseGetter.nextLine();
                return action;
            }

            // If raise is MORE than (or equal to) what the player has left,
            // go "All in".

            if ((rAmt + (t.getCurrentBet()
                    - t.Players.get(pNum).getLastBetAmt()))
                    >= t.Players.get(pNum).getChips()) {
                action[0] = 1;
                action[1] = t.Players.get(pNum).getChips();
                t.Players.get(pNum).setLastBetAmt(t.Players.get(pNum).getChips());
                t.setCurrentBet(t.Players.get(pNum).getChips());
                t.Players.get(pNum).setAllIn(true);
                t.setsActions(t.getsActions() + "Player " + (pNum + 1)
                        + " (" + t.Players.get(pNum).getPlayerName()
                        + ") is ALL IN! Raised by: "
                        + t.Players.get(pNum).getChips() + "\n");
                raiseGetter.nextLine();
                return action;
            }

            // If none of these "raise" conditions are met, put out an Error
            // message and try again.
            System.out.print("Bet Invalid! What's the deal?");
            // Array returns negative first value, telling the while loop in
            // TestRunner that an actual decision hasn't been made yet.
            action[0] = -1;
            action[1] = 0;
            raiseGetter.nextLine();
            return action;


            // *** CHECK ***
        } else if (i.equalsIgnoreCase("ck") || i.equalsIgnoreCase("check")) {

            // Verify that a bet hasn't already been made before
            // allowing the player to check here.

            if (t.getCurrentBet() > 0) {
                // If there is a current bet, "check" is not allowed.
                // It will indicate the error message, and make the user
                // choose again (through a negative int value).
                System.out.println("Can't check! Bet is: " + t.getCurrentBet());
                action[0] = -1;
                action[1] = 0;
                return action;
            }
            t.setsActions(t.getsActions() + "Player " + (pNum + 1) + " ("
                    + t.Players.get(pNum).getPlayerName() + ") Checked\n");
            action[0] = 3;
            action[1] = 0;
            return action;

            // *** BET ***
        } else if (i.equalsIgnoreCase("b") || i.equalsIgnoreCase("bet")) {
            // Bet-specific stuff goes here.

            // If there is already a bet on the table, "raise" should be used
            // to increase the pot, not "bet".
            if (t.getCurrentBet() != 0) {
                System.out.println("There is a current bet already!\n"
                        + "It is :$" + t.getCurrentBet() + ".  Use 'raise'"
                        + " to increase the bet!");
                action[0] = -1;
                action[1] = 0;
                return action;
            }

            System.out.println("The minimum amount to bet is: $2");

            System.out.print("How much would you like to bet? :");
            Scanner betGetter = new Scanner(System.in);
            int bAmt;
            try {
                bAmt = betGetter.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input! Fat fingers!");
                // Array returns negative first value, telling the while loop in
                // TestRunner that an actual decision hasn't been made yet.
                action[0] = -1;
                action[1] = 0;
                betGetter.nextLine();
                return action;
            }
            //Logic for verifying bets here.


            if (t.Players.get(pNum).getChips() >= 2) {
                // Verifying initial bet is at least 2. (Equal to big blind).
                // Only performing this check if the player has at least 2 
                // dollars.  If you only have a dollar and want to bet it,
                // then go nuts.
                if (bAmt < 2) {
                    System.out.println("Invalid amount! Bet 2 or more!");
                    // Array returns negative first value, telling the loop in
                    // TestRunner that an actual decision hasn't been made yet.
                    action[0] = -1;
                    action[1] = 0;
                    betGetter.nextLine();
                    return action;
                }
            }
            if (bAmt < 1) {
                System.out.println("Invalid amount! Bet your last dollar!");
                System.out.println("Come on, I dare you!");
                // Array returns negative first value, telling the loop in
                // TestRunner that an actual decision hasn't been made yet.
                action[0] = -1;
                action[1] = 0;
                betGetter.nextLine();
                return action;
            }

            if (t.Players.get(pNum).getChips() <= bAmt) {
                System.out.println("ALL IN!");
                // If you entered more chips than you have, you're all in
                // for the amount that you DO have.
                action[0] = 2;
                action[1] = t.Players.get(pNum).getChips();
                t.setCurrentBet(action[1]);
                t.Players.get(pNum).setLastBetAmt(action[1]);
                t.Players.get(pNum).setAllIn(true);
                t.setsActions(t.getsActions() + "Player " + (pNum + 1) + " ("
                        + t.Players.get(pNum).getPlayerName() + ") Bets $"
                        + t.Players.get(pNum).getChips() + " and is ALL IN!\n");
                betGetter.nextLine();
                return action;
            }
            action[0] = 2;
            action[1] = bAmt;
            betGetter.nextLine();
            t.setCurrentBet(action[1]);
            t.setsActions(t.getsActions() + "Player " + (pNum + 1) + " ("
                    + t.Players.get(pNum).getPlayerName() + ") Bets $" + bAmt
                    + "\n");
            return action;

            // *** CHIP COUNT ***
        } else if (i.equalsIgnoreCase("-cc") || i.equalsIgnoreCase("chipcount")) {
            // Chip count functionality entered by Jake.

            System.out.println("\nPlayer Chip Counts:");
            for (Player p : t.Players) {
                if (p.isOut() == false) {
                    System.out.println("\tPlayer " + (p.getPlayerNum() + 1) + ": "
                            + p.getPlayerName() + " has $" + p.getChips());
                }
            }
            action[0] = -1;
            action[1] = 0;
            return action;

            // *** ERROR ***
        } else {
            System.out.print("Error?");
            // Array returns negative first value, telling the while loop in
            // TestRunner that an actual decision hasn't been made yet.
            action[0] = -1;
            action[1] = 0;
            return action;
        }

//        return action;
    }

    public void setAction(int[] action) {
        this.action = action;
    }
}
