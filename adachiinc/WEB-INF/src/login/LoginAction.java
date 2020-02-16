package login;


import tool.Action;
import dao.UserDAO;
import bean.User;
import javax.servlet.http.*;


public class LoginAction extends Action{
  public String execute(
    HttpServletRequest request,HttpServletResponse response
  )throws Exception{
    HttpSession session = request.getSession();

    String login = request.getParameter("login");
    String password = request.getParameter("password");
    UserDAO dao = new UserDAO();
    User user = dao.search(login,password);

    if(user != null){
      session.setAttribute("user",user);
      return "login-out.jsp";
    }

    return "login-error.jsp";
  }
}
