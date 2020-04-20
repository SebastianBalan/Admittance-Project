package proiect.Domain;

public class Facultate {

    private String nume;
    private String locatie;
    private int numarTotalLocuri;

    public Facultate(String nume, String locatie, int numarTotalLocuri) {
        this.nume = nume;
        this.locatie = locatie;
        this.numarTotalLocuri = numarTotalLocuri;
    }

    public String getNume() {
        return nume;
    }

    public String getLocatie() {
        return locatie;
    }

    public int getNumarTotalLocuri() {
        return numarTotalLocuri;
    }
}
