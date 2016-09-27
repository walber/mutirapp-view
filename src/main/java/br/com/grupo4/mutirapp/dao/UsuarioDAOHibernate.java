package br.com.grupo4.mutirapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.grupo4.mutirapp.model.Usuario;

public class UsuarioDAOHibernate implements UsuarioDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Usuario usuario) {
		this.session.save(usuario);
	}

	@Override
	public void atualizar(Usuario usuario) {
		this.session.update(usuario);
	}

	@Override
	public void excluir(Usuario usuario) {
		this.session.delete(usuario);
	}

	@Override
	public Usuario buscarPorId(Integer id) {
		return (Usuario) this.session.get(Usuario.class, id);
	}

	@Override
	public Usuario buscarPorLogin(String login) {
		Criteria criteria = this.session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("login", login));
		return (Usuario) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listar() {
		return (List<Usuario>) this.session.createCriteria(Usuario.class).list();
	}

}
