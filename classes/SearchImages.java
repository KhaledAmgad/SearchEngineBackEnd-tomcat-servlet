import java.io.*;
import javax.servlet.*;
import org.json.*;
import javax.servlet.http.*;
import java.util.*;
import servletlistener.QueryProcessor;
public class SearchImages extends HttpServlet { 
	JSONObject obj = new JSONObject();
	
	public void doGet(HttpServletRequest request, 
        HttpServletResponse response) throws IOException 
		{
			String search = request.getParameter("search");
			String page_Images = request.getParameter("page_Images");
			String selectCountry = request.getParameter("selectCountry");
			System.out.println(search);
			QueryProcessor QP =(QueryProcessor)getServletContext().getAttribute("QP");

			try {
				if(QP.start(search).get(0).equals("pic"))
				{
					
					obj.put("NumberOfPages",0);
					obj.put("NumberOfPages_Images",4);
					obj.put("searchList",new JSONArray());
					JSONArray imageList = new JSONArray();
					for (int i = 0; i < 20; i++) {
						JSONObject imageElement = new JSONObject();
						imageElement.put("imgUrl","https://www.w3schools.com/html/pic_trulli.jpg");
						imageElement.put("url","https://www.w3schools.com "+Integer.toString(i+1));
						imageList.put(imageElement);
					}
					obj.put("imageList",imageList);
				}
				else
				{
					obj.put("NumberOfPages",0);
					obj.put("NumberOfPages_Images",0);
					obj.put("searchList",new JSONArray());
					obj.put("imageList",new JSONArray());
				}
				} 
			catch (JSONException e) {
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
