/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems;

/**
 *
 * @author AdelEwis
 */
public class UFmain {
     public static void main(String[] args) {
        
       String[] strArr= {"1 0" , "2 3" ,"0 3" , "2 1"};
        int N=strArr.length;
        UnioFind un=new UnioFind(5);
        for(String s: strArr)
        {
           String[] arr=s.split(" ");
            int p=Integer.parseInt(arr[0]);
            int q=Integer.parseInt(arr[1]);
            if(!un.connected(p, q))
            {
               un.union(p,q);
                System.out.println(p+" "+q+ "\n");
                
            }
            
        }
        System.out.println(un.GetCount());
    }
}
