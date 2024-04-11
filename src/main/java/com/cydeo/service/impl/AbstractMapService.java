package com.cydeo.service.impl;

import java.util.*;

public abstract class AbstractMapService <T,ID> {

    public Map<ID,T> map = new HashMap<>(); // this is my CUSTOM DATABASE where i will save all my data in application
    // we just created custom database


    // we will create "save" method. ( where we gonna save data ?  )
    T save(ID id, T object) { // it will accept "id" and "object".
        map.put(id,object); // and will added to map above.
        return object ; // and it will return object
    }

    // we'll create findAll.  (  )

    List<T> findAll(){  // we returned list from database (from map.values).

        return new ArrayList<>(map.values());
    }


    T findById(ID id){ // we created findById for bringing objects from data by id
        return map.get(id);
    }

    void deleteById(ID id){ // we will delete object from database if we needed.
        map.remove(id);
    }



}
