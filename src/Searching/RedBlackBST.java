/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Searching;

import java.util.ArrayList;

/**
 *
 * @author AdelEwis
 */
public class RedBlackBST<Key extends Comparable<Key>,Value> {
    
    private Node root;
 private static final boolean Red = true,
               Black = false;
   
    private class Node
    {
       private Value value;
       private Key key;
       private Node left,right;
       private int N;
      
       private boolean color; //true is red false black
        public Node(Key key,Value value,int N)
        {
            this.key=key;this.value=value;this.N=N;
        }
        public Node(Key key,Value value,int n,boolean color)
        {
            this.key=key;this.value=value;this.N=n;this.color=color;
        }
    }
    
    private boolean isRead(Node x)
    {
        if(x==null) return Black; //all null links are black
        return x.color==Red;
    }
    
    private Node rotateLeft(Node h)
    {
        Node x=h.right;
        h.right=x.left;
        x.left=h;
        x.color=h.color;
        h.color=Red;
        return x;
    }
    
    private Node rotateRight(Node h)
    {
        Node x=h.left;
        h.left=x.right;
        x.right=h;
        x.color=h.color;
        h.color=Red;
        return x;
    }
    
    private void flipColors(Node h)
    {
        h.color = Red;
        h.left.color = Black;
        h.right.color = Black;
    }
    public Value get(Key key)
    {
      return  get(root,key);
    }
    
    private Value get(Node x,Key key)
    {
        if(x==null) return null;
        int cmp=key.compareTo(x.key);
        if(cmp<0) return get(x.left,key);
        else if(cmp>0) return get(x.right,key);
        else return x.value;
    }
    
    
    
    private int size(Node node)
    {
        if(node==null) return 0;
        return node.N;
    }
    public int size()
    {
        return size(root);
    }
    public void put(Key key,Value value)
    {
        root=put(root,key,value);
    }
    
    private Node put(Node x,Key key,Value value)
    {
       if(x==null)return new Node(key,value,1,Red); //node doesn't exist so create it 
       int cmp=key.compareTo(x.key);
       if(cmp<0) x.left=put(x.left,key,value);
       else if(cmp>0) x.right=put(x.right,key,value);
       else x.value=value; // nodke exists with the same key so change the value
       
       if (isRead(x.right)&&!isRead(x.left))x=rotateLeft(x);
       if (isRead(x.left)&&isRead(x.left.left)) x=rotateRight(x);
       if (isRead(x.left)&&isRead(x.right)) flipColors(x);
       x.N = size(x.left) + size(x.right) + 1;
       return x;
    }
    
    public void delete(Key key)
    {
        root=delete(root,key);
    }
    private Node delete(Node x,Key key)
    {
        if(x==null) return null;
        int cmp=key.compareTo(x.key);
        if(cmp<0) x.left= delete(x.left,key);
        else if(cmp>0) x.right= delete(x.right,key);
        else{
            if(x.right==null) return x.left;
            Node t=x;                     // temp Node
            x = min(x.right); // get the smallest 
            //make the right tree equals the old right tree minus the min
            x.right = deleteMin(t.right);     
            x.left=t.left;
        }
        x.N=size(x.right)+size(x.left)+1;
        return x;
    }
    
    public Key floor(Key key)
    {
        Node x=floor(root,key);
        if(x==null) return null;
        return x.key;
    }
    private Node floor(Node x,Key key)
    {
        if(x==null) return null;
        int cmp=key.compareTo(x.key);
        if(cmp==0) return x;
        
        if(cmp<0) return floor(x.left,key);
        Node r=floor(x.right,key);
        if(r==null) return x;
        return r;
    }
    public Key ceil(Key key)
    {
        Node x=ceil(root,key);
        if(x==null) return null;
        return x.key;
    }
    private Node ceil(Node x,Key key)
    {
        if(x==null) return null;
        int cmp=key.compareTo(x.key);
        if(cmp==0) return x;
        
        if(cmp>0) return ceil(x.right,key);
        Node r=ceil(x.left,key);
        if(r==null) return x;
        return r;
    }
    public Key min()
    {
        return min(root).key;
    }
    private Node min(Node x)
    {
        if(x.left==null) return x;
        return min(x.left);
    }
    // return number of keys less thank key
    public int rank(Key key)
    {
        return rank(root,key);
    }
    
    private int rank(Node x,Key key)
    {
        if(x==null) return 0;
        int cmp=key.compareTo(x.key);
        if(cmp>0)  return 1+size(x.left)+rank(x.right,key);             // if key > root 
       else if(cmp<0)  return rank(x.left,key);                     // if key < root
        return size(x.left); // if equal return the size of all that is less than it
    }
   public Iterable<Key>keys()
    {
        ArrayList<Key>keys=new ArrayList<Key>();
        inorder(root, keys);
        return keys;
    }
    private void inorder(Node x,ArrayList<Key>keys)
    {
        if(x==null) return;
        inorder(x.left, keys);
        keys.add(x.key);
        inorder(x.right, keys);
    }
    //delete Min Node the noade with the smallest key not value
    public void deleteMin()
    {
       root= deleteMin(root);
    }
    private Node deleteMin(Node x) 
    {
        if(x.left==null) return x.right;
        x.left=deleteMin(x.left);
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }
    //delete Max Node from the tree the noade with the largest key not value
    public void deleteMax() 
    {
        root=deleteMax(root);
    }
     private Node deleteMax(Node x) 
    {
        if(x.right==null) return x.left; //return it's right link to it's parrent
        x.right=deleteMax(x.right);
        x.N=1+size(x.right)+size(x.left); //update size
        return x;
    }
}
