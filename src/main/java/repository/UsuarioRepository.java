package repository;

import org.springframework.data.repository.CrudRepository;

import br.com.grupo4.mutirapp.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

}
