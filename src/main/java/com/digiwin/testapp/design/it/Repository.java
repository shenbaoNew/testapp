package com.digiwin.testapp.design.it;

import java.util.Iterator;
import java.util.List;

/**
 * FileName:Container
 * Author: shenbao
 * Date: 2022/5/2 22:14
 * Description:
 */


public class Repository implements Iterable {
    private String[] names = {"she", "nv", "you"};

    @Override
    public Iterator iterator() {
        return new It();
    }

    private class It implements Iterator {
        private int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            return names[index++];
        }
    }
}

class Demo {
    public static void main(String[] args) {
        Repository repository = new Repository();
        for (Object obj : repository) {
            System.out.println(obj);
        }
    }
}