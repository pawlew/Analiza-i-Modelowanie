/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

/**
 *
 * @author siesiek
 */
public class Analyzer {

    Object[][] player;
    public int holdRow[];
    public int holdCol[];
    public int highRow;
    public int highCol;
    public int fpairs = 99;
    public int ftrips = 99;
    public int ffours = 99;
    public int fSG;
    public int fsuit;
    public int fHC = 99;
    int[][] suited;
    int[] empt;
    public int tpairs = 99;
    public int ttrips = 99;
    public int tfours = 99;
    public int tSG;
    public int tsuit;
    public int tHC = 99;
    public int rpairs = 99;
    public int rtrips = 99;
    public int rfours = 99;
    public int rSG;
    public int rsuit;
    public int rHC = 99;
    int[] cardCount;
    int[] cardSuit;
    public int flush;
    public String rFH;

    public void Analyze(Object[][] Player) {

        player = Player;
    }

    public int getHoldRank(int position) {
        //Develop the hold card rank based on Jake's chart
        int pos = position;
        int Rank = 0;

        cardCount = new int[13];

        cardSuit = new int[14];
        holdRow = new int[14];
        holdCol = new int[4];

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {

                if ((player[pos][0].toString()).equalsIgnoreCase(cardKey[i][j])) {
                    cardCount[i] = cardCount[i] + 1;
                    cardSuit[i] = j;
                    holdRow[0] = i;
                    holdCol[0] = j;

                }
                if ((player[pos][1].toString()).equalsIgnoreCase(cardKey[i][j])) {
                    cardCount[i] = cardCount[i] + 1;
                    cardSuit[i] = j;
                    holdRow[1] = i;
                    holdCol[1] = j;

                }
            }

        }
        //all we are looking for is pairs or not
        for (int i = 0; i < 13; i++) {
            if (cardCount[i] == 2) {
                Rank = 1;
            }
        }

