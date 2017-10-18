package kata.dev.java.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TENNISMATCH")
public class TennisMatch implements Cloneable {
	@Id	
    @Column(name="IDPLAY")
	private int idPlay;
	private int idGame;	
	private int gameScore_1;
	private int playScore_1;
	private int playPoint_1;
	private int gameScore_2;
	private int playScore_2;
	private int playPoint_2;
	
	public TennisMatch(){
		super();
	}
	
	public TennisMatch(int idGame, int idPlay, int setScore1, int playScore1, int playPoint1,int gameScore2, int playScore2, int playPoint2){
		this.idGame = idGame;
		this.idPlay = idPlay;
		this.gameScore_1 = setScore1;
		this.playPoint_1 = playPoint1;
		this.playScore_1 = playScore1;
		this.gameScore_2 = gameScore2;
		this.playPoint_2 = playPoint2;
		this.playScore_2 = playScore2;
	}	
	

	
	public int getIdPlay() {
		return idPlay;
	}

	public void setIdPlay(int idPlay) {
		this.idPlay = idPlay;
	}

	public int getIdGame() {
		return idGame;
	}

	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}

	public int getGameScore_1() {
		return gameScore_1;
	}

	public void setGameScore_1(int gameScore_1) {
		this.gameScore_1 = gameScore_1;
	}

	public int getPlayScore_1() {
		return playScore_1;
	}

	public void setPlayScore_1(int playScore_1) {
		this.playScore_1 = playScore_1;
	}

	public int getPlayPoint_1() {
		return playPoint_1;
	}

	public void setPlayPoint_1(int playPoint_1) {
		this.playPoint_1 = playPoint_1;
	}

	public int getGameScore_2() {
		return gameScore_2;
	}

	public void setGameScore_2(int gameScore_2) {
		this.gameScore_2 = gameScore_2;
	}

	public int getPlayScore_2() {
		return playScore_2;
	}

	public void setPlayScore_2(int playScore_2) {
		this.playScore_2 = playScore_2;
	}

	public int getPlayPoint_2() {
		return playPoint_2;
	}

	public void setPlayPoint_2(int playPoint_2) {
		this.playPoint_2 = playPoint_2;
	}

	public Object clone() {
		TennisMatch g = null;
	    try {	    	
	    	g = (TennisMatch) super.clone();
	    } 
	    catch(CloneNotSupportedException cnse) {
	      	cnse.printStackTrace(System.err);
	    }   
	    return g;
	}

	@Override
	public String toString() {
		return "TennisMatch [idPlay=" + idPlay + ", idGame=" + idGame + ", gameScore_1=" + gameScore_1
				+ ", playScore_1=" + playScore_1 + ", playPoint_1=" + playPoint_1 + ", gameScore_2=" + gameScore_2
				+ ", playScore_2=" + playScore_2 + ", playPoint_2=" + playPoint_2 + "]";
	}
	
	
	
}
