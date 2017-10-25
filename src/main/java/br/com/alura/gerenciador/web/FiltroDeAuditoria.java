package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns = "/*")
/* filtro sera utilizado p/ qq requisicao */
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/* doFilter é executado toda vez que uma requisição passa por este filtro: */
	@Override
	public void doFilter(ServletRequest request, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		// Cookie cookie = getUsuario(req);
		// substituida o getusuario pelo getUsuarioLogado da nova classe Cookies
		// Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();

		HttpSession session = req.getSession();
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

		String usuario = "<deslogado>";

		if (usuarioLogado != null) {
			usuario = usuarioLogado.getEmail();
		}

		// if (cookie != null) {/* request possui um cookie */
		// usuario = cookie.getValue(); /*
		// * retorna o valor do cookie - nome do
		// * usuario
		// */
		// cookie.setMaxAge(60 * 10); // adia a expiração do cookie para mais
		// 10min

		// HttpServletResponse resposta = (HttpServletResponse) resp;

		// resposta.addCookie(cookie);/*
		// * devolve o cookie autenticado para o
		// * usuario
		// */
		// }

		System.out.println("Usuario " + usuario + " acessando a URI "
				+ req.getRequestURI());

		chain.doFilter(req, resp);/* p/ q o filtro chame a servlet */
	}

	private Cookie getUsuario(HttpServletRequest req) {

		/* pegar o usuário atual, se ele existir. */
		Cookie[] cookies = req.getCookies();

		/*
		 * tratamento qdo nao tem cookie - para nao dar erro de
		 * nullPointerException
		 */
		if (cookies == null)
			return null;

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("usuarioLogado")) {
				return cookie;
			}
		}

		return null;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
