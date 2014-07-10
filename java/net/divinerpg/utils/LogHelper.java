package net.divinerpg.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.Level;

import net.divinerpg.libs.Reference;

import cpw.mods.fml.common.FMLLog;

public class LogHelper {

    private static BufferedWriter writer;
    
    static{
        File dir = new File("./DivineRPG");
        dir.mkdir();
        dir = new File("./DivineRPG/debug.log");
        try {
            writer = new BufferedWriter(new FileWriter(dir));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void log(Level level, Object msg) {
        FMLLog.log(Reference.MOD_NAME, level, msg.toString());
        System.err.println(msg);
        writeFile(msg);
        flush();
    }

    public static void debug(Object msg) {
        if (Reference.DEBUG) log(Level.DEBUG, "[DEBUG] " + msg);
    }

    public static void error(Object msg) {
        log(Level.ERROR, msg);
    }

    public static void info(Object msg) {
        log(Level.INFO, msg);
    }

    public static void warn(Object msg) {
        log(Level.WARN, msg);
    }

    public static void dev(Object msg) {
        log(Level.INFO, "[DEVELOPMENT] " + msg);
    }
    
    public static void writeFile(Object msg){
        try {
            writer.write(msg + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void flush(){
        try {
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void closeFile() {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
