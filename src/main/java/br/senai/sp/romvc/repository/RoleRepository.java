package br.senai.sp.romvc.repository;

import br.senai.sp.romvc.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleRepository extends JpaRepository<Role, Long> {
}
