package br.com.grupo4.mutirapp.rn;

import java.util.List;

import br.com.grupo4.mutirapp.dao.UsuarioDAO;
import br.com.grupo4.mutirapp.model.Usuario;
import br.com.grupo4.mutirapp.util.DAOFactory;

public class UsuarioRN {

	private UsuarioDAO usuarioDAO;

	public UsuarioRN() {
		this.usuarioDAO = DAOFactory.buildUsuarioDAO();
	}

	public void salvar(Usuario usuario) {
		Integer id = usuario.getId();

		if (id == null || id.equals(0)) {
			this.usuarioDAO.salvar(usuario);
		} else {
			this.usuarioDAO.atualizar(usuario);
		}
	}

	public void atualizar(Usuario usuario) {
		this.usuarioDAO.atualizar(usuario);
	}

	public void excluir(Usuario usuario) {
		this.usuarioDAO.excluir(usuario);
	}

	public Usuario buscarPorId(Integer id) {
		return this.usuarioDAO.buscarPorId(id);
	}

	public Usuario buscarPorLogin(String login) {
		return this.usuarioDAO.buscarPorLogin(login);
	}

	public List<Usuario> listar() {
		return this.usuarioDAO.listar();
	}

}
