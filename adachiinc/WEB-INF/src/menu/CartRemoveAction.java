package menu;

import bean.Item;
import tool.Action;
import javax.servlet.http.*;
import java.util.List;
import menu.CartAddAction;

public class CartRemoveAction extends Action{

  @SuppressWarnings("unchecked")
  public String execute(
  HttpServletRequest request, HttpServletResponse response
  )throws Exception{

HttpSession session=request.getSession();

int id=Integer.parseInt(request.getParameter("ID"));
List<Item> cart=(List<Item>)session.getAttribute("cart");

for(Item i : cart){
  if(i.getProduct().getId()==id);
  CartAddAction.total-=i.getProduct().getPrice()*i.getCount();
  session.setAttribute("total", CartAddAction.total);
    cart.remove(i);

    break;
  }
return "cart.jsp";
}

}
