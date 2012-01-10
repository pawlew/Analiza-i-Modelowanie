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
public class Game {

    private Player player;
    private int playersCount;
    private PlayController controller;
    private int games = 0;
    private int victory = 0;

    public Game(Player player, int playersCount, PlayController controller) {
        this.player = player;
        this.playersCount = playersCount;
        this.controller = controller;
    }

    public int getGames() {
        return games;
    }

    public int getVictory() {
        return victory;
    }
    
    public void play() {
        Table table = new Table();
        table.Players.add(player);
        for (int i = 1; i < playersCount; i++) {
            table.Players.add(new Player(i, "Komp " + i, false));
        }
        table.setGameStatus(true);

        while (table.isGameStatus()) {
            games++;
            controller.addInfo("Nowe rozdanie");
            controller.clearTableCards();
            controller.clearHand();
            table.setPot(0);
            table.setPlayerActionsReq(playersCount - 1);
            table.setDealer(table.nextDealer());
            controller.addInfo("Rozdaje gracz "+table.Players.get(table.getDealer()).getPlayerName());
            for (Player p : table.Players) {
                if (!p.isOut()) {
                    p.setActionReq(true);
                }
                p.hand.clear();
            }

            Analyzer analyzer = new Analyzer();
            Deck deck = new Deck();
            deck.shuffle();
            table.addToPot(table.Players.get(table.getSmall()).smallBlind());
            table.addToPot(table.Players.get(table.getBig()).bigBlind());
            controller.addInfo("Gracz "+table.Players.get(table.getSmall()).getPlayerName() + " wyłożył małą ciemną");
            controller.addInfo("Mała ciemna: "+table.Players.get(table.getSmall()).smallBlind()+" żeton");
            controller.addInfo("Gracz "+table.Players.get(table.getBig()).getPlayerName() + " wyłożył dużą ciemną");
            controller.addInfo("Duża ciemna: "+table.Players.get(table.getBig()).bigBlind()+" żetony");
            table.Players.get(table.getSmall()).setLastBetAmt(1);
            table.Players.get(table.getBig()).setLastBetAmt(2);
            table.Players.get(table.getBig()).setActionReq(false);
            table.setCurrentBet(2);
            table.CommCards.clear();
            table.BurnCards.clear();

            controller.clearTableCards();
            controller.clearHand();

            for (int i = 0; i < 2; i++) {
                for (Player p : table.Players) {
                    Card c = deck.dealCard();
                    p.giveCard(deck.dealCard());
                    if (p.isHuman()) {
                        controller.addHandCard(c);
                    }
                }
            }

            table.addBurnCard(deck.dealCard());
            for (int i = 0; i < 3; i++) {
                table.addCommCards(deck.dealCard());
            }
            table.addBurnCard(deck.dealCard());
            table.addCommCards(deck.dealCard());
            table.addBurnCard(deck.dealCard());
            table.addCommCards(deck.dealCard());

            Card cardArray[][] = new Card[playersCount][7];
            for (Player p : table.Players) {
                int j = 0;
                for (Card c : p.hand) {
                    cardArray[p.getPlayerNum()][j++] = c;
                }
                for (Card c : table.CommCards) {
                    cardArray[p.getPlayerNum()][j++] = c;
                }
            }
            analyzer.Analyze(cardArray);
            boolean handLoop = true;

            while (handLoop) {
                while (table.getPlayerActionsReq() > 0) {
                    for (Player p : table.Players) {
                        if (!p.isOut() && !p.isFolded()) {
//                            gracz komputerowy
                            if (!p.isHuman() && p.isActionReq() && !p.isAllIn()) {
                                int choiceAI[] = PlayerAI.PlayerAI1(p.getPlayerNum(), analyzer, table);
                                switch (choiceAI[0]) {
                                    case 0:
//                                        sprawdzam
                                        table.addToPot(choiceAI[1]);
                                        p.takeFromChips(choiceAI[1]);
                                        table.setCurrentBet(choiceAI[1]);
                                        p.setActionReq(false);
                                        table.decActionsReq();
//                                        komunikat
                                        controller.addInfo("Gracz: " + p.getPlayerName() + " sprawdza");
                                        break;
                                    case 1:
//                                        podbijam
                                        table.addToPot(choiceAI[1]);
                                        p.takeFromChips(choiceAI[1]);
                                        table.setCurrentBet(choiceAI[1]);
                                        for (Player p2 : table.Players) {
                                            p2.setActionReq(true);
                                        }
                                        p.setActionReq(false);
                                        table.setPlayerActionsReq(playersCount - 1);
//                                        komunikat
                                        controller.addInfo("Gracz: " + p.getPlayerName() + " podbija stawkę");
                                        break;
                                    case 2:
                                        table.addToPot(choiceAI[1]);
                                        p.takeFromChips(choiceAI[1]);
                                        table.setCurrentBet(choiceAI[1]);
                                        for (Player p2 : table.Players) {
                                            p2.setActionReq(true);
                                        }
                                        p.setActionReq(false);
                                        table.setPlayerActionsReq(playersCount - 1);
//                                        komunikat
                                        controller.addInfo("Gracz: " + p.getPlayerName() + " dokłada");
                                        break;
                                    case 3:
//                                        czekam
                                        p.setActionReq(false);
                                        table.decActionsReq();
//                                        komunikat
                                        controller.addInfo("Gracz: " + p.getPlayerName() + " czeka");
                                        break;
                                    case 4:
//                                        pas
                                        p.setActionReq(false);
                                        p.actionFold();
                                        table.decActionsReq();
//                                        komunikat
                                        controller.addInfo("Gracz: " + p.getPlayerName() + " pasuje");
                                        break;
                                    case 5:
//                                        opuszcza stol 
                                        p.setActionReq(false);
                                        p.actionFold();
                                        table.decActionsReq();
                                        p.setOut(true);
                                        controller.addInfo("Gracz: " + p.getPlayerName() + " opuszcza stol");
                                        break;
                                }
                            } else if (p.isHuman() && p.isActionReq() && !p.isAllIn()) {
                                controller.updateState(table);
                                int choice[] = controller.getAction(table);
                                while (choice[0] < 0) {
                                    choice = controller.getAction(table);
                                }

                                switch (choice[0]) {
                                    case 0:
                                        table.addToPot(choice[1]);
                                        p.takeFromChips(choice[1]);
                                        p.setActionReq(false);
                                        table.decActionsReq();
                                        break;
                                    case 2:
                                        table.addToPot(choice[1]);
                                        p.takeFromChips(choice[1]);
                                        for (Player p2 : table.Players) {
                                            if (!p2.isOut()) {
                                                p2.setActionReq(true);
                                            }
                                        }
                                        p.setActionReq(false);
                                        table.setPlayerActionsReq(playersCount - 1);
                                    case 1:
                                        table.addToPot(choice[1]);
                                        p.takeFromChips(choice[1]);
                                        for (Player p2 : table.Players) {
                                            if (!p2.isOut()) {
                                                p2.setActionReq(true);
                                            }
                                        }
                                        p.setActionReq(false);
                                        table.setPlayerActionsReq(playersCount - 1);
                                        break;
                                    case 3:
                                        break;
                                    case 4:
                                        p.setActionReq(false);
                                        p.actionFold();
                                        table.decActionsReq();
                                        break;
                                    case 5:
                                        p.setActionReq(false);
                                        p.actionFold();
                                        table.decActionsReq();
                                        p.setOut(true);
                                        table.setGameStatus(false);
                                        break;
                                }
                                controller.setChips(p.getChips());
                            } else {
                                table.decActionsReq();
                            }
                        } else {
                            table.decActionsReq();
                        }
                    }
                }

                table.setCurrentBet(0);
                table.setPlayerActionsReq(playersCount - 1);
                for (Player p : table.Players) {
                    if (!p.isOut()) {
                        p.setLastBetAmt(0);
                        p.setActionReq(true);
                    }
                }

                int foldCount = 0;
                int playerNotFolded = -1;

                for (Player p : table.Players) {
                    if (!p.isOut()) {
                        if (!p.isFolded()) {
                            foldCount++;
                            playerNotFolded = p.getPlayerNum();
                        }
                    }
                }

                if (foldCount == 0) {
//                    komunikat, ze wszyscy gracze spasowali, gra od nowa
                    controller.addInfo("Wszyscy gracze spasowali!!!");
                    for (Player p : table.Players) {
                        if (!p.isOut() && p.getChips() > 0) {
                            p.setFolded(false);
                            p.setAllIn(false);
                        } else {
                            p.setOut(true);
                        }
                    }
                    table.setRound(0);
                    handLoop = false;
                } else {
                    if (table.getRound() == 3) {
                        for (Player p : table.Players) {
                            p.setHandRank(analyzer.getRiverRank(p.getPlayerNum()));
                            p.setHighCard(analyzer.getHoldHighCard(p.getPlayerNum()));
                        }

                        ArrayList<Player> winningPlayers = new ArrayList<Player>();
                        int winningRank = -1;
                        int highCard = -1;

                        for (Player p : table.Players) {
                            if (!p.isOut()) {
                                if (!p.isFolded()) {
                                    if (winningRank < p.getHandRank()) {
                                        winningRank = p.getHandRank();
                                        highCard = p.getHighCard();
                                        winningPlayers.clear();
                                        winningPlayers.add(p);
                                        if (p.isHuman()) {
                                            victory++;
                                        }
                                    } else if (winningRank == p.getHandRank()) {
                                        if (highCard < p.getHighCard()) {
                                            winningRank = p.getHandRank();
                                            highCard = p.getHighCard();
                                            winningPlayers.clear();
                                            winningPlayers.add(p);
                                            if (p.isHuman()) {
                                                victory++;
                                            }
                                        } else if (highCard == p.getHighCard()) {
//                                            komunikat ze remis
                                            controller.addInfo("Remis");
                                            winningPlayers.add(p);
                                            if (p.isHuman()) {
                                                victory++;
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        for (Player p : winningPlayers) {
                            controller.addInfo("Gracz " + p.getPlayerName() + " wygral poprzez: ");
                            switch (p.getHandRank()) {
                                case 0:
                                    controller.addInfo("wysoką kartę");
                                    break;
                                case 1:
                                    controller.addInfo("parę");
                                    break;
                                case 2:
                                    controller.addInfo("dwie pary");
                                    break;
                                case 3:
                                    controller.addInfo("trójkę");
                                    break;
                                case 4:
                                    controller.addInfo("strita");
                                    break;
                                case 5:
                                    controller.addInfo("kolor");
                                    break;
                                case 6:
                                    controller.addInfo("fula");
                                    break;
                                case 7:
                                    controller.addInfo("karetę");
                                    break;
                                case 8:
                                    controller.addInfo("poker");
                                    break;
                                case 9:
                                    controller.addInfo("poker królewski");
                                    break;
                            }
                        }

                        int portion = table.getPot() / winningPlayers.size();
//                        komunikat o przydzieleniu nagrody
                        controller.addInfo("Zwyciezca otrzymuje: " + portion + " żetonów");
                        for (Player p : winningPlayers) {
                            table.Players.get(p.getPlayerNum()).addToChips(portion);
                        }
                        winningPlayers.clear();
                        table.setPot(0);

                        for (Player p : table.Players) {
                            if (!p.isOut() && p.getChips() > 0) {
                                p.setFolded(false);
                                p.setAllIn(false);
                            } else {
                                p.setOut(true);
                            }
                        }

                        table.setRound(0);
                        controller.clearHand();
                        handLoop = false;
                    } else if (foldCount == 1) {
                        Player playerWinner = table.Players.get(playerNotFolded);
//                        komunikat o wygranym
                        controller.addInfo("Gracz " + playerWinner.getPlayerName() + " wygrał z ręki");
                        controller.addInfo("Zwyciezca otrzymuje: " + table.getPot() + " żetonów");
                        if(playerWinner.isHuman()){
                            victory++;
                        }
                        table.Players.get(playerNotFolded).addToChips(table.getPot());
                        table.setPot(0);
                        for (Player p : table.Players) {
                            if (!p.isOut() && p.getChips() > 0) {
                                p.setFolded(false);
                                p.setAllIn(false);
                            } else {
                                p.setOut(true);
                            }
                        }
                        table.setRound(0);
                        controller.clearHand();
                        handLoop = false;
                    } else {
                        table.setRound(table.getRound() + 1);

                        // Pot
                        controller.setPot(table.getPot());
                    }
                }
            }
            if(table.Players.get(0).getChips() <= 0){
                table.setGameStatus(false);
            }
        }
    }
}
