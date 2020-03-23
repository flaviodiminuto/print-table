package br.com.flaviodiminuto.util;

public class StringUtils {
    public static String checkNull(Object o){
        if(o == null) return "";
        if(String.class.isInstance(o)
            ||Long.class.isInstance(o)
            || Integer.class.isInstance(o)
            || Double.class.isInstance(o)
            || Boolean.class.isInstance(o)
            ||Float.class.isInstance(o))
            return o.toString();
        return "";
    }

    public static String checkNull(int o){
        return o+"";
    }
    public static String checkNull(long o){
        return o+"";
    }
    public static String checkNull(double o){
        return o+"";
    }
    public static String checkNull(float o){
        return o+"";
    }
    public static String checkNull(boolean o){
        return o+"";
    }

}
