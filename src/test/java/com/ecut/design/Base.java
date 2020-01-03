package com.ecut.design;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;


public class Base{
String key;
    String value;

    public String getKey () {
        return key;
    }

    public void setKey (String key) {
        this.key = key;
    }

    public String getValue () {
        return value;
    }

    public void setValue (String value) {
        this.value = value;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Base base = (Base) o;
        return Objects.equals (key, base.key) &&
                Objects.equals (value, base.value);
    }

    @Override
    public int hashCode () {
        return Objects.hash (key, value);
    }
}
