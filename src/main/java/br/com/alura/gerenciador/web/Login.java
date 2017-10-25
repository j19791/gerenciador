package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();

		/* pegando os dados do login */
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");

		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);

		if (usuario == null) {/* validação p/ usuario */
			writer.println("<html><body>Usuário ou senha inválida</body></html>");/*
																				 * tratamento
																				 * qdo
																				 * invalido
																				 */
		} else {/* tratamento qdo valido */
			writer.println("<html><body>Usuário logado: " + email
					+ "</body></html>");

			HttpSession session = req.getSession();// acessa a sessão do
													// cliente. uma session será
													// criada agora e conectada
													// a este cliente.
			session.setAttribute("usuarioLogado", usuario);// para logar nosso
															// usuário na sessão
															// devemos usar o
															// método
															// setAttribute.

			/*
			 * cookie é um par de strings que é enviado do servidor para o
			 * cliente e fica lá por um tempo determinado. Toda vez que o
			 * cliente fizer uma requisição para o mesmo servidor, esse cookie
			 * será enviado de volta - e o servidor terá a opção de fazer algo
			 * com ele
			 */
			// Cookie cookie = new Cookie("usuario.logado", email);
			// resp.addCookie(cookie);
		}
	}
}
