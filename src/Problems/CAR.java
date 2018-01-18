/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems;

import com.sun.org.apache.xpath.internal.operations.Equals;
import java.util.Comparator;

/**
 *
 * @author AdelEwis
 */
public class CAR implements Comparable<CAR> {
    int speed;
   public CAR(int s)
   {
       this.speed=s;
   }

    CAR() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(CAR o) {
        return this.get_speed()-o.get_speed();
    }
   
   
    public void increase_speed_byone()
    {
        this.speed++;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)return true;
        if(obj==null)return false;
        if(this.getClass()!=obj.getClass()) return false;
        CAR car=(CAR)obj;
        if(this.get_speed()!=car.get_speed()) return false;
        return true;
    }
    public static Comparator<CAR> CarComparator
            =new Comparator<CAR>(){
        @Override
        public int compare(CAR o1, CAR o2) {
            return o1.get_speed()-o2.get_speed(); 
        }
                
            };
   
    public int get_speed()
    {
        return speed;
    }
    @Override
    public String toString()
    {
        return "Car speed: "+speed;
    }
    
}
