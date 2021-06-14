package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class Update_okCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 파라미터로 idx는 넘어오지 않는다.
		// session에서 vo불러오기
		VO v = (VO)request.getSession().getAttribute("vo");
		
		VO vo = new VO();
		vo.setIdx(v.getIdx()); // 고친 것을 넣어야 하므로 v.getIdx();
		vo.setName(request.getParameter("name"));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setEmail(request.getParameter("email"));
		vo.setPw(request.getParameter("pw"));
		
		int result = DAO.getUpdate(vo);
		if(result > 0){
			// response.sendRedirect("onelist.jsp?idx=" + vo.getIdx());
			return "MyController?cmd=onelist&idx=" + vo.getIdx();
		}
		return null;
	}
}
