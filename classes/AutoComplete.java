import java.io.*;
import javax.servlet.*;
import org.json.*;
import javax.servlet.http.*;
import java.util.*;
public class AutoComplete extends HttpServlet { 
	JSONObject obj = new JSONObject();

	
	
	public void doGet(HttpServletRequest request, 
        HttpServletResponse response) throws IOException 
		{
		String search = request.getParameter("search");
		try {
			if(search.toLowerCase().equals("g"))
			{
				
				JSONArray arr = new JSONArray();
				arr.put("Gym");
				arr.put("Gamed");
				obj.put("AutoCompleteList",arr);
			}
			else if(search.toLowerCase().equals("z"))
			{
				
				JSONArray arr = new JSONArray();
				arr.put("zoo");
				arr.put("zeee");
				obj.put("AutoCompleteList",arr);
			}
			else if(search.toLowerCase().equals("gym"))
			{
				
				JSONArray arr = new JSONArray();
				arr.put("Gym 0000");
				arr.put("Gym 0001");
				arr.put("Gym 0010");
				obj.put("AutoCompleteList",arr);
			}
			else
			{
				obj = new JSONObject();
				JSONArray arr = new JSONArray();
				obj.put("AutoCompleteList",arr);
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
