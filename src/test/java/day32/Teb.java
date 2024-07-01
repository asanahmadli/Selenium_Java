package day32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Teb {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        //count number of 1 follow each other

        List<Integer> arr = new ArrayList();
        while (n != 0) {
            int digit = n % 2;
            arr.add(digit);
            n = n / 2;
        }


        int count = 0;
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == 1) {
                count++;
            }
           else{
               counts.add(count);
               count = 0;
            }

           if(i==arr.size()-1){
               counts.add(count);
               break;
           }
        }

        int result = 0;
        for(int j = 0;j<counts.size();j++){
            if(result<counts.get(j)){
                result = counts.get(j);
            }
        }

        System.out.println(result);
        System.out.println(arr);
        bufferedReader.close();
    }
}
