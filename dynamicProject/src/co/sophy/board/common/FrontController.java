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
		
		Command command = map.get(path); //command(interface��������)�� �ʱ�ȭ�ؼ� path ��������
		String viewPage = command.excute(request, response); //���⼭ .do�� ������ if���� �Ȱ�ġ�� �ٷ� dispatcher�� ����. 
		
		if(!viewPage.endsWith(".do")) viewPage = "/WEB-INF/jsp/" + viewPage + ".jsp"; 
		//view resolve(web-inf�ؿ� �ִ� jsp�� �ܺο��� ������ �� ����, servlet��(tomcat) ���ٰ����ϴϱ�)
		//.jsp�� ������ /WEB-INF/jsp/�� ���϶��.. �׷��� �������� ã�� �� ����
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}
}
