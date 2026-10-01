package TrecaNedelja;

public class Televizor {

    private int brojKanala;
    private String nazivKanala;
    private int jacinaZvuka;

    public Televizor(int brojKanala, String nazivKanala, int jacinaZvuka) {
        this.brojKanala = brojKanala;
        this.nazivKanala = nazivKanala;
        this.jacinaZvuka = jacinaZvuka;
    }

    public int getBrojKanala() {
        return brojKanala;
    }

    public void setBrojKanala(int brojKanala) {
        if (brojKanala >= 1) {
            this.brojKanala = brojKanala;
        } else {
            System.out.println("Greska, broj kanala mora biti makar 1.");
        }
    }

    public String getNazivKanala() {
        return nazivKanala;
    }

    public void setNazivKanala(String nazivKanala) {
        this.nazivKanala = nazivKanala;
    }

    public int getJacinaZvuka() {
        return jacinaZvuka;
    }

    public void setJacinaZvuka(int jacinaZvuka) {
        if (jacinaZvuka >= 0 && jacinaZvuka <= 10) {
            this.jacinaZvuka = jacinaZvuka;
        } else {
            System.out.println("Greska, zvuk mora biti izmedju 0 i 10.");
        }
    }

    public void pojacajZvuk() {
        if (this.jacinaZvuka < 10) {
            this.jacinaZvuka++;
        } else {
            System.out.println("Maksimalna jacina zvuka je 10");
        }
    }

    public void stampa() {
        System.out.println("Broj kanala: " + this.brojKanala);
        System.out.println("Naziv trenutnog kanala: " + this.nazivKanala);
        System.out.println("Jacina zvuka: " + this.jacinaZvuka);
    }

    public static void main(String[] args) {
        Televizor televizor1 = new Televizor(10, "Prvi kanal", 5);
        System.out.println(televizor1.getBrojKanala());
        televizor1.setBrojKanala(5);
        System.out.println(televizor1.getBrojKanala());
        televizor1.pojacajZvuk();
        System.out.println(televizor1.getJacinaZvuka());
    }
}
