package Projekat1;

public class Player {

    private String name;
    private int x;
    private int y;
    private int width;
    private int height;
    private int health;

    public Player(String name, int x, int y, int width, int height, int health) {
        setName(name);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setHealth(health);
    }

 
    public void setName(String name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Ime igraca ne smije biti prazno!");
        }

        String[] reci = name.trim().split("\\s+");
        String rezultat = "";

        for (int i = 0; i < reci.length; i++) {
            String rijec = reci[i];
            rezultat = rezultat + rijec.substring(0, 1).toUpperCase() + rijec.substring(1).toLowerCase();
            if (i < reci.length - 1) {
                rezultat = rezultat + " ";
            }
        }

        this.name = rezultat;
    }

    
    public void setHealth(int health) {
        if (health < 0 || health > 100) {
            throw new IllegalArgumentException("Health mora biti izmedju 0 i 100!");
        }
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHealth() {
        return health;
    }

    public String toString() {
        return "Player[" + name + "] @ (" + x + "," + y + ") " + width + "x" + height + " HP=" + health;
    }
}
