package br.com.alura.gerenciador.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/logout")
public class Logout implements Tarefa {
	// extends HttpServlet
	public String executa(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();

		session.removeAttribute("usuarioLogado");

		// session.invalidate();

		// Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();

		// if (cookie != null) {
		// cookie.setMaxAge(0); /*
		// * mata o cookie passando o tempo de expiração =
		// * 0 (min)
		// */
		// resp.addCookie(cookie); /* devolve na resposta o cookie morto */
		// }

		// PrintWriter writer = response.getWriter();

		// writer.println("<html><body>Logout efetuado</body></html>");

		// resp.sendRedirect("logout.html"); // redirecionamento p/ o arquivo
		// logout.html- separando a view do
		// modelo de negócio
		// feito no lado do cliente, através de um retorno de código diferente
		// de 200 (ok), como o 302 (found) - que notifica o usuário final onde
		// deve procurar o resultado de sua requisição.

		// fazer um forward no lado do servidor - o cliente nao fica sabendo do
		// redirecionamento
		// RequestDispatcher dispatcher = req
		// .getRequestDispatcher("/WEB-INF/paginas/logout.html");

		// dispatcher.forward(req, resp); utilizando o executa, agora o fazTudo
		// faz o redirecionamento
		return "/WEB-INF/paginas/logout.html";
	}

}
