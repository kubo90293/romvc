package br.senai.sp.romvc.service;

import br.senai.sp.romvc.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //GAMBIARRA PRA RODAR
   // @Override
    //public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      //  return null;
    //}

    // É PRA USAR ESSE
    @Override
  public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return (UserDetails) UserRepository.findByUsername(username);

    }

}
