package proiect.Domain;

public class Examen {

    private String tipExamen;
    private float medieExamen;

    public Examen() {}

    public Examen(String tipExamen, float medieExamen) {
        this.tipExamen = tipExamen;
        this.medieExamen = medieExamen;
    }

    public String getTipExamen() {
        return tipExamen;
    }

    public void setTipExamen(String tipExamen) {
        this.tipExamen = tipExamen;
    }

    public float getMedieExamen() {
        return medieExamen;
    }

    public void setMedieExamen(float medieExamen) {
        this.medieExamen = medieExamen;
    }
}
