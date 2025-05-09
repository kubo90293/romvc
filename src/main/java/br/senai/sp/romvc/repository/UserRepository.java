package br.senai.sp.romvc.repository;





import br.senai.sp.romvc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends
        JpaRepository<User, Long> {
    User findByEmail(String email);

    static User findByUsername(String username) {
        return null;
    }
}