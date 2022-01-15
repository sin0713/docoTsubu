package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeleteMutterListLogic;
import model.GetMutterListLogic;
import model.Mutter;

/**
 * Servlet implementation class DeleteMutter
 */
@WebServlet("/DeleteMutter")
public class DeleteMutter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
  	String mutterId =  request.getParameter("id");

    DeleteMutterListLogic deleteMutterLogic = new DeleteMutterListLogic();
    deleteMutterLogic.execute(mutterId);

    GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
  	List<Mutter> mutterList = getMutterListLogic.execute();
  	request.setAttribute("mutterList", mutterList);

  	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
  	dispatcher.forward(request, response);
	}

}
