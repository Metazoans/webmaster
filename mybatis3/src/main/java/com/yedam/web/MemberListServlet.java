package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

/**
 * Servlet implementation class MemberListServlet
 */

// IOC (제어의 역전)
// 객체 생성 -> init() -> service() -> destroy() : 서블릿의 생명주기
@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberListServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();

		SqlSession sqlSession = DataSource.getInstance().openSession();
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		
		List<Member> result = dao.members();
		
		String str = "<table border=1, style='border-collapse:collapse', width=1000,height=300>";
		str += "<tr> <th>id</th> <th>password</th> <th>name</th> <th>phone</th> <th>respons</th> <th>date</th> </tr>";
		for(Member member : result) {
			str +="<tr><td><a href='member.action?mid=" + member.getMemberId() +"'>" + member.getMemberId();
			str += "</a></td><td>" + member.getPassword();
			str += "</td><td>" + member.getMemberName();
			str += "</td><td>" + member.getPhone();
			str += "</td><td>" + member.getResponsibility();
			str += "</td><td>" + member.getCreationDate() + "</td></tr>";
		}
		str += "</table>";
		str += "<a href='./'>첫페이지</a>";
		out.print(str);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
