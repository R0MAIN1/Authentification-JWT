package chillo.tech.avis.controller;


import chillo.tech.avis.dto.AuthentificationDto;
import chillo.tech.avis.entite.Utilisateur;
import chillo.tech.avis.securite.JwtService;
import chillo.tech.avis.service.UtilisateurService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public class UtilisateurController {

    private final UtilisateurService utilisateurService;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;


    @PostMapping(path = "inscription")
    public void inscription(@RequestBody Utilisateur utilisateur){
        log.info("inscription");
        this.utilisateurService.inscription(utilisateur);
    }

    @PostMapping(path = "activation")
    public void activation(@RequestBody Map<String, String> activation){

        this.utilisateurService.activation(activation);
    }

    @PostMapping(path = "/connexion")
    public Map<String, String> connexion(@RequestBody AuthentificationDto authentificationDto){
       final Authentication authenticate = authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(authentificationDto.username(),authentificationDto.password())
       );
        if(authenticate.isAuthenticated()) {
           return this.jwtService.generate(authentificationDto.username());
        }
        return null;
    }
}
