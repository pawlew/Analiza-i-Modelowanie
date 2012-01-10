/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author siesiek
 */
public class GameStats {
    private Date created;
    private int rounds;
    private int victory;
    private int id;
    private int userId;

    public GameStats(Date created, int rounds, int victory, int userId) {
        this.created = created;
        this.rounds = rounds;
        this.victory = victory;
        this.userId = userId;
    }

    public GameStats(int id) {
        this.id = id;
    }
    
    public void createStats() throws SQLException{
        Statement stat = Database.getConnection().createStatement();
        stat.execute("INSERT INTO games (userId, createDate,rounds,victory) VALUES ("+this.userId+",'"+new SimpleDateFormat("yyyy-MM-dd").format(created) +"',"+this.rounds+","+this.victory+")");
    }
    
    public void loadStats() throws SQLException{
        Statement stat = Database.getConnection().createStatement();
        ResultSet result = stat.executeQuery("SELECT * FROM games WHERE id="+this.id);
        while(result.next()){
            this.userId = result.getInt("userId");
            this.created = result.getDate("createDate");
            this.rounds = result.getInt("rounds");
            this.victory = result.getInt("victory");
        }
    }

    public int getId() {
        return id;
    }

    public Date getCreated() {
        return created;
    }

    public int getVictory() {
        return victory;
    }

    public int getRounds() {
        return rounds;
    }
    
    public static int getMaxRounds(int userId) throws SQLException{
        Statement stat = Database.getConnection().createStatement();
        ResultSet result = stat.executeQuery("SELECT MAX(rounds) as value FROM games WHERE userId="+userId);
        result.next();
        return result.getInt("value");
    }
    
    public static int getMaxVictory(int userId) throws SQLException{
        Statement stat = Database.getConnection().createStatement();
        ResultSet result = stat.executeQuery("SELECT MAX(victory) as value FROM games WHERE userId="+userId);
        result.next();
        return result.getInt("value");
    }
    
    public static double getAvgRounds(int userId) throws SQLException{
        Statement stat = Database.getConnection().createStatement();
        ResultSet result = stat.executeQuery("SELECT AVG(rounds) as value FROM games WHERE userId="+userId);
        result.next();
        return result.getDouble("value");
    }
    
    public static double getAvgVictory(int userId) throws SQLException{
        Statement stat = Database.getConnection().createStatement();
        ResultSet result = stat.executeQuery("SELECT AVG(victory) as value FROM games WHERE userId="+userId);
        result.next();
        return result.getDouble("value");
    }
    
    public static int getAllRounds(int userId) throws SQLException{
        Statement stat = Database.getConnection().createStatement();
        ResultSet result = stat.executeQuery("SELECT SUM(rounds) as value FROM games WHERE userId="+userId);
        result.next();
        return result.getInt("value");
    }
    
    public static int getAllVictory(int userId) throws SQLException{
        Statement stat = Database.getConnection().createStatement();
        ResultSet result = stat.executeQuery("SELECT SUM(victory) as value FROM games WHERE userId="+userId);
        result.next();
        return result.getInt("value");
    }
    
    public static GameStats[] getAllGames(int userId) throws SQLException{
        GameStats[] games;
        Statement stat = Database.getConnection().createStatement();
        ResultSet result = stat.executeQuery("SELECT * FROM games WHERE userId="+userId);
        result.last();
        games = new GameStats[result.getRow()];
        int i = 0;
        result.beforeFirst();
        while(result.next()){
            games[i++] = new GameStats(result.getDate("createDate"), result.getInt("rounds"), result.getInt("victory"), userId);
        }
        return games;
    }
    
    public Object[] toArray(){
        Object[] array = new Object[3];
        DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        array[0] = formater.format(this.created);
        array[1] = this.rounds;
        array[2] = this.victory;
        return array;
    }
}
