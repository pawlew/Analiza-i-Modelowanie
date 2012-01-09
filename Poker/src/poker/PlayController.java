/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author siesiek
 */
public class PlayController {

    public static final int CALL = 0;
    public static final int RAISE = 1;
    public static final int BET = 2;
    public static final int CHECK = 3;
    public static final int FOLD = 4;
    public static final int LEAVE = 5;
//    private int[] action = new int[2];
    private GameDialog dialog;
    private Table table;

    public PlayController(GameDialog dialog) {
        this.dialog = dialog;
    }

//    public int[] getAction(Table t) {
////        addInfo("Twoja kolej!");
//////        aktualny stan rozgrywki
//        this.table = t;
////        addInfo("Runda "+table.getRound());
////        clearHand();
////        for(Card c : table.Players.get(0).hand){
////            addHandCard(c);
////        }
////        switch (table.getRound()) {
////            case 0:
////                clearTableCards();
//////                                System.out.println("None");
////                break;
////            case 1:
////                clearTableCards();
////                addTableCard(table.CommCards.get(0));
////                addTableCard(table.CommCards.get(1));
////                addTableCard(table.CommCards.get(2));
////                                System.out.println(table.CommCards.get(0) + "  " + table.CommCards.get(1)
////                                        + "  " + table.CommCards.get(2));
////                break;
////            case 2:
////                clearTableCards();
////                addTableCard(table.CommCards.get(0));
////                addTableCard(table.CommCards.get(1));
////                addTableCard(table.CommCards.get(2));
////                addTableCard(table.CommCards.get(3));
////
//////                                System.out.println(table.CommCards.get(0) + "  " + table.CommCards.get(1)
//////                                        + "  " + table.CommCards.get(2) + "  " + table.CommCards.get(3));
////                break;
////            case 3:
////                clearTableCards();
////                for (Card c : table.CommCards) {
////                    addTableCard(c);
////                }
////                break;
////            case 4:
////                clearTableCards();
////                for (Card c : table.CommCards) {
////                    addTableCard(c);
////                }
////                break;
////        }
////        
//////        action[0] = -1;
////        
//////        while (true) {
//            
////////            System.out.println("");
//////            if (this.action[0] != -1) {
////////                addInfo("koniec czekania na odpowiedz");
//////                break;
//////            }
//////        }
//
//        return action;
//    }
    public int[] getAction(Table table) {
        Player player = table.Players.get(0);
        int action[] = new int[2];
        int action2 = showTurnDialog();
        switch (action2) {
            case CALL:
//                sprawdzam
                if (table.getCurrentBet() == 0) {
                    addInfo("Musisz najpierw postawić zakład");
                    action[0] = -1;
                } else {
                    if (table.getCurrentBet() >= player.getChips()) {
                        addInfo("Stawiasz wszystko!!!");
                        action[0] = 0;
                        action[1] = player.getChips();
                        player.setAllIn(true);
                    }
                    if (table.getCurrentBet() < player.getChips()) {
                        action[0] = 0;
                        action[1] = table.getCurrentBet() - player.getLastBetAmt();
                        player.setLastBetAmt(table.getCurrentBet());
                        addInfo("Gracz " + player.getPlayerName() + " sprawdził");
                    }
                }
                break;
            case RAISE:
//                podbijam
                if (table.getCurrentBet() == 0) {
                    addInfo("Musisz najpierw postawić zakład");
                    action[0] = -1;
                } else {
//                    wyswietlenie okna dialogowego z zapytanie o zaklad
                    String raise = JOptionPane.showInputDialog("Aktualny zakład jest równy: " + table.getCurrentBet() + "\nMinimalny nowy zakład: " + table.getCurrentBet());
                    if (Integer.valueOf(raise) < table.getCurrentBet()) {
                        addInfo("Zbyt mały zakład!");
                    }
                    if (Integer.valueOf(raise) + (table.getCurrentBet() - player.getLastBetAmt()) < player.getChips()) {
                        action[0] = 1;
                        action[1] = (table.getCurrentBet() - player.getLastBetAmt()) + Integer.valueOf(raise);
                        player.setLastBetAmt(Integer.valueOf(raise));
                        table.setCurrentBet(table.getCurrentBet() + Integer.valueOf(raise));
                        addInfo("Gracz " + player.getPlayerName() + " podbił zakład o " + raise);
                    }
                    if (Integer.valueOf(raise) + (table.getCurrentBet() - player.getLastBetAmt()) >= player.getChips()) {
                        action[0] = 1;
                        action[1] = player.getChips();
                        player.setLastBetAmt(player.getChips());
                        player.setAllIn(true);
                        addInfo("Gracz " + player.getPlayerName() + " podbił zakład o " + player.getChips());
//                        gdzies tu moze czaic sie blad
                    }
                }
                break;
            case BET:
//                zaklad
                if (table.getCurrentBet() != 0) {
                    addInfo("Zakład jest już ustawiony. Kliknij \"Podbijam\", aby podbić zakład");
                    action[0] = -1;
                } else {
                    String bet = JOptionPane.showInputDialog("Jaki zakład postawisz? Minimalna stawka to 2");
                    if (player.getChips() >= 2) {
                        if (Integer.valueOf(bet) < 2) {
                            addInfo("Za mała stawka!");
                            action[0] = -1;
                        }
//                        addInfo("dziura");
                    }
                    if (Integer.valueOf(bet) < 2) {
                        addInfo("Za mała stawka!");
                        action[0] = -1;
                    } else if (player.getChips() <= Integer.valueOf(bet)) {
                        addInfo("Stawiasz wszystko!!!");
                        action[0] = 2;
                        action[1] = player.getChips();
                        table.setCurrentBet(action[1]);
                        player.setLastBetAmt(action[1]);
                        player.setAllIn(true);
                        addInfo("Gracz " + player.getPlayerName() + "postawił wszystko na zakład");
                    } else {
                        action[0] = 2;
                        action[1] = Integer.valueOf(bet);
                        table.setCurrentBet(Integer.valueOf(bet));
                        addInfo("Gracz " + player.getPlayerName() + " postawił zakład w wysokości: " + bet);
                    }
                }
                break;
            case CHECK:
//                czekam
                if (table.getCurrentBet() > 0) {
                    addInfo("Nie możesz czekać!");
                    action[0] = -1;
                } else {
                    addInfo("Gracz " + player.getPlayerName() + " czeka.");
                    action[0] = 3;
                }
                break;
            case FOLD:
//                pas
                addInfo("Gracz " + player.getPlayerName() + " pasuje");
                action[0] = 4;
                action[1] = 0;
                break;
            case LEAVE:
//                odchodze
                addInfo("Gracz " + player.getPlayerName() + " odchodzi od stołu");
                action[0] = 5;
                break;
        }
//        addInfo("Control");
        dialog.chipsLabel.setText(String.valueOf(player.getChips()));
        dialog.potLabel.setText(String.valueOf(table.getPot()));
        return action;
    }

