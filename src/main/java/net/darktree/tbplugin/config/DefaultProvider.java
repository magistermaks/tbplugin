package net.darktree.tbplugin.config;

public class DefaultProvider {

    public static String provider( String name ) {
        return  "# TBPlugin configuration file, read more on TBPlugin's github page." +
                "\nload_spawn=true" +
                "\ntps_command=false" +
                "\nfreeze_empty=false";
    }

}
