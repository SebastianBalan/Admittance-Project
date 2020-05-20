package proiect.Domain;

public class Facultate {

    private String nume;
    private String locatie;
    private int numarTotalLocuri;

    public Facultate() {}

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

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public void setNumarTotalLocuri(int numarTotalLocuri) {
        this.numarTotalLocuri = numarTotalLocuri;
    }
}
