package proiect.Domain;


import proiect.Domain.Candidat;

import java.util.Comparator;

public class CandidatNumeComparator implements Comparator<Candidat> {

    @Override
    public int compare(Candidat o1, Candidat o2) {
        return o1.getNume().compareTo(o2.getNume());
    }
}
