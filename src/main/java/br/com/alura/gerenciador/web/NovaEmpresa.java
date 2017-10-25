package br.com.alura.gerenciador.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/novaEmpresa")
public class NovaEmpresa implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		// public class NovaEmpresa {
		// @Override
		// protected void doPost(HttpServletRequest req, HttpServletResponse
		// resp)
		// throws ServletException, IOException {/*
		// * post é melhor p/ receber
		// * dados
		// */

		String nome = req.getParameter("nome");

		Empresa empresa = new Empresa(nome);

		new EmpresaDAO().adiciona(empresa);

		// PrintWriter writer = resp.getWriter();
		// writer.println("<html><body>Empresa " + nome
		// + " adicionada!</body></html>");

		req.setAttribute("nome", nome); // passar a variável para o jsp

		/*
		 * RequestDispatcher dispatcher = req
		 * .getRequestDispatcher("/WEB-INF/paginas/novaEmpresa.jsp");
		 * dispatcher.forward(req, resp);
		 */

		return "/WEB-INF/paginas/novaEmpresa.jsp";

	}
}
