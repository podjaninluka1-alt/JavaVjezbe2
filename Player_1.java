public class Player {

    private String name = "Igrac";
    private int x;
    private int y;
    private int width;
    private int height;
    private int health = 100;

    public Player(String name, int x, int y, int width, int height, int health) {
        setName(name);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setHealth(health);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.trim();

        if (name.equals("")) {
            System.out.println("Ime igraca ne smije biti prazno!");
            return;
        }

       
        String novoIme = "";
        boolean pocetakRijeci = true;

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);

            if (c == ' ') {
                if (pocetakRijeci == false) {
                    novoIme = novoIme + " ";
                }
                pocetakRijeci = true;
            } else {
                if (pocetakRijeci == true) {
                    novoIme = novoIme + Character.toUpperCase(c);
                } else {
                    novoIme = novoIme + Character.toLowerCase(c);
                }
                pocetakRijeci = false;
            }
        }

        this.name = novoIme;
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

    public void setHealth(int health) {
        if (health < 0 || health > 100) {
            System.out.println("Health mora biti izmedju 0 i 100!");
        } else {
            this.health = health;
        }
    }

    public String toString() {
        return "Player[" + name + "] @ (" + x + "," + y + ") " + width + "x" + height + " HP=" + health;
    }
}
