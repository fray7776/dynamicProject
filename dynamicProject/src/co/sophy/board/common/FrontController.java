package co.sophy.board.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sophy.board.web.BoardDelete;
import co.sophy.board.web.BoardList;
import co.sophy.board.web.BoardUp;
import co.sophy.board.web.BoardUpdate;
import co.sophy.board.web.MainCommand;
import co.sophy.board.web.NewBoard;
import co.sophy.board.web.WriteNewBoard;
import co.sophy.board.web.LookBoard;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = new HashMap<String, Command>();
    
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand());
		map.put("/BoardList.do", new BoardList());
		map.put("/boardView.do", new LookBoard());
		map.put("/boardDelete.do", new BoardDelete());
		map.put("/boardUpdate.do", new BoardUpdate());
		map.put("/newBoard.do", new NewBoard());
		map.put("/writeNewBoard.do", new WriteNewBoard());
		map.put("/boardEdit.do", new BoardUp());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length());
		
		Command command = map.get(path); //command(interface만들어놓은)를 초기화해서 path 가져오기
		String viewPage = command.excute(request, response); //여기서 .do로 들어오면 if문을 안거치고 바로 dispatcher로 간다. 
		
		if(!viewPage.endsWith(".do")) viewPage = "/WEB-INF/jsp/" + viewPage + ".jsp"; 
		//view resolve(web-inf밑에 있는 jsp를 외부에서 접근할 수 없고, servlet만(tomcat) 접근가능하니까)
		//.jsp로 들어오면 /WEB-INF/jsp/를 더하라는.. 그래서 페이지를 찾을 수 있음
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}
}
