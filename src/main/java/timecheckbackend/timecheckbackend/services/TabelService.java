package timecheckbackend.timecheckbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timecheckbackend.timecheckbackend.entities.Tabel;
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

    public void add(Tabel tabel) {
        tabelRepository.save(tabel);
    }

    public void delete(Long id) {
        tabelRepository.deleteById(id);
    }

    public List<Tabel> getAll() {
        return tabelRepository.findAll();
    }

    public List<TabelResponse> getAllTabelResponse() {
        List<Tabel> tabels = tabelRepository.findAll();
        List<TabelResponse> tabelsResponse = new ArrayList<>();
        for (int i = 0; i < tabels.size(); i++) {
            TabelResponse tabelResponse = new TabelResponse(
                    tabels.get(i).getId(),
                    tabels.get(i).getEmployer().getFullname(),
                    tabels.get(i).getDate_of(),
                    tabels.get(i).getOvertime(),
                    tabels.get(i).getLesstime(),
                    tabels.get(i).getSeakleave(),
                    tabels.get(i).getTime_off(),
                    tabels.get(i).getVacation()
            );
            tabelsResponse.add(tabelResponse);
        }
        return tabelsResponse;
    }

    public Tabel getOne(Long id) {
        return tabelRepository.findById(id).orElse(null);
    }
}
