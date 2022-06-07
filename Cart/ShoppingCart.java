package Cart;

import java.util.*;

import java.io.Console;

public class ShoppingCart{

    public static void main(String[] args) {
        
        System.out.println("Shopping Cart");
        List<String> cart = new LinkedList<>();
        Console cons = System.console();
        String input;
        int delIndex;
        boolean stop= false;

        cart.add("apple");
        cart.add("orange");
        cart.add("pear");

        // main loop
        while(!stop){
            input = cons.readLine(">");
            System.out.printf("READ: %s\n", input);
            String[] terms = input.split(" ");
            String cmd = terms[0];

            switch(cmd){
                case "add":
                     String fruitsStr = terms[1];
                     String fruitsReplaced = fruitsStr.replace(","," ");
                     String[] fruits = fruitsReplaced.split(" ");

                     for(int i=0; i < terms.length; i++){
                         boolean found = false;
                         for(int j=0; j < cart.size(); j++){
                             if(fruits[i].toLowerCase().equals(cart.get(j).toLowerCase())){
                                 found = true;
                                 break;
                             }
                         }
                         if(!found){
                             cart.add(fruits[i]);
                             System.out.printf("Added %s to cart\n", fruits[i].toLowerCase());
                         }
                     }
                     break;
                case "list":
                     if(cart.size()> 0){
                         for(int i=0; i < cart.size(); i++){
                             System.out.printf("%d. %s\n", (i+1), cart.get(i));
                        }
                     }else{
                         System.out.println("Your cart is empty!");
                     }
                     break;
                case "del":
                     if (terms.length< 2 ){
                         System.out.println("Please provide an index in order to delete");
                     }else{
                         delIndex =Integer.parseInt(terms[1])-1;
                         if(delIndex < cart.size()){
                             System.out.printf("%s removed from the cart\n", cart.get(delIndex));
                             cart.remove(delIndex);
                         }else{
                             System.out.println("Incorrect item index");
                            }
                    }    
                     break; 
                case "end":
                    stop = true;
                    break;
                default:         
            

        }
    }
        System.out.println("Thank you for shopping with us");
    
    }
}
