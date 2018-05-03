

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		String path = req.getRequestURI();
		if (path.equals("/DatabaseProject/Login.jsp") ||
				path.equals("/DatabaseProject/Welcome.html") || 
				path.equals("/DatabaseProject/Register.jsp") ||
				path.equals("/DatabaseProject/RegisterServlet") ||
				path.equals("/DatabaseProject/MainPage.jpg") ||
				path.equals("/DatabaseProject/index.jsp") ||
				path.equals("/DatabaseProject/loginfail.jsp") ||
				path.equals("/DatabaseProject/")) {
		    chain.doFilter(request, response); // Just continue chain.
		} else {
			if (session ==null || session.getAttribute("ID")==null)
				resp.sendRedirect(((HttpServletRequest) request).getContextPath() + "/Login.jsp");
			else chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
