package proiect.Domain;

public class Bac {
    private int notaBac;
    private String tipExamen;

    public Bac(){}

    public Bac(int notaBac, String tipExamen) {
        this.notaBac = notaBac;
        this.tipExamen = tipExamen;
    }

    public void setNotaBac(int notaBac) {
        this.notaBac = notaBac;
    }

    public void setTipExamen(String tipExamen) {
        this.tipExamen = tipExamen;
    }

    public int getNotaBac() {
        return notaBac;
    }

    public String getTipExamen() {
        return tipExamen;
    }
}
