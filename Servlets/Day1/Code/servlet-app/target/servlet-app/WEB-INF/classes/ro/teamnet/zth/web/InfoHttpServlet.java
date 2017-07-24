package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Alexandru.Grameni on 7/18/2017.
 */
public class InfoHttpServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration en = req.getHeaderNames();

        StringBuilder table = new StringBuilder("<table>");

        while(en.hasMoreElements())
        {
            table.append("<tr> <td colspan=").append(1).append("> ").append(en.nextElement());
            table.append("</td></tr>");
        }
        table.append("</table>");

        resp.getWriter().write(String.valueOf(table));
        resp.getWriter().write(req.getMethod());
//        resp.getWriter().write(req.getQueryString());

       /* Cookie[] cookie = req.getCookies();

        StringBuilder cookies = new StringBuilder("<table>");

        for(Cookie i : cookie) {
            cookies.append("<tr> <td colspan=").append(1).append("> ").append(i.getName());
            cookies.append("</td></tr>");
        }
        cookies.append("</table>");

        resp.getWriter().write(String.valueOf(cookies));*/

        Enumeration params = req.getParameterNames();

        StringBuilder paramString = new StringBuilder("<table>");

       while(params.hasMoreElements()) {
           String nume = (String) params.nextElement();
            paramString.append("<tr> <td colspan=").append(2).append("> ").append(params.nextElement());
            paramString.append("</td><td>").append(req.getParameterValues(nume));
            paramString.append("</td></tr>");
        }
        paramString.append("</table>");

        resp.getWriter().write(String.valueOf(paramString));
    }
}
