package br.com.alura.gerenciador.web;

import java.util.Collection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/busca")
/* parametro passado na url - p/ chegar até aqui */
// public class BuscaEmpresa extends HttpServlet {
// protected void doGet(HttpServletRequest req, HttpServletResponse resp)
// throws ServletException, IOException { /* trata requisição */
public class BuscaEmpresa implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		// PrintWriter writer = resp.getWriter(); /*
		// * ctrl + 2, l add local
		// * variable
		// */

		// writer.println("<html>");
		// writer.println("<body>");

		// writer.println("Resultado da busca:<br/>");

		String filtro = req.getParameter("filtro"); /*
													 * pega o valor do parametro
													 * filtro passado na url
													 */
		Collection<Empresa> empresas = new EmpresaDAO()
				.buscaPorSimilaridade(filtro);/*
											 * faz uma busca a partir do filtro
											 * passado, exemplo:
											 * http://localhost
											 * :8080/gerenciador/
											 * busca?filtro=doce
											 */

		// writer.println("<ul>");
		// for (Empresa empresa : empresas) {/*
		// * com a collection empresas, faz um
		// * foreach
		// */
		// writer.println("<li>" + empresa.getId() + ": " + empresa.getNome()
		// + "</li>");
		// }
		// writer.println("</ul>");

		// writer.println("</body>");
		// writer.println("</html>");

		req.setAttribute("empresas", empresas);

		// RequestDispatcher dispatcher = req
		// .getRequestDispatcher("/WEB-INF/paginas/buscaEmpresa.jsp");
		// dispatcher.forward(req, resp);

		return "/WEB-INF/paginas/buscaEmpresa.jsp";
	}

}
