package il.ac.hit.tags;

import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class ErrorMessage extends SimpleTagSupport {
	
	private String msg;
	
	public void doTag() throws JspException, IOException
	{
		if (msg != null)
		{
			JspFragment body = getJspBody();
			StringBuffer sb = new StringBuffer();
			sb.append("<h4>" + msg + "</h4>");
			JspWriter out = getJspContext().getOut();
			out.write(sb.toString());
		}			
	}
	
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
	
	public String getMsg()
	{
		return msg;
	}
}
