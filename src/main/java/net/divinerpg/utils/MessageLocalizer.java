package net.divinerpg.utils;

import net.minecraft.item.Item;
import net.minecraft.util.StatCollector;

public class MessageLocalizer {
    
    protected static final String STAND = "message.standard", VERS = "message.version";

    public static String normal(String message) {
        return Util.WHITE + StatCollector.translateToLocal(message);
    }
    
    public static String normal(String message, String color) {
        return color + StatCollector.translateToLocal(message);
    }
    
    public static String standard(String player) {
        return Util.AQUA + StatCollector.translateToLocal(STAND).replace("#", player).replace("&", Util.GREEN + "DivineRPG");
    }
    
    public static String version(String vers) {
        return Util.RED + StatCollector.translateToLocal(VERS).replace("#", vers);
    }
}