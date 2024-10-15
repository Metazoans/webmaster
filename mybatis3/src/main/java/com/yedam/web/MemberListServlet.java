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
		
		
		out.print("<table >");
		out.print("<tr> <th>id</th> <th>password</th> <th>name</th> <th>phone</th> <th>respons</th> <th>date</th> </tr>");
		for(Member member : result) {
			//out.print(member.toString() + "<br>");
			out.print("<tr>");
			
			out.print("<td>");
			out.print(member.getMemberId());
			out.print("</td>");
			
			out.print("<td>");
			out.print(member.getPassword());
			out.print("</td>");
			
			out.print("<td>");
			out.print(member.getMemberName());
			out.print("</td>");
			
			out.print("<td>");
			out.print(member.getPhone());
			out.print("</td>");
			
			out.print("<td>");
			out.print(member.getResponsibility());
			out.print("</td>");
			
			out.print("<td>");
			out.print(member.getCreationDate());
			out.print("</td>");
			
			out.print("</tr>");
		}
		out.print("</table>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
	}

}
