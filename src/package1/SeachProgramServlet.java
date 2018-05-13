package package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		description = "Seach Program Servlet", 
		urlPatterns = { "/SeachProgramServlet" })
public class SeachProgramServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String HTML_START="<html><body>";
	public static final String HTML_END="</body></html>";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException{
	
			}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String currencyName = request.getParameter("currencyName");
		int term = Integer.parseInt(request.getParameter("term"));
				
		DepositsService a = new DepositsService();
		ArrayList<String> pr = a.getPrograms(currencyName, term);
		
		PrintWriter out = response.getWriter();
		for (String e: pr){
			out.println(HTML_START + "<h3>"+e+"</h3>"+HTML_END);
		}
		
	}
}
