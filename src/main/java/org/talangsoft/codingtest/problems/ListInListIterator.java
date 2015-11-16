package org.talangsoft.codingtest.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Create an iterator which wraps a list containing lists
 */
public class ListInListIterator {

    public static void main(String... arguments){
        List<List<String>> stringMatrix= new ArrayList<>();
        stringMatrix.add(Arrays.asList(new String[]{"a","b","c","d"}));
        stringMatrix.add(Arrays.asList(new String[]{"e","f","g","h"}));
        stringMatrix.add(Arrays.asList(new String[]{"i"}));
        stringMatrix.add(Arrays.asList(new String[]{}));
        stringMatrix.add(Arrays.asList(new String[]{"j","k"}));

        Iterator<String> matrixIt = new MatrixIterator<>(stringMatrix);
        while(matrixIt.hasNext()){
            System.out.println(matrixIt.next());
        }
    }

    static class MatrixIterator<T> implements Iterator<T>{

        private List<List<T>> matrix;

        public MatrixIterator(List<List<T>> matrix) {
            this.matrix = matrix;
        }

        private int rowIndex=0,colIndex=0;

        private int seekRowIndex, seekColIndex;

        @Override
        public boolean hasNext() {
            T nextElement = seekNextElement();
            return nextElement != null;
        }

        @Override
        public T next() {
            T nextElement = seekNextElement();
            rowIndex = seekRowIndex;
            colIndex = seekColIndex;
            return nextElement;
        }

        private T seekNextElement() {
            boolean nextElementFound = false;
            boolean endIsReached = false;
            T nextElement = null;
            seekRowIndex = rowIndex;
            seekColIndex = colIndex;
            while(!nextElementFound && !endIsReached){
                if(seekRowIndex>= matrix.size()){
                    endIsReached = true;
                    continue;
                }
                if(seekColIndex>=matrix.get(seekRowIndex).size()){
                    seekRowIndex++;
                    seekColIndex = 0;
                    continue;
                }
                nextElement = matrix.get(seekRowIndex).get(seekColIndex++);
                nextElementFound = true;
            }
            return nextElement;
        }
    }
}
