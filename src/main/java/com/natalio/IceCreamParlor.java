package main.java.com.natalio;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IceCreamParlor {
    public static class Flavour{
        public int key;
        public int cost;

        public Flavour(int key, int cost) {
            this.key = key;
            this.cost = cost;
        }
    }

    private static Flavour[] mergesort(Flavour[] input) {
        if(input.length <= 1){
            return input;
        }

        int mid = input.length/2;

        return merge(
            mergesort(Arrays.copyOfRange(input, 0, mid)),
            mergesort(Arrays.copyOfRange(input, mid, input.length))
        );
    }

    private static Flavour[] merge(Flavour[] left, Flavour[] right) {
        Flavour[] result = new Flavour[left.length + right.length];
        int l = 0, r = 0, k = 0;

        while (l < left.length && r < right.length){
            result[k++] = left[l].cost <= right[r].cost ? left[l++] : right[r++];
        }

        while (l < left.length){
            result[k++] = left[l++];
        }

        while (r < right.length){
            result[k++] = right[r++];
        }

        return result;
    }

    public static Flavour[] getFlavours(int money, Flavour[] flavours) {
        flavours = mergesort(flavours);

        for(int i = 0; i < flavours.length && flavours[i].cost < money; i++){
            Flavour[] result = binarySearch(money - flavours[i].cost, Arrays.copyOfRange(flavours, i+1, flavours.length), flavours[i]);
            if (result != null) {
                return result;
            }
        }

        return new Flavour[]{};
    }

    private static Flavour[] binarySearch(int search, Flavour[] flavours, Flavour flavour) {
        int low = 0, high = flavours.length-1, mid;

        while (low <= high){
            mid = (high+low) / 2;
            if(flavours[mid].cost == search){
                return flavour.key > flavours[mid].key ? new Flavour[]{flavours[mid], flavour} : new Flavour[]{flavour, flavours[mid]};
            }

            if(search < flavours[mid].cost){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return null;
    }

    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[n];
            Flavour[] allFlavours = new Flavour[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
                allFlavours[a_i] = new Flavour(a_i+1, a[a_i]);
            }

            System.out.println(
                Arrays.stream(getFlavours(m, allFlavours))
                .map(f -> String.valueOf(f.key))
                .collect(Collectors.joining(" "))
            );
        }
    }
}
