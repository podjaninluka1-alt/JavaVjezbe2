package Projekat1;

import java.util.ArrayList;                  //LUKA PODJANIN 22/081,ANASTASIJA BUBANJA 25/089

public class Game {

 private Player player;
 private ArrayList<Enemy> enemies;
private ArrayList<String> eventLog;

    public Game(Player player) {
        this.player = player;
        this.enemies = new ArrayList<Enemy>();
        this.eventLog = new ArrayList<String>();
    }

  
    public boolean checkCollision(Player p, Enemy e) {
        return e.collidesWith(p);
    }

  
    public void decreaseHealth(Player p, Enemy e) {
      int stari = p.getHealth();
     int novi = stari - e.getDamage();
      if (novi < 0) {
            novi = 0;
        }
        p.setHealth(novi);
   eventLog.add("HIT: Player by " + e.getType() + " for " + e.getDamage()
                + " -> HP " + stari + "-> " + novi);
    }

   
    public void addEnemy(Enemy e) {
      enemies.add(e);
      eventLog.add("ADDED: " + e.toString());
    }
}