package proiect.Domain;


public class Candidat implements Comparable<Candidat> {

    private int varsta;
    private String nume;
    private float medieBac;
    private float notaExamen;


    //Setteri
    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setMedieBac(float medieBac) {
        this.medieBac = medieBac;
    }

    public void setNotaExamen(float nota) {
        this.notaExamen = nota;
    }

    //Getteri
    public int getVarsta() {
        return varsta;
    }

    public String getNume() {
        return nume;
    }

    public float getMedieBac() {
        return medieBac;
    }

    public float getNotaExamen() {
        return notaExamen;
    }

    public void afisare() {
        System.out.println(this.getNume() + " " + this.getVarsta() + " " + this.getMedieBac() + " " + this.getNotaExamen());
    }

    @Override
    public int compareTo(Candidat o1) {
        return nume.compareTo(o1.getNume());
    }

}
