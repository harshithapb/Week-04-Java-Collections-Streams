package org.example;
import java.util.*;
public class ListManager {
    public void addElement(List<Integer> list, int ele){
        list.add(ele);
    }
    public void removeElement(List<Integer> list, int ele){
        list.remove(Integer.valueOf(ele));
    }
    public int getSize(List<Integer> list){
        return list.size();
    }
}
