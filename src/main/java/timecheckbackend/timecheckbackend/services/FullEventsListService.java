package timecheckbackend.timecheckbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timecheckbackend.timecheckbackend.entities.FullEventsList;
import timecheckbackend.timecheckbackend.repositoires.FullEventsListRepository;

import java.util.List;
@Service
public class FullEventsListService {
    private final FullEventsListRepository fullEventsListRepository;
    @Autowired
    public FullEventsListService(FullEventsListRepository fullEventsListRepository) {
        this.fullEventsListRepository = fullEventsListRepository;
    }

    public void save(FullEventsList fullEventsList){
        fullEventsListRepository.save(fullEventsList);
    }

    public void delete(Long id){
        fullEventsListRepository.deleteById(id);
    }

    public List<FullEventsList> getAll(){
        return fullEventsListRepository.findAll();
    }

    public FullEventsList getOne(Long id){
        return fullEventsListRepository.findById(id).orElse(null);
    }
}
