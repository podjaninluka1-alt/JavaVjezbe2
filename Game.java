 package Projekat1;
	
 public class Game {
    private Player player;
    private Enemy[] enemies = new Enemy[10];          //LUKA PODJANIN 22/081 I ANASTASIJA BUBANJA 25/089
    private int brojNeprijatelja = 0;
    private String eventLog = "";
 
    public Game(Player player) {
        this.player = player;
    }
 
    public Player getPlayer() {
        return player;
    }
 
    public Enemy[] getEnemies() {
        return enemies;
    }
 
    public int getBrojNeprijatelja() {
        return brojNeprijatelja;
    }
 
    public String getEventLog() {
        return eventLog;
    }
 
   
    public boolean checkCollision(Player p, Enemy e) {
        if (p.getX() < e.getX() + e.getWidth()
                && p.getX() + p.getWidth() > e.getX()
                && p.getY() < e.getY() + e.getHeight()
                && p.getY() + p.getHeight() > e.getY()) {
            return true;
        }
        return false;
    }
 
   
    public void decreaseHealth(Player p, Enemy e) {
        int stariHealth = p.getHealth();
        int noviHealth = stariHealth - e.getDamage();
 
        if (noviHealth < 0) {
            noviHealth = 0;
        }
 
        p.setHealth(noviHealth);
 
        eventLog = eventLog + "HIT: Player by " + e.getType() + " for " + e.getDamage()
                + " -> HP " + stariHealth + " -> " + noviHealth + "\n";
    }
 

    public void addEnemy(Enemy e) {
        if (brojNeprijatelja == enemies.length) {
            eventLog = eventLog + "Niz neprijatelja je pun!\n";
            return;
        }
 
        enemies[brojNeprijatelja] = e;
        brojNeprijatelja++;
        eventLog = eventLog + "ADD: Enemy " + e.getType() + " added\n";
    }
 

    public Enemy[] findByType(String query) {
        query = query.trim().toLowerCase();
 
        int brojac = 0;
        for (int i = 0; i < brojNeprijatelja; i++) {
            if (enemies[i].getType().toLowerCase().contains(query)) {
                brojac++;
            }
        }
 
        Enemy[] rezultat = new Enemy[brojac];
        int j = 0;
        for (int i = 0; i < brojNeprijatelja; i++) {
            if (enemies[i].getType().toLowerCase().contains(query)) {
                rezultat[j] = enemies[i];
                j++;
            }
        }
 
        return rezultat;
    }
 
 
    public Enemy[] collidingWithPlayer() {
        int brojac = 0;
        for (int i = 0; i < brojNeprijatelja; i++) {
            if (checkCollision(player, enemies[i])) {
                brojac++;
            }
        }
 
        Enemy[] rezultat = new Enemy[brojac];
        int j = 0;
        for (int i = 0; i < brojNeprijatelja; i++) {
            if (checkCollision(player, enemies[i])) {
                rezultat[j] = enemies[i];
                j++;
            }
        }
 
        return rezultat;
    }
 
    
    public void resolveCollisions() {
        Enemy[] sudari = collidingWithPlayer();
 
        for (int i = 0; i < sudari.length; i++) {
            decreaseHealth(player, sudari[i]);
        }
    }
 
  
    public static Enemy napraviIzStringa(String tekst) {
        String[] dijelovi = tekst.split(";");
 
        String tip = dijelovi[0];
 
        String[] pozicija = dijelovi[1].split(",");
        int x = Integer.parseInt(pozicija[0]);
        int y = Integer.parseInt(pozicija[1]);
 
        String[] dimenzije = dijelovi[2].split("x");
        int sirina = Integer.parseInt(dimenzije[0]);
        int visina = Integer.parseInt(dimenzije[1]);
 
        int damage = Integer.parseInt(dijelovi[3]);
 
        return new Enemy(tip, x, y, sirina, visina, damage);
    }
 
    public static void main(String[] args) {
     
        Player p = new Player("  marko   petrovic ", 10, 5, 32, 32, 85);
        Game game = new Game(p);
 
     
        Enemy e1 = new Enemy("Orc", 100, 100, 20, 20, 30);
        Enemy e2 = napraviIzStringa("Goblin;12,5;16x16;20");
        game.addEnemy(e1);
        game.addEnemy(e2);
 
  
        System.out.println("Svi neprijatelji:");
        for (int i = 0; i < game.getBrojNeprijatelja(); i++) {
            System.out.println(game.getEnemies()[i]);
        }
 
       
        System.out.println("\nNeprijatelji koji sadrze 'gob':");
        Enemy[] nadjeni = game.findByType("gob");
        for (int i = 0; i < nadjeni.length; i++) {
            System.out.println(nadjeni[i]);
        }
 

        System.out.println("\nPrije: " + p);
        game.resolveCollisions();
        System.out.println("Poslije: " + p);
 
    
        System.out.println("\nEvent log:");
        System.out.print(game.getEventLog());
    }
}
 