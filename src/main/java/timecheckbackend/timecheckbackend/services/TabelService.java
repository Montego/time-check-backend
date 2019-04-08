package timecheckbackend.timecheckbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timecheckbackend.timecheckbackend.entities.Tabel;
import timecheckbackend.timecheckbackend.repositoires.TabelRepository;

import java.util.List;

@Service
public class TabelService {
    private final TabelRepository tabelRepository;

    @Autowired
    public TabelService(TabelRepository tabelRepository) {
        this.tabelRepository = tabelRepository;
    }

    public void add(Tabel tabel){
        tabelRepository.save(tabel);
    }

    public void delete(Long id){
        tabelRepository.deleteById(id);
    }

    public List<Tabel> eventsList(){
        return tabelRepository.findAll();
    }

    public Tabel getOneEvent(Long id){
        return tabelRepository.findById(id).orElse(null);
    }
}
