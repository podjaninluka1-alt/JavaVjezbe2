package Projekat1;

public class Enemy {
    private String type = "Nepoznat";
    private int x;
    private int y;
    private int width;
    private int height;
    private int damage;

    public Enemy(String type, int x, int y, int width, int height, int damage) {
        setType(type);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setDamage(damage);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        type = type.trim();

        if (type.equals("")) {
            System.out.println("Tip neprijatelja ne smije biti prazan!");
        } else {
            this.type = type;
        }
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (damage < 0 || damage > 100) {
            System.out.println("Damage mora biti izmedju 0 i 100!");
        } else {
            this.damage = damage;
        }
    }

    public String toString() {
        return "Enemy[" + type + "] @ (" + x + "," + y + ") " + width + "x" + height + " DMG=" + damage;
    }
}