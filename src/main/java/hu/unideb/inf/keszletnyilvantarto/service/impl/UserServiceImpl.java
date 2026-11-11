package hu.unideb.inf.keszletnyilvantarto.service.impl;

import hu.unideb.inf.keszletnyilvantarto.data.repository.FelhasznaloRepository;
import hu.unideb.inf.keszletnyilvantarto.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final FelhasznaloRepository frepo;

    public UserServiceImpl(FelhasznaloRepository frepo) {
        this.frepo = frepo;
    }

    @Override
    public UserDetailsService getUserDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return frepo.findByFelhasznalonev(username);
            }
        };
    }
}
