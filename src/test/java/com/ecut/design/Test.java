package com.ecut.design;


import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;

public class Test{

    static  int i;
    public static void main(String[] args) {
        Base base=new Base ();
        Base base2=new Base ();
        Set<Base> set=new HashSet<> ();
        base.setKey ("1");
        base.setValue ("2");
        base2.setKey ("1");

        set.add (base);
        set.add (base2);

        for (Base s:set){
            System.out.println (s.getKey ()+"----"+s.getValue ());
        }
        System.out.println(i);

    }

    private static void changeStr(StringBuffer a) {
        a.append(" World");
    }

}
