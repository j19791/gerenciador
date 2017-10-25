package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;

public class Cookies {

	private final Cookie[] cookies;/*
									 * Um objeto que recebe os dados no
									 * construtor, não tem setters e tem todos
									 * os atributos como final é chamado de
									 * Imutável, pois seus dados não mudam.
									 */

	public Cookies(Cookie[] cookies) {
		this.cookies = cookies;
	}

	/* extrai o usuario logado */
	public Cookie getUsuarioLogado() {
		if (cookies == null)
			return null; // retorna null se nao tem cookie
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("usuario.logado")) {
				return cookie; // retorna o cookie caso exista
			}
		}
		return null;
	}

}
