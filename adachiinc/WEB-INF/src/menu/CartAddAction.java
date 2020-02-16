package menu;

import bean.Item;
import bean.User;
import bean.Product;
import tool.Action;
import java.util.ArrayList;
import java.util.List;

public class CartAddAction extends Action{
  static int total = 0;
  @SuppressWarnings("unchecked")

  public String execute(
  HttpServletRequest request, HttpServletResponse response
  )throws Exception{

    HttpSession session = request.getSession();

    User user = (User)session.getAttribute("user");
    String user_name = user.getName();
    int id =Integer.parseInt(request.getParameter("ID"));
    int counter = Integer.parseInt(request.getParameter("counter"));

    List<Item> cart = (List<Item>)session.getAttribute("cart");
    if(cart==null){
      cart =new ArrayList<Item>();
      session.setAttribute("cart", cart);
    }
    for(Item i : cart){
      if(i.getProduct().getId()==id){
        i.setCount(i.getCount()+counter);
        total+=i.getProduct().getPrice()*counter;
        session.setAttribute("total", total);
        return "cart.jsp";
      }
    }

      List<Product> lineup = (List<Product>)session.getAttribute("lineup");
      for(Product p : lineup){
        if(p.getId()==id){
          Item i = new Item();
          i.setUser_name(user_name);
          i.setProduct(p);
          i.setCount(counter);//1からcounterに変えました
          total+=i.getProduct().getPrice()*counter;
          session.setAttribute("total", total);
          cart.add(i);
        }
      }
      return "cart.jsp";
      }

    }
