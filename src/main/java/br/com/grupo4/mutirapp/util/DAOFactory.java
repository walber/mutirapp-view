package br.com.grupo4.mutirapp.util;

import br.com.grupo4.mutirapp.dao.UsuarioDAO;
import br.com.grupo4.mutirapp.dao.UsuarioDAOHibernate;

public class DAOFactory {

	public static UsuarioDAO buildUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}

}
