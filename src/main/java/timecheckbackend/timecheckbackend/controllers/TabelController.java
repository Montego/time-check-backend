package timecheckbackend.timecheckbackend.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import timecheckbackend.timecheckbackend.entities.Tabel;
import timecheckbackend.timecheckbackend.repositoires.TabelRepository;

import java.util.List;

@RestController
@RequestMapping("api/tabel")
public class TabelController {
    private final TabelRepository tabelRepository;

    @Autowired
    public TabelController(TabelRepository tabelRepository) {
        this.tabelRepository = tabelRepository;
    }

    @GetMapping
    public List<Tabel> list() {
        return tabelRepository.findAll();
    }

    @GetMapping("{id}")
    public Tabel getOne(@PathVariable("id") Tabel tabel) {
        return tabel;
    }

    @PostMapping()
    public Tabel create(@RequestBody Tabel tabel) {
//        employer.setCreationDate(LocalDateTime.now());
        return tabelRepository.save(tabel);
    }

    @PutMapping("{id}")
    public Tabel update(
            @PathVariable("id") Tabel tabelFromDB,
            @RequestBody Tabel tabel) {
        BeanUtils.copyProperties(tabel, tabelFromDB, "id");
        return tabelRepository.save(tabelFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Tabel tabel) {
        tabelRepository.delete(tabel);
    }
}