    public int showTurnDialog() {
        Object[] values = {"Sprawdzam", "Podbijam", "Czekam", "Pas", "Stawiam zakład", "Odchodzę"};
        String decision = (String) JOptionPane.showInputDialog(null, "Co chcesz teraz zrobić?", "Twój ruch", JOptionPane.QUESTION_MESSAGE, null, values, null);
        if (decision == null) {
            return -1;
        }
        if (decision.equalsIgnoreCase("sprawdzam")) {
            return CALL;
        }
        if (decision.equalsIgnoreCase("podbijam")) {
            return RAISE;
        }
        if (decision.equalsIgnoreCase("czekam")) {
            return CHECK;
        }
        if (decision.equalsIgnoreCase("pas")) {
            return FOLD;
        }
        if (decision.equalsIgnoreCase("stawiam zakład")) {
            return BET;
        }
        if (decision.equalsIgnoreCase("odchodzę")) {
            return LEAVE;
        }
        return -1;
    }
//    public void setAction(int action) {
//        Player player = table.Players.get(0);
//        switch (action) {
//            case CALL:
////                sprawdzam
//                if (table.getCurrentBet() == 0) {
//                    addInfo("Musisz najpierw postawić zakład");
//                    this.action[0] = -1;
//                } else {
//                    if (table.getCurrentBet() >= player.getChips()) {
//                        addInfo("Stawiasz wszystko!!!");
//                        this.action[0] = 0;
//                        this.action[1] = player.getChips();
//                        player.setAllIn(true);
//                    }
//                    if (table.getCurrentBet() < player.getChips()) {
//                        this.action[0] = 0;
//                        this.action[1] = table.getCurrentBet() - player.getLastBetAmt();
//                        player.setLastBetAmt(table.getCurrentBet());
//                        addInfo("Gracz " + player.getPlayerName() + " sprawdził");
//                    }
//                }
//                break;
//            case RAISE:
////                podbijam
//                if (table.getCurrentBet() == 0) {
//                    addInfo("Musisz najpierw postawić zakład");
//                    this.action[0] = -1;
//                } else {
////                    wyswietlenie okna dialogowego z zapytanie o zaklad
//                    String raise = JOptionPane.showInputDialog("Aktualny zakład jest równy: " + table.getCurrentBet() + "\nMinimalny nowy zakład: " + table.getCurrentBet());
//                    if (Integer.valueOf(raise) < table.getCurrentBet()) {
//                        addInfo("Zbyt mały zakład!");
//                    }
//                    if (Integer.valueOf(raise) + (table.getCurrentBet() - player.getLastBetAmt()) < player.getChips()) {
//                        this.action[0] = 1;
//                        this.action[1] = (table.getCurrentBet() - player.getLastBetAmt()) + Integer.valueOf(raise);
//                        player.setLastBetAmt(Integer.valueOf(raise));
//                        table.setCurrentBet(table.getCurrentBet() + Integer.valueOf(raise));
//                        addInfo("Gracz " + player.getPlayerName() + " podbił zakład o " + raise);
//                    }
//                    if (Integer.valueOf(raise) + (table.getCurrentBet() - player.getLastBetAmt()) >= player.getChips()) {
//                        this.action[0] = 1;
//                        this.action[1] = player.getChips();
//                        player.setLastBetAmt(player.getChips());
//                        player.setAllIn(true);
//                        addInfo("Gracz " + player.getPlayerName() + " podbił zakład o " + player.getChips());
////                        gdzies tu moze czaic sie blad
//                    }
//                }
//                break;
//            case BET:
////                zaklad
//                if (table.getCurrentBet() != 0) {
//                    addInfo("Zakład jest już ustawiony. Kliknij \"Podbijam\", aby podbić zakład");
//                    this.action[0] = -1;
//                } else {
//                    String bet = JOptionPane.showInputDialog("Jaki zakład postawisz? Minimalna stawka to 2");
//                    if (player.getChips() >= 2) {
//                        if (Integer.valueOf(bet) < 2) {
//                            addInfo("Za mała stawka!");
//                            this.action[0] = -1;
//                        }
////                        addInfo("dziura");
//                    }
//                    if (Integer.valueOf(bet) < 2) {
//                        addInfo("Za mała stawka!");
//                        this.action[0] = -1;
//                    } else if (player.getChips() <= Integer.valueOf(bet)) {
//                        addInfo("Stawiasz wszystko!!!");
//                        this.action[0] = 2;
//                        this.action[1] = player.getChips();
//                        table.setCurrentBet(this.action[1]);
//                        player.setLastBetAmt(this.action[1]);
//                        player.setAllIn(true);
//                        addInfo("Gracz " + player.getPlayerName() + "postawił wszystko na zakład");
//                    } else {
//                        this.action[0] = 2;
//                        this.action[1] = Integer.valueOf(bet);
//                        table.setCurrentBet(Integer.valueOf(bet));
//                        addInfo("Gracz " + player.getPlayerName() + " postawił zakład w wysokości: " + bet);
//                    }
//                }
//                break;
//            case CHECK:
////                czekam
//                if (table.getCurrentBet() > 0) {
//                    addInfo("Nie możesz czekać!");
//                    this.action[0] = -1;
//                } else {
//                    addInfo("Gracz " + player.getPlayerName() + " czeka.");
//                    this.action[0] = 3;
//                }
//                break;
//            case FOLD:
////                pas
//                addInfo("Gracz " + player.getPlayerName() + " pasuje");
//                this.action[0] = 4;
//                this.action[1] = 0;
//                break;
//            case LEAVE:
////                odchodze
//                addInfo("Gracz " + player.getPlayerName() + " odchodzi od stołu");
//                this.action[0] = 5;
//                break;
//        }
////        addInfo("Control");
//        dialog.chipsLabel.setText(String.valueOf(player.getChips()));
//        dialog.potLabel.setText(String.valueOf(table.getPot()));
//    }

