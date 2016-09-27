package br.com.grupo4.mutirapp.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.grupo4.mutirapp.model.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioBean {

	private Usuario usuario;
	private String confirmacaoSenha;

	/*
	 * Actions
	 */

	public String novo() {
		return "/usuario/cadastrar";
	}

	public String editar() {
		return "/usuario/perfil";
	}

	public String salvar() {
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
