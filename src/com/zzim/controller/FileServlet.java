package com.zzim.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.*; 
import com.oreilly.servlet.multipart.*; 

/**
 * Servlet implementation class FileServlet
 */
@WebServlet("/FileServlet")
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// TODO Auto-generated method stub
		
		/*
		 * 파일 업로드
		 */
		int size = 100*1024*1024;        // 업로드 파일 최대 크기 지정 

		ServletContext servletContext = getServletContext();
		String contextPath = servletContext.getRealPath(File.separator);
		String uploadPath = contextPath + "WebContent\\image";
        File folder = new File(uploadPath); 
        if(!folder.exists()) { 
                folder.mkdirs(); 
        } 

		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
			
			Enumeration files = multi.getFileNames(); 
	         
	        // 업로드한 파일들의 이름을 얻어옴 
			String file = (String)files.nextElement(); 
			String fileName = multi.getFilesystemName(file); 

			System.out.println(contextPath);
			request.setAttribute("fileName", "WebContent\\image\\" + fileName);
			RequestDispatcher rd = request.getRequestDispatcher("fileTarget.jsp");
			rd.forward(request, response);
	       
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * 파일 정보 DB에 저장
		 */
		

        

	}
}