        return Rank;
    }

    public int getHoldHighCard(int position) {
        getHoldRank(position);


        //first take care of the aces
        if (holdRow[0] == 0) {
            holdRow[0] = 13;
        }
        if (holdRow[1] == 0) {
            holdRow[1] = 13;
        }
        //done with aces

        if (holdRow[0] >= holdRow[1]) {
            highRow = holdRow[0];
            highCol = holdCol[0];
        } else {
            highRow = holdRow[1];
            highCol = holdCol[1];
        }
        return highRow;
    }

    public int getFlopRank(int position) {
        //develop the flop hand rank based upon Jake's chart
        int pos = position;
        int Rank = 0;
        int[] cardCount;
        cardCount = new int[14];
        int[][] cardSuit;
        cardSuit = new int[14][4];


        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {

                if ((player[pos][0].toString()).equalsIgnoreCase(cardKey[i][j])) {
                    cardCount[i] = cardCount[i] + 1;
                    cardSuit[i][j] = 1;

                }
                if ((player[pos][1].toString()).equalsIgnoreCase(cardKey[i][j])) {
                    cardCount[i] = cardCount[i] + 1;
                    cardSuit[i][j] = 1;


                }
                if ((player[pos][2].toString()).equalsIgnoreCase(cardKey[i][j])) {
                    cardCount[i] = cardCount[i] + 1;
                    cardSuit[i][j] = 1;


                }
                if ((player[pos][3].toString()).equalsIgnoreCase(cardKey[i][j])) {
                    cardCount[i] = cardCount[i] + 1;
                    cardSuit[i][j] = 1;


                }
                if ((player[pos][4].toString()).equalsIgnoreCase(cardKey[i][j])) {
                    cardCount[i] = cardCount[i] + 1;
                    cardSuit[i][j] = 1;


                }
            }

        }

        if (cardCount[0] >= 1) {
            cardCount[13] = cardCount[0];//Handles the ace for straights
        }
        //find the high card
        //cardCount[] contains the number of cards for that value
        //the highest value of i is the high card
        for (int i = 13; i > 0; i--) {
            if (cardCount[i] > 0) {
                fHC = i;
                break;
            }
        }
        //fix the aces for straights
        if (cardSuit[0][0] == 1) {
            cardSuit[13][0] = 1;
        }
        if (cardSuit[0][1] == 1) {
            cardSuit[13][1] = 1;
        }
        if (cardSuit[0][2] == 1) {
            cardSuit[13][2] = 1;
        }
        if (cardSuit[0][3] == 1) {
            cardSuit[13][3] = 1;
        }
        //hunting for straights
        //not worried about suits only need the number of zeros for each group

        empt = new int[10];
        int k = 0;
        int m = k + 5;

        for (int q = 0; q < 10; q++) {//number of 5 card groupings in 13 cards

            for (int j = k; j < m; j++) {//go down the rows
                if (cardCount[j] == 0) {
                    empt[q]++;//count the number of zero's in each group 
                }
            }
            k = k + 1;
            m = k + 5;

        }
        //looking for suits
        //looking for the number of zeros for each group and suit

        suited = new int[4][10];
        k = 0;
        m = k + 5;
        for (int g = 0; g < 4; g++) {
            for (int q = 0; q < 10; q++) {//number of 5 card groupings in 13 cards

                for (int j = k; j < m; j++) {//go down the rows
                    if (cardSuit[j][g] == 0) {
                        suited[g][q]++;//count the number of zero's 
                        //in each group 
                    }
                }
                k = k + 1;
                m = k + 5;
            }
            k = 0;
            m = k + 5;
        }
        //looking for pairs, triples, 4ofakind and flush
        int Pair = 0;
        int Trips = 0;
        int Fours = 0;
        int suit0 = 0;
        int suit1 = 0;
        int suit2 = 0;
        int suit3 = 0;
        fpairs = 99;
        ftrips = 99;
        ffours = 99;

        //looking for pairs trips and 4 of a kind
        for (int i = 0; i < 13; i++) {
            if (cardCount[i] == 2) {
                Pair = Pair + 1;
                fpairs = i + 1;
            }
            if (cardCount[i] == 3) {
                Trips = Trips + 1;
                ftrips = i + 1;
            }
            if (cardCount[i] == 4) {
                Fours = Fours + 1;
                ffours = i + 1;
            }
        }
        //counting the number of zeros in each suit
        for (int i = 0; i < 13; i++) {

            if (cardSuit[i][0] == 1) {
                suit0 = suit0 + 1;
            }
            if (cardSuit[i][1] == 1) {
                suit1 = suit1 + 1;
            }
            if (cardSuit[i][2] == 1) {
                suit2 = suit2 + 1;
            }
            if (cardSuit[i][3] == 1) {
                suit3 = suit3 + 1;
            }

        }

        //Rank based on pairs, trips, and 4 of a kind
        int stra = 0;
        int flush = 0;
        int FSuit = 0;
        int SG = 0;
        fSG = 99;

        if (Pair == 0) {
            Rank = 0;
        }
        if (Pair == 1) {
            Rank = 1;
        }
        if (Pair >= 2) {
            Rank = 2;
        }
        if (Trips == 1) {
            Rank = 3;
        }
        //straight next
        if (empt[0] == 0 || empt[1] == 0 || empt[2] == 0 || empt[3] == 0 || empt[4] == 0
                || empt[5] == 0 || empt[6] == 0 || empt[7] == 0 || empt[8] == 0
                || empt[9] == 0) {
            stra = 1;
            Rank = 4;
        }
        //put flush here		
        if (suit0 >= 5 || suit1 >= 5 || suit2 >= 5 || suit3 >= 5) {
            flush = 1;
            Rank = 5;
        }
        //full house
        if ((Pair == 1) && (Trips == 1)) {
            Rank = 6;
        }
        //4 of a kind
        if (Fours == 1) {
            Rank = 7;
        }

        if (stra == 1 && flush == 1) {
            if (suit0 >= 5) {
                FSuit = 0;
                fsuit = 0;
            }
            if (suit1 >= 5) {
                FSuit = 1;
                fsuit = 1;
            }
            if (suit2 >= 5) {
                FSuit = 2;
                fsuit = 2;
            }
            if (suit3 >= 5) {
                FSuit = 3;
                fsuit = 3;
            }

            Rank = 8;
        }
        if (suit0 < 5 && suit1 < 5 && suit2 < 5 && suit3 < 5) {
            fsuit = 99;
        }
        //find the straight group
        if (stra == 1) {
            for (int i = 0; i < 10; i++) {
                if (empt[i] == 0) {
                    SG = i;
                    fSG = i;
                }
            }
        }
        //royal flush next

        if (suited[SG][FSuit] == 0 && SG == 9) {
            Rank = 9;//Royal Flush
        }

        return Rank;
    }

    public int getflopPair(int position) {
        getFlopRank(position);
        return fpairs;
    }

    public int getflopTrips(int position) {
        getFlopRank(position);
        return ftrips;
    }

    public int getflopFours(int position) {
        getFlopRank(position);
        return ffours;
    }

    public int getflopFlushSuit(int position) {
        getFlopRank(position);
        return fsuit;
    }

    public int getflopSG(int position) {
        getFlopRank(position);
        return fSG;
    }

    public int getflopHighCard(int position) {
        getFlopRank(position);
        return fHC;
    }

    public int getTurnRank(int position) {
        int pos = position;
        int Rank = 0;
        int[] cardCount;
        cardCount = new int[14];
        int[][] cardSuit;
        cardSuit = new int[14][4];

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {

                if ((player[pos][0].toString()).equalsIgnoreCase(cardKey[i][j])) {
                    cardCount[i] = cardCount[i] + 1;
                    cardSuit[i][j] = 1;

                }
                if ((player[pos][1].toString()).equalsIgnoreCase(cardKey[i][j])) {
                    cardCount[i] = cardCount[i] + 1;
                    cardSuit[i][j] = 1;

                }
                if ((player[pos][2].toString()).equalsIgnoreCase(cardKey[i][j])) {
                    cardCount[i] = cardCount[i] + 1;
                    cardSuit[i][j] = 1;

                }
                if ((player[pos][3].toString()).equalsIgnoreCase(cardKey[i][j])) {
                    cardCount[i] = cardCount[i] + 1;
                    cardSuit[i][j] = 1;

                }
                if ((player[pos][4].toString()).equalsIgnoreCase(cardKey[i][j])) {
                    cardCount[i] = cardCount[i] + 1;
                    cardSuit[i][j] = 1;

                }
                if ((player[pos][5].toString()).equalsIgnoreCase(cardKey[i][j])) {
                    cardCount[i] = cardCount[i] + 1;
                    cardSuit[i][j] = 1;

                }
            }

        }
        if (cardCount[0] >= 1) {
            cardCount[13] = cardCount[0];//Handles the ace for straights
        }
        //find the high card
        //cardCount[] contains the number of cards for that value
        //the highest value of i is the high card
        for (int i = 13; i > 0; i--) {
            if (cardCount[i] > 0) {
                tHC = i;
                break;
            }
        }

        if (cardSuit[0][0] == 1) {
            cardSuit[13][0] = 1;
        }
        if (cardSuit[0][1] == 1) {
            cardSuit[13][1] = 1;
        }
        if (cardSuit[0][2] == 1) {
            cardSuit[13][2] = 1;
        }
        if (cardSuit[0][3] == 1) {
            cardSuit[13][3] = 1;
        }
        //hunting for straights
        int[] empt;
        empt = new int[10];
        int k = 0;
        int m = k + 5;

        for (int q = 0; q < 10; q++) {//number of 5 card groupings in 13 cards

            for (int j = k; j < m; j++) {//go down the rows
                if (cardCount[j] == 0) {
                    empt[q]++;//count the number of zero's in each group 
                }
            }
            k = k + 1;
            m = k + 5;

        }
        //looking for suits
        int[][] suited;
        suited = new int[4][10];
        k = 0;
        m = k + 5;
        for (int g = 0; g < 4; g++) {
            for (int q = 0; q < 10; q++) {//number of 5 card groupings in 13 cards

                for (int j = k; j < m; j++) {//go down the rows
                    if (cardSuit[j][g] == 0) {
                        suited[g][q]++;//count the number of 
                        //zero's in each group 
                    }
                }
                k = k + 1;
                m = k + 5;
            }
            k = 0;
            m = k + 5;
        }

        int Pair = 0;
        int Trips = 0;
        int Fours = 0;
        int suit0 = 0;
        int suit1 = 0;
        int suit2 = 0;
        int suit3 = 0;
        tpairs = 99;
        ttrips = 99;
        tfours = 99;



        for (int i = 0; i < 13; i++) {
            if (cardCount[i] == 2) {
                Pair = Pair + 1;
                tpairs = i + 1;
            }
            if (cardCount[i] == 3) {
                Trips = Trips + 1;
                ttrips = i + 1;
            }
            if (cardCount[i] == 4) {
                Fours = Fours + 1;
                tfours = i + 1;
            }
        }
        for (int i = 0; i < 13; i++) {

            if (cardSuit[i][0] == 1) {
                suit0 = suit0 + 1;
            }
            if (cardSuit[i][1] == 1) {
                suit1 = suit1 + 1;
            }
            if (cardSuit[i][2] == 1) {
                suit2 = suit2 + 1;
            }
            if (cardSuit[i][3] == 1) {
                suit3 = suit3 + 1;
            }

        }

        //Rank based on pairs, trips, and 4 of a kind
        int stra = 0;

        int FSuit = 0;
        int SG = 0;
        tSG = 99;

        if (Pair == 0) {
            Rank = 0;
        }
        if (Pair == 1) {
            Rank = 1;
        }
        if (Pair >= 2) {
            Rank = 2;
        }
        if (Trips == 1) {
            Rank = 3;
        }
        if (empt[0] == 0 || empt[1] == 0 || empt[2] == 0 || empt[3] == 0 || empt[4] == 0
                || empt[5] == 0 || empt[6] == 0 || empt[7] == 0 || empt[8] == 0
                || empt[9] == 0) {
            stra = 1;
            Rank = 4;
        }
        //find the straight group
        if (stra == 1) {
            for (int i = 0; i < 10; i++) {
                if (empt[i] == 0) {
                    SG = i;
                    tSG = i;
                }
            }
        }
        //put flush here		
        if (suit0 >= 5 || suit1 >= 5 || suit2 >= 5 || suit3 >= 5) {
            flush = 1;
            Rank = 5;
        }
        if ((Pair == 1) && (Trips == 1)) {
            Rank = 6;
        }
        if (Fours == 1) {
            Rank = 7;
        }
        //look for the straight flush
        for (int i = 0; i < 4; i++) {	//number of suits
            for (int j = 0; j < 10; j++) {	//number of groups
                if (empt[j] == 0 && suited[i][j] == 0) {
                    Rank = 8;
                    SG = j;
                    tSG = SG;
                    tsuit = i;
                    break;
                }
            }
        }

        if (suit0 < 5 && suit1 < 5 && suit2 < 5 && suit3 < 5) {
            tsuit = 99;
        }

        if (suited[SG][FSuit] == 0 && SG == 9) {
            Rank = 9;//Royal Flush
            SG = 9;
            tSG = SG;
        }


        return Rank;
    }

    public int getturnPair(int position) {
        getTurnRank(position);
        return tpairs;
    }

    public int getturnTrips(int position) {
        getTurnRank(position);
        return ttrips;
    }

    public int getturnFours(int position) {
        getTurnRank(position);
        return tfours;
    }

    public int getturnFlushSuit(int position) {
        getTurnRank(position);
        return tsuit;
    }

    public int getturnSG(int position) {
        getTurnRank(position);
        return tSG;
    }

    public int getturnHighCard(int position) {
        getTurnRank(position);
        return tHC;
    }

    public int getRiverRank(int position) {
        int pos = position;
        int Rank = 0;
        int[] cardCount;
        cardCount = new int[14];
        int[][] cardSuit;
        cardSuit = new int[14][4];

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {

                if ((player[pos][0].toString()).equalsIgnoreCase(cardKey[i][j])) {
                    cardCount[i] = cardCount[i] + 1;
                    cardSuit[i][j] = 1;

                }
                if ((player[pos][1].toString()).equalsIgnoreCase(cardKey[i][j])) {
                    cardCount[i] = cardCount[i] + 1;
                    cardSuit[i][j] = 1;

                }
                if ((player[pos][2].toString()).equalsIgnoreCase(cardKey[i][j])) {
                    cardCount[i] = cardCount[i] + 1;
                    cardSuit[i][j] = 1;

                }
                if ((player[pos][3].toString()).equalsIgnoreCase(cardKey[i][j])) {
                    cardCount[i] = cardCount[i] + 1;
                    cardSuit[i][j] = 1;

                }
                if ((player[pos][4].toString()).equalsIgnoreCase(cardKey[i][j])) {
                    cardCount[i] = cardCount[i] + 1;
                    cardSuit[i][j] = 1;

                }
                if ((player[pos][5].toString()).equalsIgnoreCase(cardKey[i][j])) {
                    cardCount[i] = cardCount[i] + 1;
                    cardSuit[i][j] = 1;

                }
                if ((player[pos][6].toString()).equalsIgnoreCase(cardKey[i][j])) {
                    cardCount[i] = cardCount[i] + 1;
                    cardSuit[i][j] = 1;

                }
            }

        }
        if (cardCount[0] >= 1) {
            cardCount[13] = cardCount[0];//Handles the ace for straights
        }
        //find the high card
        //cardCount[] contains the number of cards for that value
        //the highest value of i is the high card
        for (int i = 13; i > 0; i--) {
            if (cardCount[i] > 0) {
                rHC = i;
                break;
            }
        }


        if (cardSuit[0][0] == 1) {
            cardSuit[13][0] = 1;
        }
        if (cardSuit[0][1] == 1) {
            cardSuit[13][1] = 1;
        }
        if (cardSuit[0][2] == 1) {
            cardSuit[13][2] = 1;
        }
        if (cardSuit[0][3] == 1) {
            cardSuit[13][3] = 1;
        }

        //hunting for straights
        int[] empt;
        empt = new int[10];
        int k = 0;
        int m = k + 5;

        for (int q = 0; q < 10; q++) {//number of 5 card groupings in 13 cards

            for (int j = k; j < m; j++) {//go down the rows
                if (cardCount[j] == 0) {
                    empt[q]++;//count the number of zero's in each group 
                }
            }
            k = k + 1;
            m = k + 5;

        }
        //looking for suits
        int[][] suited;
        suited = new int[4][10];
        k = 0;
        m = k + 5;
        for (int g = 0; g < 4; g++) {//4 suits
            for (int q = 0; q < 10; q++) {//number of 5 card groupings in 13 cards

                for (int j = k; j < m; j++) {//go down the rows
                    if (cardSuit[j][g] == 0) {
                        suited[g][q]++;//count the number of 
                        //zero's in each group 
                    }
                }
                k = k + 1;
                m = k + 5;
            }
            k = 0;
            m = k + 5;
        }
        int Pair = 0;
        int Trips = 0;
        int Fours = 0;
        int suit0 = 0;
        int suit1 = 0;
        int suit2 = 0;
        int suit3 = 0;
        rpairs = 99;
        rtrips = 99;
        rfours = 99;

        for (int i = 0; i < 13; i++) {
            if (cardCount[i] == 2) {
                Pair = Pair + 1;
                rpairs = i + 1;
            }
            if (cardCount[i] == 3) {
                Trips = Trips + 1;
                rtrips = i + 1;
            }
            if (cardCount[i] == 4) {
                Fours = Fours + 1;
                rfours = i + 1;
            }
        }
        for (int i = 0; i < 13; i++) {

            if (cardSuit[i][0] == 1) {
                suit0 = suit0 + 1;
            }
            if (cardSuit[i][1] == 1) {
                suit1 = suit1 + 1;
            }
            if (cardSuit[i][2] == 1) {
                suit2 = suit2 + 1;
            }
            if (cardSuit[i][3] == 1) {
                suit3 = suit3 + 1;
            }

        }

        //Rank based on pairs, trips, and 4 of a kind
        int stra = 0;

        int FSuit = 0;
        int SG = 0;
        rSG = 99;


        if (Pair == 0) {
            Rank = 0;
        }
        if (Pair == 1) {
            Rank = 1;
        }
        if (Pair >= 2) {
            Rank = 2;
        }
        if (Trips == 1) {
            Rank = 3;
        }
        if (empt[0] == 0 || empt[1] == 0 || empt[2] == 0 || empt[3] == 0 || empt[4] == 0
                || empt[5] == 0 || empt[6] == 0 || empt[7] == 0 || empt[8] == 0
                || empt[9] == 0) {
            stra = 1;
            Rank = 4;
        }
        //find the straight group
        if (stra == 1) {
            for (int i = 0; i < 10; i++) {
                if (empt[i] == 0) {
                    SG = i;
                    rSG = i;
                }
            }
        }
        //put straight here

        if (suit0 >= 5 || suit1 >= 5 || suit2 >= 5 || suit3 >= 5) {
            flush = 1;
            Rank = 5;
        }
        if ((Pair == 1) && (Trips == 1)) {
            Rank = 6;
        }
        if (Fours == 1) {
            Rank = 7;
        }
        //straight flush and royal flush ranking
        //look for the straight flush
        for (int i = 0; i < 4; i++) {	//number of suits
            for (int j = 0; j < 10; j++) {	//number of groups
                if (empt[j] == 0 && suited[i][j] == 0) {
                    Rank = 8;
                    SG = j;
                    rSG = SG;
                    rsuit = i;
                    //break;
                }
            }
        }

        if (suit0 < 5 && suit1 < 5 && suit2 < 5 && suit3 < 5) {
            rsuit = 99;
        }

        if (suited[FSuit][SG] == 0 && SG == 9) {
            Rank = 9;//Royal Flush

        }

        return Rank;
    }

    public int getriverPair(int position) {
        getRiverRank(position);
        return rpairs;
    }

    public int getriverTrips(int position) {
        getRiverRank(position);
        return rtrips;
    }

    public int getriverFours(int position) {
        getRiverRank(position);
        return rfours;
    }

    public int getriverFlushSuit(int position) {
        getRiverRank(position);
        return rsuit;
    }

    public int getriverSG(int position) {
        getRiverRank(position);
        return rSG;
    }

    public int getriverHighCard(int position) {
        getRiverRank(position);
        return rHC;
    }

    public String getriverFullHouseCards(int Position) {
        getRiverRank(Position);
        rFH = "" + rtrips + "," + rpairs;

        return rFH;
    }
//declarations
    String[][] cardKey = {
        {"AH", "AC", "AD", "AS"},
        {"2H", "2C", "2D", "2S"}, {"3H", "3C", "3D", "3S"},
        {"4H", "4C", "4D", "4S"}, {"5H", "5C", "5D", "5S"},
        {"6H", "6C", "6D", "6S"}, {"7H", "7C", "7D", "7S"},
        {"8H", "8C", "8D", "8S"}, {"9H", "9C", "9D", "9S"},
        {"10H", "10C", "10D", "10S"}, {"JH", "JC", "JD", "JS"},
        {"QH", "QC", "QD", "QS"}, {"KH", "KC", "KD", "KS"},
        {"AH", "AC", "AD", "AS"}};
}
