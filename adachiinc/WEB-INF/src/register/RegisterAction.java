package  register;


import tool.Action;
import dao.UserDAO;
import bean.User;
import java.util.List;
import javax.servlet.http.*;


public class RegisterAction extends Action{
  public String execute(
    HttpServletRequest request,HttpServletResponse response
  )throws Exception{
      String message = "";
      int line=0;
  try{
    HttpSession session = request.getSession();

    String login = request.getParameter("login");
    if(login==null || login.length() ==0){
      message="ログインIDを入力してください。";
      request.setAttribute("message",message);
      return "register-out.jsp";
    }

    String password = request.getParameter("password");
    if(password==null || password.length() ==0){
      message="パスワードを入力してください。";
      request.setAttribute("message",message);
      return "register-out.jsp";
    }

    String repassword = request.getParameter("repassword");
    if(!repassword.equals(password)){
      message="パスワードが一致しません。";
      request.setAttribute("message",message);
      return "register-out.jsp";
    }

      if(repassword==null || repassword.length() ==0){
        message="再度パスワードを入力してください。";
        request.setAttribute("message",message);
        return "register-out.jsp";
    }

    String name = request.getParameter("name");
    if(name==null || name.length() ==0){
      message="氏名を入力してください。";
      request.setAttribute("message",message);
      return "register-out.jsp";
    }

    User user = new User();
    user.setLogin(login);
    user.setPassword(password);
    user.setName(name);
    UserDAO dao = new UserDAO();
    line = dao.insert(user);

    User user1 = dao.search(login,password);
    request.setAttribute("list",user1);


    }catch(Exception e){
    if(line != 1){
    message = "このIDはすでに使用されています";
    request.setAttribute("message",message);
    return "register-error.jsp";
    }
  }

    message = "アカウント登録が完了しました";
    request.setAttribute("message",message);
    return "register-out.jsp";


  }
}
