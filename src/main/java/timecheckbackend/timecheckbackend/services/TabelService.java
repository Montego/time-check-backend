package timecheckbackend.timecheckbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timecheckbackend.timecheckbackend.entities.FullEventsList;
import timecheckbackend.timecheckbackend.entities.Tabel;
import timecheckbackend.timecheckbackend.payloads.EmployerResponse;
import timecheckbackend.timecheckbackend.payloads.TabelResponse;
import timecheckbackend.timecheckbackend.repositoires.FullEventsListRepository;
import timecheckbackend.timecheckbackend.repositoires.TabelRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TabelService {
    private final TabelRepository tabelRepository;
    private final FullEventsListRepository fullEventsListRepository;
    @Autowired
    public TabelService(TabelRepository tabelRepository, FullEventsListRepository fullEventsListRepository) {
        this.tabelRepository = tabelRepository;
        this.fullEventsListRepository = fullEventsListRepository;
    }

    public void add(Tabel tabel){
        tabelRepository.save(tabel);

//        String employerLastname = tabel.getEmployer().getLastname();
//        String employerFirstname = tabel.getEmployer().getFirstname();
//        String employerFull = employerLastname + " " + employerFirstname;
//
//
//        FullEventsList fullEventsList = new FullEventsList();
//
//
//        fullEventsListRepository.save(fullEventsList);
    }

    public void delete(Long id){
        tabelRepository.deleteById(id);
    }

    public List<Tabel> getAll(){
        return tabelRepository.findAll();
    }

    public List<TabelResponse> getAllResponse(){
        List<Tabel> tabels = tabelRepository.findAll();
        List<TabelResponse> tabelsResponse = new ArrayList<>();
        for (int i = 0; i<tabels.size();i++){
            TabelResponse tabelResponse = new TabelResponse();
            tabelResponse.setId(tabels.get(i).getId());
            tabelResponse.setDate_of(tabels.get(i).getDate_of());
            tabelResponse.setFullname(tabels.get(i).getEmployer().getFullname());
            tabelResponse.setLesstime(tabels.get(i).getLesstime());
            tabelResponse.setOvertime(tabels.get(i).getOvertime());
            tabelResponse.setSeakleave(tabels.get(i).getSeakleave());
            tabelResponse.setTime_off(tabels.get(i).getTime_off());
            tabelResponse.setVacation(tabels.get(i).getVacation());
            tabelsResponse.add(tabelResponse);
        }
        return tabelsResponse;
    }

    public Tabel getOne(Long id){
        return tabelRepository.findById(id).orElse(null);
    }
}
