package proiect.Service;

import proiect.Repository.CandidatRepository;
import proiect.Domain.Candidat;

public class CandidatService {

    private static CandidatService instance;

    private final CandidatRepository candidatRepository = CandidatRepository.getInstance();

    private CandidatService(){}

    public static CandidatService getInstance() {
        if(instance==null) {
            instance = new CandidatService();
        }

        return instance;
    }

    public Candidat saveCandidat(String nume, int varsta, float medieBac, float notaExamen) {
        Candidat candidat = new Candidat();
        candidat.setNume(nume);
        candidat.setVarsta(varsta);
        candidat.setMedieBac(medieBac);
        candidat.setNotaExamen(notaExamen);

        return candidatRepository.saveCandidat(candidat);
    }

    public Candidat findCandidat(String nume) {return candidatRepository.findCandidat(nume);}

    public Candidat updateCandidat(Candidat candidat){return candidatRepository.updateCandidat(candidat);}

    public boolean deleteCandidat(String nume) {return candidatRepository.deleteCandidat(nume);}


}
