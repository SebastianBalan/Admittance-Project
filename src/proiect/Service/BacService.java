package proiect.Service;

import proiect.Repository.BacRepository;
import proiect.Domain.Bac;

public class BacService {

    private static BacService instance;

    private final BacRepository bacRepository = BacRepository.getInstance();

    private BacService(){}

    public static BacService getInstance() {
        if(instance==null) {
            instance = new BacService();
        }

        return instance;
    }

    public Bac saveBac(int notaExamen, String tipExamen) {
        Bac bac = new Bac();
        bac.setNotaBac(notaExamen);
        bac.setTipExamen(tipExamen);

        return bacRepository.saveBac(bac);
    }

    public Bac findBac(String tipExamen) {return bacRepository.findBac(tipExamen);}

    public Bac updateBac(Bac bac){return bacRepository.updateBac(bac);}

    public boolean deleteBac(int notaBac) {return bacRepository.deleteBac(notaBac);}


}
