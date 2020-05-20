package proiect.Service;

import proiect.Repository.FacultateRepository;
import proiect.Domain.Facultate;

public class FacultateService {

    private static FacultateService instance;

    private final FacultateRepository facultateRepository = FacultateRepository.getInstance();

    private FacultateService(){}

    public static FacultateService getInstance() {
        if(instance==null) {
            instance = new FacultateService();
        }

        return instance;
    }

    public Facultate saveFacultate(String nume, String locatie, int numarTotalLocuri) {
        Facultate facultate = new Facultate();
        facultate.setNume(nume);
        facultate.setLocatie(locatie);
        facultate.setNumarTotalLocuri(numarTotalLocuri);

        return facultateRepository.saveFaculty(facultate);
    }

    public Facultate findFacultate(String nume) {return facultateRepository.findFaculty(nume);}

    public Facultate updateFacultate(Facultate facultate){return facultateRepository.updateFacultate(facultate);}

    public boolean deleteFacultate(String nume) {return facultateRepository.deleteFacultate(nume);}


}
