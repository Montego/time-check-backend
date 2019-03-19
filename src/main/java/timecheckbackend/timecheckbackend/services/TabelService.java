package timecheckbackend.timecheckbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timecheckbackend.timecheckbackend.repositoires.TabelRepository;

@Service
public class TabelService {
    private final TabelRepository tabelRepository;

    @Autowired
    public TabelService(TabelRepository tabelRepository) {
        this.tabelRepository = tabelRepository;
    }
}
