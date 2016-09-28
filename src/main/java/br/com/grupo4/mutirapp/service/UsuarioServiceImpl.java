package br.com.grupo4.mutirapp.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.grupo4.mutirapp.model.Acao;
import br.com.grupo4.mutirapp.model.Usuario;
import br.com.grupo4.mutirapp.repository.UsuarioRepository;

@Component
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioRepository usuarioRepository;

	@Override
	public List<Acao> listarAcoes(String email) {
		List<Acao> lista =  (List<Acao>) usuarioRepository.findByEmail(email).getAcoes();
		return lista;
	}

	@Override
	public Usuario getUsuarioByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cadastrarUsuario(Usuario usuario) {
		System.out.println("USI: " + usuario);
		System.out.println("USI: " + usuarioRepository);
		this.usuarioRepository.save(usuario);
	}

	@Override
	public void alterarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub

	}
}
