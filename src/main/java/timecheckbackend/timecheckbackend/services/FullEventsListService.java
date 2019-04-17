package timecheckbackend.timecheckbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timecheckbackend.timecheckbackend.entities.Employer;
import timecheckbackend.timecheckbackend.entities.Event;
import timecheckbackend.timecheckbackend.entities.FullEventsList;
import timecheckbackend.timecheckbackend.entities.Tabel;
import timecheckbackend.timecheckbackend.repositoires.EmployerRepository;
import timecheckbackend.timecheckbackend.repositoires.EventRepository;
import timecheckbackend.timecheckbackend.repositoires.FullEventsListRepository;
import timecheckbackend.timecheckbackend.repositoires.TabelRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class FullEventsListService {
    private final FullEventsListRepository fullEventsListRepository;
    private final EmployerRepository employerRepository;
    private final EventRepository eventRepository;
    private final TabelRepository tabelRepository;

    @Autowired
    public FullEventsListService(FullEventsListRepository fullEventsListRepository, EmployerRepository employerRepository, EventRepository eventRepository, TabelRepository tabelRepository) {
        this.fullEventsListRepository = fullEventsListRepository;
        this.employerRepository = employerRepository;
        this.eventRepository = eventRepository;
        this.tabelRepository = tabelRepository;
    }

    public void save(FullEventsList fullEventsList){
        fullEventsListRepository.save(fullEventsList);
    }

    public void delete(Long id){
        fullEventsListRepository.deleteById(id);
    }

    public List<FullEventsList> getAll(){
//        List<Employer> employersInfo = employerRepository.findAllByLastnameAndFirstnameAndBirthday();
        List<Employer> employers = employerRepository.findAll();
        List<Event> events = eventRepository.findAll();
        List<Tabel> tabel = tabelRepository.findAll();

        List<FullEventsList> fullEventsListsEmployers = new ArrayList<>();
        Long id=0L;
        for(int i=0;i<employers.size();i++){
//            String birthday = employersInfo.get(i).getBirthday();
            String employerLastnameFirstname = employers.get(i).getLastname() + " " + employers.get(i).getFirstname();
//            Long id = employers.get(i).getId();
            id++;
            FullEventsList fullEventsList = new FullEventsList();
            fullEventsList.setDate_of(employers.get(i).getBirthday());
            fullEventsList.setName("День рождения");
            fullEventsList.setFull_info("День рождения у сотрудника: "+ employerLastnameFirstname);
            fullEventsList.setId(id);
            fullEventsListsEmployers.add(fullEventsList);
        }

        for(int i = 0;i<events.size();i++){
            id++;
            FullEventsList fullEventsList = new FullEventsList();
            fullEventsList.setDate_of(events.get(i).getDate_of());
            fullEventsList.setName(events.get(i).getName());
            fullEventsList.setFull_info(events.get(i).getFull_info());
            fullEventsList.setId(id);
            fullEventsListsEmployers.add(fullEventsList);
        }
        for(int i = 0;i<tabel.size();i++){
            String employer = tabel.get(i).getEmployer().getLastname() + " " + tabel.get(i).getEmployer().getFirstname();
            id++;
            FullEventsList fullEventsList = new FullEventsList();
            fullEventsList.setDate_of(tabel.get(i).getDate_of());
//            String employerLastnameFirstname = employers.get(i).getLastname() + " " + employers.get(i).getFirstname();
            if(tabel.get(i).getOvertime()!=0){
                fullEventsList.setName("Переработки");
                fullEventsList.setFull_info("Переработки у сотрудника: " + employer + ", в размере - " + tabel.get(i).getOvertime() +" ч.");
            }
            if(tabel.get(i).getLesstime()!=0){
                fullEventsList.setName("Недоработки");
                fullEventsList.setFull_info("Недоработки у сотрудника: " + employer + ", в размере - " + tabel.get(i).getLesstime() +" ч.");
            }
            if(tabel.get(i).getSeakleave()!=0){
                fullEventsList.setName("Больничный");
                fullEventsList.setFull_info("Больничный у сотрудника: " + employer + ", сроком - " + tabel.get(i).getSeakleave() +" д.");
            }
            if(tabel.get(i).getTime_off()!=0){
                fullEventsList.setName("Отгул");
                fullEventsList.setFull_info("Отгул у сотрудника: " + employer + ", сроком - " + tabel.get(i).getTime_off() +" д.");
            }
            if(tabel.get(i).getVacation()!=0){
                fullEventsList.setName("Отпуск");
                fullEventsList.setFull_info("Отпуск у сотрудника: " + employer + ", сроком - " +tabel.get(i).getVacation() +" д.");
            }

            fullEventsList.setId(id);
            fullEventsListsEmployers.add(fullEventsList);
        }


//        return fullEventsListRepository.findAll();
            return fullEventsListsEmployers;
    }

    public FullEventsList getOne(Long id){
        return fullEventsListRepository.findById(id).orElse(null);
    }
}
