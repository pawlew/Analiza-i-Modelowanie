/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.HashMap;
import javax.swing.JLabel;

/**
 *
 * @author siesiek
 */
public class CardLabel extends JLabel {
    private HashMap<String, String> filenames = new HashMap<String, String>();

    public CardLabel(String card) {
        super();
        filenames.put("AS", "spades-a-75.png");
        filenames.put("2S", "spades-2-75.png");
        filenames.put("3S", "spades-3-75.png");
        filenames.put("4S", "spades-4-75.png");
        filenames.put("5S", "spades-5-75.png");
        filenames.put("6S", "spades-6-75.png");
        filenames.put("7S", "spades-7-75.png");
        filenames.put("8S", "spades-8-75.png");
        filenames.put("9S", "spades-9-75.png");
        filenames.put("10S", "spades-10-75.png");
        filenames.put("JS", "spades-j-75.png");
        filenames.put("QS", "spades-q-75.png");
        filenames.put("KS", "spades-k-75.png");
        
        filenames.put("AD", "diamonds-a-75.png");
        filenames.put("2D", "diamonds-2-75.png");
        filenames.put("3D", "diamonds-3-75.png");
        filenames.put("4D", "diamonds-4-75.png");
        filenames.put("5D", "diamonds-5-75.png");
        filenames.put("6D", "diamonds-6-75.png");
        filenames.put("7D", "diamonds-7-75.png");
        filenames.put("8D", "diamonds-8-75.png");
        filenames.put("9D", "diamonds-9-75.png");
        filenames.put("10D", "diamonds-10-75.png");
        filenames.put("JD", "diamonds-j-75.png");
        filenames.put("QD", "diamonds-q-75.png");
        filenames.put("KD", "diamonds-k-75.png");
        
        filenames.put("AH", "hearts-a-75.png");
        filenames.put("2H", "hearts-2-75.png");
        filenames.put("3H", "hearts-3-75.png");
        filenames.put("4H", "hearts-4-75.png");
        filenames.put("5H", "hearts-5-75.png");
        filenames.put("6H", "hearts-6-75.png");
        filenames.put("7H", "hearts-7-75.png");
        filenames.put("8H", "hearts-8-75.png");
        filenames.put("9H", "hearts-9-75.png");
        filenames.put("10H", "hearts-10-75.png");
        filenames.put("JH", "hearts-j-75.png");
        filenames.put("QH", "hearts-q-75.png");
        filenames.put("KH", "hearts-k-75.png");
        
        filenames.put("AC", "clubs-a-75.png");
        filenames.put("2C", "clubs-2-75.png");
        filenames.put("3C", "clubs-3-75.png");
        filenames.put("4C", "clubs-4-75.png");
        filenames.put("5C", "clubs-5-75.png");
        filenames.put("6C", "clubs-6-75.png");
        filenames.put("7C", "clubs-7-75.png");
        filenames.put("8C", "clubs-8-75.png");
        filenames.put("9C", "clubs-9-75.png");
        filenames.put("10C", "clubs-10-75.png");
        filenames.put("JC", "clubs-j-75.png");
        filenames.put("QC", "clubs-q-75.png");
        filenames.put("KC", "clubs-k-75.png");
        
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/cards/"+filenames.get(card))));
        this.setText("");
    }
    
    
}
