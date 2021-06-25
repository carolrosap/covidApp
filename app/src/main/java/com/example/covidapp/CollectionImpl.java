package com.example.covidapp;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.covidapp.model.All;
import com.example.covidapp.model.Country;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class CollectionImpl implements Collection {
    Map<String, All> dset = new HashMap<>();
    Iterator it = dset.entrySet().iterator();
    /*Iterator<Map<String, All>> iterator = new Iterator<Map<String, All>>() {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Map<String, All> next() {
            while (iterator.hasNext()){

            }
            return null;
        }
    };
*/
    public CollectionImpl() {
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(@Nullable Object o) {
        return false;
    }

    @NonNull
    @Override
    public Iterator<All> iterator() {




        while (it.hasNext()){
            Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());

        }
        return it;
    }

    @NonNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object all) {
        return false;
    }

    @Override
    public boolean remove(@Nullable Object o) {
        return false;
    }

    @Override
    public boolean addAll(@NonNull Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(@NonNull Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(@NonNull Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(@NonNull Collection c) {
        return false;
    }

    @NonNull
    @Override
    public Object[] toArray(@NonNull Object[] a) {
        return new Object[0];
    }




}
