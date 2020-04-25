package com.igeek.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.service.musicService;

/**
 * Servlet implementation class QueryMusicById
 */
@WebServlet("/QueryMusicById")
public class QueryMusicById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryMusicById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int index = id.indexOf("-");
		String Rid = id.substring(0, index);
		String Ranking = id.substring(index+1);
		int rid = Integer.valueOf(Rid);
		int ranking = Integer.valueOf(Ranking);
		musicService ms = new musicService();
		String music = ms.findId(rid, ranking);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().println(music);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
