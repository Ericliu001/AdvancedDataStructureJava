package com.ericliu.developer.interview;


import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

/**
 * Created by ericliu on 5/08/2016.
 */

public class Iterator1 {


    public static class FlatternIterator<E> {

        private Queue<Iterator<E>> mIteratorQueue;

        public FlatternIterator(Iterator<Iterator<E>> iteratorIterator) {
            mIteratorQueue = new ArrayDeque<>();
            while (iteratorIterator.hasNext()) {
                mIteratorQueue.add(iteratorIterator.next());
            }
        }


        public boolean hasNext() {
            if (mIteratorQueue.isEmpty()) {
                return false;
            }

            Iterator<E> iterator = mIteratorQueue.peek();

            while (!iterator.hasNext()) {
                if (mIteratorQueue.isEmpty()) {
                    return false;
                }
                iterator = mIteratorQueue.poll();
            }

            return iterator.hasNext();
        }

        public E next() {
            if (hasNext()) {
                Iterator<E> iterator = mIteratorQueue.peek();
                return iterator.next();
            } else {
                return null;
            }

        }

    }

}
