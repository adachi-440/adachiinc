package menu;

import java.util.*;
import java.util.List;
import bean.*;
import dao.SellerDAO;
import dao.BuyerDAO;
import dao.UserListDAO;
import tool.Action;
import javax.servlet.http.*;

 public class CalculateAction extends Action{
   public String execute(
   HttpServletRequest request,HttpServletResponse response
   )throws Exception{
     HttpSession session = request.getSession();
     User user =  (User)session.getAttribute("user");
     String seller = user.getName();
      String buyer = user.getName();
      String keyword = "";

      SellerDAO dao1 = new SellerDAO();
      BuyerDAO dao2 = new BuyerDAO();
      UserListDAO dao3 = new UserListDAO();

   List<Item> list1 = dao1.sellerSearch(seller);
   List<Item> list2 = dao2.buyerSearch(buyer);
   List<User> list3 = dao3.userSearch();

   session.setAttribute("seller",list1);
   session.setAttribute("buyer",list2);
   session.setAttribute("userlist",list3);

   List<String> na = new ArrayList<>();
   Map<String,Integer> paid = new TreeMap<>();
   Integer paid1[] = {0,0,0,0};
   Integer pay1[] = {0,0,0,0};

for(User u:list3){
   paid.put(u.getName(),0);
}
//自分が売って、誰が買ったか
   for(Item i : list1){
       if(i.getBuyer().equals("竹内周登")){
             paid1[0] += i.getPrice() * i.getQuantity();
             paid.put( i.getBuyer(),paid1[0]);
      }
      if(i.getBuyer().equals("加藤豪輝")){
            paid1[1] += i.getPrice() * i.getQuantity();
            paid.put( i.getBuyer(),paid1[1]);
     }
     if(i.getBuyer().equals("足立智樹")){
           paid1[2] += i.getPrice() * i.getQuantity();
           paid.put( i.getBuyer(),paid1[2]);
    }
    if(i.getBuyer().equals("奥隼")){
          paid1[3] += i.getPrice() * i.getQuantity();
          paid.put( i.getBuyer(),paid1[3]);
           }
}
   Map<String,Integer> pay = new TreeMap<>();

//自分が買って、誰から買ったかをサーチ
   for(Item i : list2){
       if(i.getSeller().equals("竹内周登")){

             pay1[0] += i.getPrice() * i.getQuantity();
             pay.put( i.getSeller(),pay1[0]);

      }
      if(i.getSeller().equals("加藤豪輝")){

            pay1[1] += i.getPrice() * i.getQuantity();
            pay.put( i.getSeller(),pay1[1]);
     }
     if(i.getSeller().equals("足立智樹")){

           pay1[2] += i.getPrice() * i.getQuantity();
           pay.put( i.getSeller(),pay1[2]);
    }
    if(i.getSeller().equals("奥隼")){

          pay1[3] += i.getPrice() * i.getQuantity();
          pay.put( i.getSeller(),pay1[3]);
        }
}


/*
      if(i.getBuyer().equals("奥隼")){

       pay2 += i.getPrice() * i.getQuantity();
     }
     if(i.getBuyer().equals("加藤豪輝")){

       pay3 += i.getPrice() * i.getQuantity();
           }
             if(i.getBuyer().equals("足立智樹")){

       pay4 += i.getPrice() * i.getQuantity();

 */

session.setAttribute("paid",paid);
session.setAttribute("pay",pay);
return "calculation.jsp";
}

}
