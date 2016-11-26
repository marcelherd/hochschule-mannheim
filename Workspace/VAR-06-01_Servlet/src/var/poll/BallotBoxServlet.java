package var.poll;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The ballot box servlet.
 * This servlet handles HTTP GET and POST requests to /vote.
 * 
 * @author Marcel Herd - 1527440
 */
@WebServlet("/vote")
public class BallotBoxServlet extends HttpServlet {
	
	private static final long serialVersionUID = -3037909977646878861L;
	
	private BallotBoxInterface ballotBox = new BallotBox();

	/**
	 * Called on HTTP GET request
	 * 
	 * @param request
	 * @param response
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}
	
	/**
	 * Called on HTTP POST request
	 * 
	 * @param request
	 * @param response
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}
	
	private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		switch (action) {
		case "vote":
			handleVote(request, response);
			break;
		case "print":
			handlePrint(response);
			break;
		}
	}
	
	private void handleVote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String alternative = request.getParameter("alternative");
		
		if (alternative != null) {
			ballotBox.vote(alternative);
		}
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		HtmlWriter.startHtml(writer);
		HtmlWriter.paragraph(writer, "Ihre Stimme wurde gezählt!");
		HtmlWriter.endHtml(writer);
	}
	
	private void handlePrint(HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		HtmlWriter.startHtml(writer);
		HtmlWriter.startTable(writer, new String[] { "Alternative", "Anzahl Stimmen" });
		
		for (String alternative : ballotBox.getChoices()) {
			HtmlWriter.tableRow(writer, alternative, ballotBox.getNumberOfVotes(alternative));
		}
		
		HtmlWriter.endTable(writer);
		HtmlWriter.endHtml(writer);
	}

}

/**
 * Provides helper methods for easy HTML output to a PrintWriter.
 * 
 * @author Marcel Herd - 1527440
 */
class HtmlWriter {
	
	public static void startHtml(PrintWriter writer) {
		writer.println("<html><body>");
	}
	
	
	public static void endHtml(PrintWriter writer) {
		writer.println("</body></html>");
	}
	
	public static void startTable(PrintWriter writer, String[] headers) {
		writer.println("<table><thead><tr>");
		for (String header : headers) {
			writer.println("<th>" + header + "</th>");
		}
		writer.println("</tr></thead><tbody>");
	}
	
	public static void tableRow(PrintWriter writer, String alternative, int votes) {
		writer.println("<tr>");
		writer.println("<td><strong>" + alternative + "</strong></td>");
		writer.println("<td>" + votes + "</td>");
		writer.println("</tr>");
	}
	
	public static void endTable(PrintWriter writer) {
		writer.println("</tbody></table>");
	}
	
	public static void paragraph(PrintWriter writer, String text) {
		writer.println("<p>" + text + "</p>");
	}
	
}
