import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SearchReplaceDocs {
	static PrintWriter outHTML;
	static Pattern m_pattern;
	static Matcher m_matcher;
	
	public SearchReplaceDocs( PrintWriter out )
	{
		outHTML = out;
	}
	
	public void do_regex( String in_s, String in_pattern )
	  {
		  if (in_s==null || in_pattern == null)
			  return;
		  try
		  {
			  m_pattern = Pattern.compile( in_pattern );
		  }
		  catch ( Exception e )
		  {
			  outHTML.println(e.getMessage());
		  }
		  
		  if (in_s.length() == 0)
			  return;
			  else
			  {
					  //if the mode was to search then just highlight them
					  String[] the_data = in_s.split(" ");
					  int i = 0;
					  outHTML.println("</br>");
					  for ( String s : the_data)
					  {
						  
						  m_matcher = m_pattern.matcher(s);
						  if (m_matcher.matches())
						  {//1337speak found make it colored!
							  outHTML.print("<span class='match'>" + s + "</span> ");
							  i++;
						  }
						  else
							  outHTML.print(s + " ");
					  }
					  if (i==0)
						  outHTML.println("<div class='nomatch'>No Match</div></br>");
			}
			
					  
	}
}
