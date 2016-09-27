package br.com.grupo4.mutirapp.service;

import java.util.List;

import br.com.grupo4.mutirapp.model.Acao;
import br.com.grupo4.mutirapp.model.Usuario;

public interface UsuarioService {
	public List<Acao> listarAcoes(String email);
	public Usuario getUsuarioByEmail(String email);
	public void cadastrarUsuario(Usuario usuario);
	public void alterarUsuario(Usuario usuario);
}
