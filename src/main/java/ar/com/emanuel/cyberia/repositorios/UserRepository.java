package ar.com.emanuel.cyberia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.emanuel.cyberia.domain.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long>{

	public List<Usuario> findByEmail(String email);
}
