package br.com.grupo4.mutirapp.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.grupo4.mutirapp.model.Usuario;
import br.com.grupo4.mutirapp.rn.UsuarioRN;

@ManagedBean
@RequestScoped
public class UsuarioBean {

	private Usuario usuario;
	private String confirmacaoSenha;
	
	public UsuarioBean() {
		this.usuario = new Usuario();
	}

	/*
	 * Actions
	 */

	public String novo() {
		this.usuario = new Usuario();
		return "/usuario/perfil";
	}

	public String editar() {
		return "/usuario/perfil";
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		String senha = this.usuario.getSenha();

		if (!senha.equals(this.confirmacaoSenha)) {
			FacesMessage message = new FacesMessage("A senha não foi confirmada corretamente.");
			context.addMessage(null, message);
			return null;
		}
		
		FacesMessage message = new FacesMessage("Operação realizada com sucesso.");
		context.addMessage(null, message);
		
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(usuario);
		return null;
	}

	public String excluir() {
		return null;
	}

	/*
	 * Getters e setters
	 */
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}

}
