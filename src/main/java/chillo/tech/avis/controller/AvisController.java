package chillo.tech.avis.controller;

import chillo.tech.avis.entite.Avis;
import chillo.tech.avis.service.AvisService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(path = "avis")
public class AvisController {
    private final AvisService avisService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void creer(@RequestBody Avis avis){
        this.avisService.creer(avis);
    }
}
