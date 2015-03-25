package net.divinerpg.utils;

import net.minecraft.item.Item;
import net.minecraft.util.StatCollector;

public class MessageLocalizer {

    protected static final String[] VATT = {"message.vatticus0", "message.vatticus1", "message.vatticus2", "message.vatticus3", "message.vatticus4"},
            WARGEN = {"message.general0", "message.general1", "message.general2", "message.general3"},
            MERCH = {"message.merchant0", "message.merchant1", "message.merchant2", "message.merchant3"},
            JACK = {"message.jackoman0", "message.jackoman1", "message.jackoman2", "message.jackoman3"},
            GUARD = {"message.guardian0", "message.guardian1", "message.guardian2", "message.guardian3", "message.guardian4"},
            AYERACO = {"message.ayeraco0", "message.ayeraco1", "message.ayeraco2", "message.ayeraco3", "message.ayeraco4"},
            KAROS = {"message.karos0", "message.karos1", "message.karos2", "message.karos3", "message.karos4", "message.karos5", "message.karos6"},
            QUADRO = {"message.quadro0", "message.quadro1", "message.quadro2", "message.quadro3", "message.quadro4", "message.quadro5", "message.quadro6", "message.quadro7", "message.quadro8", "message.quadro9"},
            RAGLOK = {"message.raglok0", "message.raglok1", "message.raglok2", "message.raglok3", "message.raglok4", "message.raglok5", "message.raglok6", "message.raglok7"},
            WRECK = {"message.wreck0", "message.wreck1", "message.wreck2", "message.wreck3", "message.wreck4", "message.wreck5", "message.wreck6", "message.wreck7", "message.wreck8"};
    
    protected static final String DEV = "message.developer",
            STAND = "message.standard",
            INTER = "message.internet",
            UPDATE = "message.update",
            NEW = "message.version",
            AYERACOS = "message.ayeracospawn";

    public static String vatticus(int loc) {
        return StatCollector.translateToLocal(VATT[loc]);
    }
    
    public static String general(int loc) {
        return StatCollector.translateToLocal(WARGEN[loc]);
    }
    
    public static String merchant(int loc) {
        return StatCollector.translateToLocal(MERCH[loc]);
    }
    
    public static String jackOMan(int loc) {
        return StatCollector.translateToLocal(JACK[loc]);
    }
    
    public static String guardian(int loc) {
        return StatCollector.translateToLocal(GUARD[loc]);
    }
    
    public static String karos(int loc) {
        return "Dr. Karos: " + StatCollector.translateToLocal(KAROS[loc]);
    }
    
    public static String quadro(int loc) {
        return "Quadro: " + StatCollector.translateToLocal(QUADRO[loc]);
    }
    
    public static String raglok(int loc) {
        return "Raglok: " + StatCollector.translateToLocal(RAGLOK[loc]);
    }
    
    public static String wreck(int loc) {
        return "Wreck: " + StatCollector.translateToLocal(WRECK[loc]);
    }
    
    public static String developer() {
        return Util.AQUA + StatCollector.translateToLocal(DEV);
    }
    
    public static String standard(String player) {
        return StatCollector.translateToLocal(STAND).replace("#", player).replace("&", Util.GREEN + "DivineRPG");
    }
    
    public static String internet() {
        return StatCollector.translateToLocal(INTER);
    }
    
    public static String update() {
        return StatCollector.translateToLocal(UPDATE);
    }
    
    public static String version(String vers) {
        return StatCollector.translateToLocal(NEW).replace("#", vers);
    }
    
    public static String ayeracoColors(int loc) {
        return StatCollector.translateToLocal(AYERACO[loc]);
    }
    
    public static String ayeracoSpawn() {
        return StatCollector.translateToLocal(AYERACOS);
    }
}