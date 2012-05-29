import java.io.*;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.*;
import javax.servlet.*;

public class RegexServerlet extends HttpServlet {
	
	
	static boolean regexCompleted;
	static PrintWriter outHTML;
	
  public void doGet (HttpServletRequest req,
                                         HttpServletResponse res)
        throws ServletException, IOException
  {
	  
        res.setContentType("text/html");
        outHTML = res.getWriter();
        SearchReplaceDocs mySRD = new SearchReplaceDocs(outHTML);
        outHTML.println("<HTML><HEAD><TITLE>");
        outHTML.println("Regular Expression Bot");
        outHTML.println("</TITLE>");
        outHTML.println("<link rel='stylesheet' type='text/css' href='myStyle.css' />");
        outHTML.println("<script src='regex.js' type='text/javascript'></script> ");
        outHTML.println("</HEAD>");
        outHTML.println("<BODY>");
        outHTML.println("Regex Serverlet, Enter a string to test out a feature of automata, string processing");
        outHTML.println("<form method='get'>");
        outHTML.println("Input Text : </br><TEXTAREA NAME='user-text' COLS=40 ROWS=6>The default pattern finds w0rd5 with b0th l3tt3r5 and numb3rs together only. This is done to pr3v3nt 1337speak.</TEXTAREA></br>");
        outHTML.println("Input Regular Expression : </br><input hint='ENTER REGEX' type='text' name='user-pattern' value='([a-zA-Z]+[0-9]|[0-9]+[a-zA-Z])[a-zA-Z0-9\\.]*' />");
        outHTML.println("<input type='submit' value='Submit' />");
        outHTML.println("</form>");
        
        
        //Here we obtain HTTP GET VARIABLES
        
        //check to make sure they are set
        outHTML.println("Output:");
        mySRD.do_regex( req.getParameter("user-text") ,req.getParameter("user-pattern"));
        outHTML.close();
  }
  
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
  {
	  outHTML = res.getWriter();
  }
  
	  
  
  public void init() throws ServletException
  {
	  System.out.println("Starting up the serverlet");
  }
  
}