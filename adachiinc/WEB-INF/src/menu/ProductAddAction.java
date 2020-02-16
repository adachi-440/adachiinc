package menu;

import java.util.List;
import bean.User;
import bean.Product;
import tool.Action;
import dao.ProductDAO;
import javax.servlet.http.*;
import java.io.*;

public class ProductAddAction extends Action{
  public String execute(
  HttpServletRequest request, HttpServletResponse response
  )throws Exception{
    int line = 0;
    HttpSession session = request.getSession();

    String name = request.getParameter("name");
    int price = Integer.parseInt(request.getParameter("price"));
    int quantity = Integer.parseInt(request.getParameter("quantity"));

    User user = (User)session.getAttribute("user");
    String seller = user.getName();

    Product p =new Product();
    p.setName(name);
    p.setPrice(price);
    p.setQuantity(quantity);
    p.setSeller(seller);

    ProductDAO dao = new ProductDAO();
    line = dao.insert(p);
    if(line ==1){

      return "../menu/insert-out.jsp";
    }
    return "insert-error.jsp";


}
}
