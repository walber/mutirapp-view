package br.com.grupo4.mutirapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.grupo4.mutirapp.util.HibernateUtil;

@WebFilter(urlPatterns = { "*.jsf", "*.xhtml" })
public class ConexaoHibernateFilter implements Filter {

	private SessionFactory sessionFactory;

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Transaction transaction = null;

		try {
			transaction = currentSession.beginTransaction();
			chain.doFilter(request, response);
			transaction.commit();

			if (currentSession.isOpen()) {
				currentSession.close();
			}
		} catch (Throwable e) {
			try {
				if (transaction.isActive()) {
					transaction.rollback();
				}
			} catch (Throwable t) {
				t.printStackTrace();
			}
			throw new ServletException(e);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

}