    public void addInfo(String info) {
        ((DefaultListModel) dialog.infoList.getModel()).add(0, info);
        System.out.println(info);
    }

    public void addTableCard(Card card) {
        dialog.tablePanel.add(new CardLabel(card.toString()));
    }

    public void clearTableCards() {
        dialog.tablePanel.removeAll();
    }

    public void addHandCard(Card card) {
        dialog.handPanel.add(new CardLabel(card.toString()));
    }

    public void clearHand() {
        dialog.handPanel.removeAll();
    }

    public void setPot(int pot) {
        dialog.potLabel.setText(String.valueOf(pot));
    }

    public void clearInfo() {
        ((DefaultListModel) dialog.infoList.getModel()).clear();
    }

    public void updateState(Table t) {
        this.table = t;
//        addInfo("Runda "+table.getRound());
        switch (table.getRound()) {
            case 0:
                clearTableCards();
//                addInfo("Przed Flopem");
                dialog.roundLabel.setText("Przed Flopem");
//                                System.out.println("None");
                break;
            case 1:
                clearTableCards();
                addTableCard(table.CommCards.get(0));
                addTableCard(table.CommCards.get(1));
                addTableCard(table.CommCards.get(2));
                System.out.println(table.CommCards.get(0) + "  " + table.CommCards.get(1)
                        + "  " + table.CommCards.get(2));
//                                addInfo("Flop");
                dialog.roundLabel.setText("Flop");
                break;
            case 2:
                clearTableCards();
                addTableCard(table.CommCards.get(0));
                addTableCard(table.CommCards.get(1));
                addTableCard(table.CommCards.get(2));
                addTableCard(table.CommCards.get(3));

                System.out.println(table.CommCards.get(0) + "  " + table.CommCards.get(1)
                        + "  " + table.CommCards.get(2) + "  " + table.CommCards.get(3));
//                                addInfo("Turn");
                dialog.roundLabel.setText("Turn");
                break;
            case 3:
                clearTableCards();
                for (Card c : table.CommCards) {
                    addTableCard(c);
                    System.out.print(c + " ");
                }
                System.out.println();
//                addInfo("River");
                dialog.roundLabel.setText("River");
                break;
            case 4:
                clearTableCards();
                for (Card c : table.CommCards) {
                    addTableCard(c);
                    System.out.print(c + " ");
                }
                System.out.println();
//                addInfo("Showdown");
                dialog.roundLabel.setText("Showdown");
                break;
        }
        dialog.potLabel.setText("" + table.getPot());
        dialog.chipsLabel.setText("" + table.Players.get(0).getChips());
        dialog.betLabel.setText("" + table.getCurrentBet());
//        addInfo("Dane zaktualizowano");
    }
}
