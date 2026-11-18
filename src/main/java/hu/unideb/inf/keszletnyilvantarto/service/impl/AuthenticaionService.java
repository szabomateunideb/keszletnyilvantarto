package hu.unideb.inf.keszletnyilvantarto.service.impl;

import hu.unideb.inf.keszletnyilvantarto.data.entity.FelhasznaloEntity;
import hu.unideb.inf.keszletnyilvantarto.data.entity.JogEntity;
import hu.unideb.inf.keszletnyilvantarto.data.repository.FelhasznaloRepository;
import hu.unideb.inf.keszletnyilvantarto.data.repository.JogRepository;
import hu.unideb.inf.keszletnyilvantarto.service.dto.FelhasznaloLoginDto;
import hu.unideb.inf.keszletnyilvantarto.service.dto.FelhasznaloSaveDto;
import hu.unideb.inf.keszletnyilvantarto.service.mapper.FelhasznaloMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticaionService {

    private final FelhasznaloRepository frepo;
    private final FelhasznaloMapper fmapper;
    private final JogRepository jrepo;
    private final AuthenticationManager authManager;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public FelhasznaloSaveDto regisztracio(FelhasznaloSaveDto dto) {
        FelhasznaloEntity e = fmapper.toEntity(dto);
        JogEntity j = jrepo.findByNev("FELHASZNALO").orElse(null);

        if (j != null) {
            e.setJogosultsagok(Set.of(j));
        } else {
            j = new JogEntity();
            j.setNev("FELHASZNALO");
            j = jrepo.save(j);

            e.setJogosultsagok(Set.of(j));
        }

        e.setJelszo(passwordEncoder.encode(dto.getJelszo()));
        e = frepo.save(e);

        return fmapper.toSaveDto(e);
    }

    public String bejelentkezes(FelhasznaloLoginDto dto){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getFelhasznalonev(), dto.getJelszo()
                )
        );
        context.setAuthentication(auth);
        SecurityContextHolder.setContext(context);

        var user = frepo.findByFelhasznalonev(dto.getFelhasznalonev());
        return tokenService.generateToken(user);
    }
}
