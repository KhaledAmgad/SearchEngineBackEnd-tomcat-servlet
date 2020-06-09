import java.io.*;
import javax.servlet.*;
import org.json.*;
import javax.servlet.http.*;
import java.util.*;
public class LinkClick extends HttpServlet { 
	JSONObject obj = new JSONObject();

	
	public void doGet(HttpServletRequest request, 
        HttpServletResponse response) throws IOException 
		{
			String search = request.getParameter("search");
			String url = request.getParameter("url");

			System.out.println(url+" "+search); //handle visit(when user click on link)
			System.out.println((String)getServletContext().getAttribute("url")); //handle visit(when user click on link)
			

		
 
	
	}
	
}
