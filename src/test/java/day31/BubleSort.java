package day31;

import java.util.Arrays;
import java.util.Objects;

public class BubleSort {
    public static void main(String[] args) {


        Pizza one = new Pizza();
        Pizza two = new Pizza();
        System.out.println(one.equals(two));

        System.out.println(one.hashCode());
        System.out.println(two.hashCode());


    }
}


class Pizza{
    int size = 0;
    String topping = null;

    public boolean equals(Object o){
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return size == pizza.size && Objects.equals(topping, pizza.topping);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, topping);
    }

}
