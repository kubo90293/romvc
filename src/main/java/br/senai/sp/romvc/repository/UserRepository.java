package br.senai.sp.romvc.repository;




import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends
        JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUsername(String username);
}