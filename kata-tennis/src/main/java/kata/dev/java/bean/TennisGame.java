package kata.dev.java.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TENNISGAME")
public class TennisGame implements Cloneable {
	@Id	
    @Column(name="IDGAME")
	private int idGame;
	private int idSet;	
	private int setScore_1;
	private int gameScore_1;
	private int gamePoint_1;
	private int setScore_2;
	private int gameScore_2;
	private int gamePoint_2;
	
	public TennisGame(){
		super();
	}
	
	public TennisGame(int setId, int gameId, int setScore1, int gameScore1, int gamePoint1,int setScore2, int gameScore2, int gamePoint2){
		this.idSet = setId;
		this.idGame = gameId;
		this.setScore_1 = setScore1;
		this.gamePoint_1 = gamePoint1;
		this.gameScore_1 = gameScore1;
		this.setScore_2 = setScore2;
		this.gamePoint_2 = gamePoint2;
		this.gameScore_2 = gameScore2;
	}	
	
	public int getIdSet() {
		return idSet;
	}
	public void setIdSet(int idSet) {
		this.idSet = idSet;
	}
	public int getIdGame() {
		return idGame;
	}
	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}
	public int getSetScore_1() {
		return setScore_1;
	}
	public void setSetScore_1(int setScore_1) {
		this.setScore_1 = setScore_1;
	}
	public int getGameScore_1() {
		return gameScore_1;
	}
	public void setGameScore_1(int gameScore_1) {
		this.gameScore_1 = gameScore_1;
	}
	public int getGamePoint_1() {
		return gamePoint_1;
	}
	public void setGamePoint_1(int gamePoint_1) {
		this.gamePoint_1 = gamePoint_1;
	}
	public int getSetScore_2() {
		return setScore_2;
	}
	public void setSetScore_2(int setScore_2) {
		this.setScore_2 = setScore_2;
	}
	public int getGameScore_2() {
		return gameScore_2;
	}
	public void setGameScore_2(int gameScore_2) {
		this.gameScore_2 = gameScore_2;
	}
	public int getGamePoint_2() {
		return gamePoint_2;
	}
	public void setGamePoint_2(int gamePoint_2) {
		this.gamePoint_2 = gamePoint_2;
	}
	
	public Object clone() {
		TennisGame g = null;
	    try {	    	
	    	g = (TennisGame) super.clone();
	    } 
	    catch(CloneNotSupportedException cnse) {
	      	cnse.printStackTrace(System.err);
	    }   
	    return g;
	}
			
	@Override
	public String toString() {
		return "TennisGame [idGame=" + idGame + ", idSet=" + idSet + ", setScore_1=" + setScore_1 + ", gameScore_1="
				+ gameScore_1 + ", gamePoint_1=" + gamePoint_1 + ", setScore_2=" + setScore_2 + ", gameScore_2="
				+ gameScore_2 + ", gamePoint_2=" + gamePoint_2 + "]";
	}
	
}
