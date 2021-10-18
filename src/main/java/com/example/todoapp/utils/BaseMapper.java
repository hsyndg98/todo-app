package com.example.todoapp.utils;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseMapper {
    protected static final ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
    }

    protected BaseMapper() {
    }

    public static <T> T map(Object obj, Class<T> cls) {
        return modelMapper.map(obj, cls);
    }

    public static <T> T map(Object obj, Class<T> cls, String typeMapName) {
        return modelMapper.map(obj, cls, typeMapName);
    }

    public static <T> List<T> mapAll(List sourceList, Class<T> cls) {
        List<T> mappedList = new ArrayList<>(sourceList.size());
        for (Object obj : sourceList) {
            mappedList.add(map(obj, cls));
        }
        return mappedList;
    }

    public static <T> Set<T> mapAll(Set sourceList, Class<T> cls) {
        Set<T> mappedSet = new HashSet<>(sourceList.size());
        for (Object obj : sourceList) {
            mappedSet.add(map(obj, cls));
        }
        return mappedSet;
    }

    public static void map(Object obj, Object to) {
        modelMapper.map(obj, to);
    }
}
