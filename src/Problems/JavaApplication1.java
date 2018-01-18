/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import sun.misc.Queue;

/**
 *
 * @author AdelEwis
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void test (CAR Mycar) //object is passed by referance object is referance data Type
    {
      Mycar.increase_speed_byone();
    }
     public int[] spiralOrder(final int[][] A) {
        int[][] solarr=new int[A.length][A[0].length];
        ArrayList<Integer> res=new ArrayList<Integer>();
          
          
        solve(0,0,A,solarr,res);
        int[] result_array=new int[res.size()];
        for(int i=0;i<res.size();i++)
        {result_array[i]=res.get(i);}
        
        return result_array;
    }
     
     public void solve(int x, int y,int[][] arr ,int[][] solarr , ArrayList<Integer> retArray)
     {
         
         if(retArray.size()== arr.length*arr[0].length) {return;}
         //solve right
         while( y<arr[0].length )
         {
             if(solarr[x][y]==1) {y--;break;}
             solarr[x][y]=1;
             retArray.add(arr[x][y++]);
         }
        x++; //solve down
         while(x<arr.length)
         {
            if(solarr[x][y]==1){ x--;break;}
            solarr[x][y]=1;
            retArray.add(arr[x++][y]);
         }
         y--; //solve left
         while( y>=0 )
         {
             if(solarr[x][y]==1){y++ ;break;}
             solarr[x][y]=1;
             retArray.add(arr[x][y--]);
         }
         x--; //solve up
         while(x>=0)
         {
             if(solarr[x][y]==1) {x++;break;}
            solarr[x][y]=1;
            retArray.add(arr[x--][y]);
         }
         solve(x,y,arr,solarr,retArray);
     }
    public static void main(String[] args) {
        // TODO code application logic here
        CAR myTestCar=new CAR(10);
        test(myTestCar);
        System.out.println(myTestCar);
        HashMap<CAR,Integer>mycar= new HashMap<>();
       Integer m= mycar.get(new CAR(10));
        String s="Adel";
       s=  s.replace('e', 'E');
       ArrayList<String> sss=new ArrayList<>();
       //sss.s
       
        Queue<String>q=new Queue<String>();
        for(String a:sss)
        {
            q.enqueue(a);
            try{
           q.enqueue(q.dequeue());}catch(Exception e){}
        }
               
    ArrayList<CAR>carsList=new ArrayList<>();
        
    carsList.sort(CAR.CarComparator);
        Collections.sort(carsList,CAR.CarComparator);//
      //  Collections.sort(carsList); //or use this if the class car impelments comparable
        System.out.println(s);
        ArrayList<Integer>my_list=new ArrayList<Integer>();//Integer is a Wrapper type for int
    }
    
}
