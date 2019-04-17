package timecheckbackend.timecheckbackend.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import timecheckbackend.timecheckbackend.entities.Employer;
import timecheckbackend.timecheckbackend.entities.Tabel;
import timecheckbackend.timecheckbackend.payloads.TabelRequest;
import timecheckbackend.timecheckbackend.payloads.TabelResponse;
import timecheckbackend.timecheckbackend.services.EmployerService;
import timecheckbackend.timecheckbackend.services.TabelService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/tabel")
public class TabelController {
    private final TabelService tabelService;
    private final EmployerService employerService;

    @Autowired
    public TabelController(TabelService tabelService, EmployerService employerService) {
        this.tabelService = tabelService;
        this.employerService = employerService;
    }

//    @GetMapping
//    public List<Tabel> list() {
//        return tabelService.getAll();
//    }

    @GetMapping
    public List<TabelResponse> list() {
        return tabelService.getAllTabelResponse();
    }

    @GetMapping("{id}")
    public Tabel getOne(@PathVariable Long id) {
        return tabelService.getOne(id);
    }

    @PostMapping()
    public TabelResponse create(@RequestBody TabelRequest tabelRequest) {

        Employer employer = employerService.getOne(tabelRequest.getFullname());
        String fullname = employer.getFullname();
//        Set<Tabel> tabels = new HashSet<>();
//        tabels.add(tabelService.getOne(tabelRequest.getId()));
//        employer.setTabel(tabels);

        System.out.println("save tabel");
        Tabel tabel = new Tabel(
                tabelRequest.getId(),
                tabelRequest.getDate_of(),
                tabelRequest.getOvertime(),
                tabelRequest.getLesstime(),
                tabelRequest.getSeakleave(),
                tabelRequest.getTime_off(),
                tabelRequest.getVacation(),
                employer);
        tabelService.add(tabel);

        TabelResponse tabelResponse = new TabelResponse(
                tabelRequest.getId(),
                fullname,
                tabelRequest.getDate_of(),
                tabelRequest.getOvertime(),
                tabelRequest.getLesstime(),
                tabelRequest.getSeakleave(),
                tabelRequest.getTime_off(),
                tabelRequest.getVacation());
        return tabelResponse;
    }


    @PutMapping("{id}")
    public TabelResponse update(
            @PathVariable Long id,
            @RequestBody TabelRequest tabelRequest
    ){
        Tabel tabelFromDB = tabelService.getOne(id);

        Employer employer = employerService.getOne(tabelRequest.getFullname());
        String fullname = employer.getFullname();
        Tabel tabel = new Tabel(
                tabelRequest.getId(),
                tabelRequest.getDate_of(),
                tabelRequest.getOvertime(),
                tabelRequest.getLesstime(),
                tabelRequest.getSeakleave(),
                tabelRequest.getTime_off(),
                tabelRequest.getVacation(),
                employer);
        TabelResponse tabelResponse = new TabelResponse(
                tabelRequest.getId(),
                fullname,
                tabelRequest.getDate_of(),
                tabelRequest.getOvertime(),
                tabelRequest.getLesstime(),
                tabelRequest.getSeakleave(),
                tabelRequest.getTime_off(),
                tabelRequest.getVacation());

        System.out.println("update tabel");
        BeanUtils.copyProperties(tabel, tabelFromDB, "id");
        return tabelResponse;
    }

//    @PutMapping("{id}")
//    public Tabel update(
//            @PathVariable("id") Tabel tabelFromDB,
//            @RequestBody Tabel tabel) {
//        BeanUtils.copyProperties(tabel, tabelFromDB, "id");
//        return tabelService.(tabelFromDB);
//    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        tabelService.delete(id);
    }
}
