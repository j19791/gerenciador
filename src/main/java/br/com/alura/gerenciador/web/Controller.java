package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//fazTudo é o controller: mapeia diversas uris
@WebServlet(urlPatterns = "/executa")
public class Controller extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String tarefa = req.getParameter("tarefa"); // qual tarefa quero
													// executar ?

		if (tarefa == null) // tratamento p/ caso o usario esquecer de passar
							// tarefa - lançar exception
			throw new IllegalArgumentException(
					"Você esqueceu de passar a tarefa");

		try {
			String nomeDaClasse = "br.com.alura.gerenciador.web." + tarefa; // nome
																			// da
																			// classe
																			// q
																			// desejamos
																			// executar

			Class type = Class.forName(nomeDaClasse); // API de Java que permite
														// a criação dinâmica de
														// objetos, sem saber o
														// tipo deles em tempo
														// de compilação

			Tarefa instancia = (Tarefa) type.newInstance();

			String pagina = instancia.executa(req, resp);// retorna pagina jsp
															// para ser
															// redirecionada

			RequestDispatcher requestDispatcher = req
					.getRequestDispatcher(pagina);
			requestDispatcher.forward(req, resp); // REDIRECIONA

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}