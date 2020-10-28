package com.admin.util;

public class Util {

    public static String generateIdFromUniqueName(String name){
        String _name =name.toLowerCase();
        _name = _name.replaceAll(" ","");
        return _name;
    }
}
