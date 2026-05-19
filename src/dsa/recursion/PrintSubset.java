package dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubset {

    static void fun(int[] arr,int n,int idx,List<Integer> tmp){
        if(idx==n){
            for(int i=0;i<tmp.size();i++){
                System.out.print(tmp.get(i)+" ");
            }
            System.out.println();
            return;
        }
        // don't take
        fun(arr,n,idx+1,tmp);

        //take
        tmp.add(arr[idx]);
        fun(arr,n,idx+1,tmp);
        tmp.remove(tmp.size()-1);
        return;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        List<Integer> tmp = new ArrayList<>();
        fun(arr, arr.length, 0, tmp);
    }
}
