package com.example.arraygui;

import javafx.scene.control.MultipleSelectionModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ArrayListManager {
    private List<Integer> array;

    public ArrayListManager(int size) {
        array = new ArrayList<>(size);
    }

    public void populateRandomNumbers(int size) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array.add(random.nextInt(100));
        }
    }

    public List<Integer> getArray() {
        return array;
    }

    public void addNumber(int index, int number) {
        array.add(index, number);
    }

    public void deleteNumber(int index) {
        array.remove(index);
    }

    public int getSize() {
        return array.size();
    }

    public Integer[] getSortedArray() {
        Integer[] sortedArray = array.toArray(new Integer[0]);
        Arrays.sort(sortedArray);
        return sortedArray;
    }

    public void searchNumber(int number, MultipleSelectionModel<Integer> selectionModel) {
        selectionModel.clearSelection();
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == number) {
                selectionModel.select(i);
            }
        }
    }
}
