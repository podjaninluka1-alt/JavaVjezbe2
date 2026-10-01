package TrecaNedelja;
	
	
public class Zaposleni {
    private String ime;
    private String prezime;
    private int godineStaza;
    private double plata;

    public Zaposleni(String ime, String prezime, int godineStaza, double plata) {
        this.ime = ime;
        this.prezime = prezime;
        this.godineStaza = godineStaza;
        this.plata = plata;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getGodineStaza() {
        return godineStaza;
    }

    public void setGodineStaza(int godineStaza) {
        if (godineStaza >= 0) {
            this.godineStaza = godineStaza;
        } else {
            System.out.println("Greska, godine staza ne mogu biti negativne.");
        }
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        if (plata >= 0) {
            this.plata = plata;
        } else {
            System.out.println("Greska, plata ne moze biti negativna.");
        }
    }

    public void ispisi() {
        System.out.println("Ime i prezime: " + ime + " " + prezime);
        System.out.println("Godine staza: " + godineStaza);
    }

    public void provjeriPlatu() {
        if (plata < 800 && godineStaza > 10) {
            plata = plata * 1.06;
        }
    }

    public static void main(String[] args) {
        Zaposleni z1 = new Zaposleni("Marko", "Markovic", 12, 700);
        Zaposleni z2 = new Zaposleni("Ana", "Anic", 5, 750);
        Zaposleni z3 = new Zaposleni("Jovan", "Jovanovic", 15, 1000);

        System.out.println(z1.getIme());
        System.out.println(z2.getGodineStaza());

        z2.setPlata(780);
        z3.setGodineStaza(16);

        z1.provjeriPlatu();
        z2.provjeriPlatu();
        z3.provjeriPlatu();

        z1.ispisi();
        System.out.println("Plata: " + z1.getPlata());
        z2.ispisi();
        System.out.println("Plata: " + z2.getPlata());
        z3.ispisi();
        System.out.println("Plata: " + z3.getPlata());
    }
}
