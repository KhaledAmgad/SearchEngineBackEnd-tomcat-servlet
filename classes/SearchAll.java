import java.io.*;
import javax.servlet.*;
import org.json.*;
import javax.servlet.http.*;
import java.util.*;
import servletlistener.QueryProcessor;
public class SearchAll extends HttpServlet { 
	JSONObject obj = new JSONObject();

	
	
	public void doGet(HttpServletRequest request, 
        HttpServletResponse response) throws IOException 
		{
			String search = request.getParameter("search");
			String page = request.getParameter("page");
			String selectCountry = request.getParameter("selectCountry");
			System.out.println(search);
			QueryProcessor QP =(QueryProcessor)getServletContext().getAttribute("QP");

			try {
				if(QP.start(search).get(0).equals("pic"))
				{
					obj.put("NumberOfPages",5);
					obj.put("NumberOfPages_Images",0);
					obj.put("imageList",new JSONArray());
					JSONArray searchList = new JSONArray();
					for (int i = 0; i < 20; i++) {
						JSONObject searchElement = new JSONObject();
						searchElement.put("header","pic"+Integer.toString(i+1));
						searchElement.put("url","https://www.w3schools.com");
						searchElement.put("snippets","w3schools is gooodw3schools is gooodw3schools is gooodw3schools is gooodw3schools is gooodw3schools w3schools is gooodw3schools is gooodw3schools is gooodw3schools is gooodw3schools is gooodw3schools is gw3schools is gooodw3schools is gooodw3schools is gooodw3schools is gooodw3schools is gooodw3schools is gw3schools is gooodw3schools is gooodw3schools is gooodw3schools is gooodw3schools is gooodw3schools is gis goood");
						searchList.put(searchElement);
					}
					obj.put("searchList",searchList);
					
				}
				else
				{
					obj.put("NumberOfPages",0);
					obj.put("NumberOfPages_Images",0);
					obj.put("searchList",new JSONArray());
					obj.put("imageList",new JSONArray());
				}
				} catch (JSONException e) {
					e.printStackTrace();
				}
				
				
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.addHeader("Access-Control-Allow-Origin","https://hcug4.csb.app");
				out.print(obj);
				out.flush();
				
		
 
	
	}
	
}
