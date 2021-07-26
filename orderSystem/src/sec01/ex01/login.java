package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class login
 */
@WebServlet("/login/*")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO memberDAO;
	
	public void init() throws ServletException{
		memberDAO = new MemberDAO();
		}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String nextPage= null;
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out = response.getWriter();
	String action = request.getPathInfo();
	
	if (action.equals("/listMembers.do")) {
		List<MemberVO> membersList = memberDAO.listMembers();
		request.setAttribute("membersList", membersList);
		nextPage = "/listMembers.jsp";
	
	}
	
	
	else if (action.equals("/addMember.do")) {
		String new_id = request.getParameter("ts_id");
		String new_pwd = request.getParameter("ts_pwd");
		String new_bdname = request.getParameter("ts_bdname");
		String new_bdno= request.getParameter("ts_bdno");
		String new_phone = request.getParameter("ts_phone");
		MemberVO vo = new MemberVO(new_id, new_pwd, new_bdname, new_bdno, new_phone);
		memberDAO.addMember(vo);
		request.setAttribute("msg", "addMember");
		nextPage="/loginForm.jsp";
		
	}else if (action.equals("/loginCheck.do")) {
		String new_id = request.getParameter("ts_id");
		String new_pwd = request.getParameter("ts_pwd");
		MemberVO vo = new MemberVO(new_id, new_pwd);
		memberDAO.loginCheck(vo);
		Boolean result = memberDAO.loginCheck(vo);
		
		if(new_id.equals("admin")){
			nextPage="/adminView.jsp";
		}
		
		
		else if(result) {
			 
			HttpSession session = request.getSession();
			session.setAttribute("isLogon", true);
			session.setAttribute("login.id", new_id);
			session.setAttribute("login.pwd", new_pwd);
			request.setAttribute("msg", "login");
			nextPage = "/menu.jsp";
		 
			
			
		}else {
			out.print("<html><body>회원 정보가 틀립니다.");
			out.print("<a href='loginForm.jsp'>다시 로그인하기</a>");
			out.print("</body></html>");
		}
		
		
	
		
	}else if (action.equals("/modMemberForm.do")) {
		String ts_id = request.getParameter("ts_id");
		MemberVO memInfo = memberDAO.findMember(ts_id);
		request.setAttribute("memInfo", memInfo);
		nextPage = "/modMemberForm.jsp";
		
	}else if(action.equals("/modMember.do")) {
		String ts_id = request.getParameter("ts_id");
		String ts_pwd = request.getParameter("ts_pwd");
		String ts_bdname = request.getParameter("ts_bdname");
		String ts_bdno = request.getParameter("ts_bdno");
		String ts_phone = request.getParameter("ts_phone");
		MemberVO memberVO = new MemberVO(ts_id, ts_pwd, ts_bdname, ts_bdno, ts_phone);
		memberDAO.modMember(memberVO);
		request.setAttribute("msg", "modified");
		nextPage = "/login/listMembers.do";
		
	}
	else if (action.equals("/delMember.do")) {
		String ts_id = request.getParameter("ts_id");
		memberDAO.delMember(ts_id);
		request.setAttribute("msg", "deleted");
		nextPage =  "/login/listMembers.do";
	}
	RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
	dispatch.forward(request, response);
	
		
	}

	
	
}


