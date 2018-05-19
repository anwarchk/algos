package com.anwar.ic;

import lombok.ToString;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Anwar
 */

public class MergeKSortedArray {

    @ToString
    static class ArrayContainer implements Comparable<ArrayContainer> {
        int[] arr;
        int index;

        public ArrayContainer(int[] arr, int index) {
            this.arr = arr;
            this.index = index;
        }

        public static ArrayContainer valueOf(int[] arr, int index){
            return new ArrayContainer(arr,index);
        }

        public int compareTo(ArrayContainer o) {
            return this.arr[this.index] - o.arr[o.index];
        }
    }

    public static int[] mergeKSortedArray(int[][] arr) {
        //PriorityQueue is heap in Java
        PriorityQueue<ArrayContainer> queue = new PriorityQueue<ArrayContainer>();
        int total = 0;
        //add arrays to heap
        for (int i = 0; i < arr.length; i++) {
            queue.add(new ArrayContainer(arr[i], 0));
            total = total + arr[i].length;
        }
        System.out.println("Queue ->"+queue);
        int m = 0;
        int result[] = new int[total];
        //while heap is not empty
        while (!queue.isEmpty()) {
            ArrayContainer ac = queue.poll();
            result[m++] = ac.arr[ac.index];
            if (ac.index < ac.arr.length - 1) {
                queue.add(ArrayContainer.valueOf(ac.arr, ac.index + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int[] arr3 = {0, 9, 10, 11};

        int[] result = mergeKSortedArray(new int[][]{arr1, arr2, arr3});

        System.out.println(Arrays.toString(result));
    }
}

