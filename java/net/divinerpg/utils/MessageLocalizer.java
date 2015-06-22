package net.divinerpg.utils;

import net.minecraft.item.Item;
import net.minecraft.util.StatCollector;

public class MessageLocalizer {

    protected static final String[] VATT = {"message.vatticus.feel", "message.vatticus.noend", "message.vatticus.strength", "message.vatticus.discover", "message.vatticus.magic"},
            WARGEN = {"message.general.weapons", "message.general.1", "message.general.2"},
            MERCH = {"message.merchant.ho", "message.merchant.out", "message.merchant.in", "message.merchant.burr"},
            JACK = {"message.jackoman.boo", "message.jackoman.lost", "message.jackoman.hurah", "message.jackoman.seen"},
            GUARD = {"message.guardian.up", "message.guardian.places", "message.guardian.doing", "message.guardian.temples", "message.guardian.closer"},
            AYERACO = {"message.ayeraco.green", "message.ayeraco.blue", "message.ayeraco.red", "message.ayeraco.yellow", "message.ayeraco.purple"},
            KAROS = {"message.karos.game", "message.karos.begin", "message.karos.explosion", "message.karos.laugh", "message.karos.doom", "message.karos.cmon", "message.karos.weak"},
            QUADRO = {"message.quadro.die", "message.quadro.enough", "message.quadro.punch", "message.quadro.next", "message.quadro.mine", "message.quadro.kill", "message.quadro.no", "message.quadro.sit", "message.quadro.deserve", "message.quadro.taste"},
            RAGLOK = {"message.raglok.dare", "message.raglok.think", "message.raglok.great", "message.raglok.future", "message.raglok.rain", "message.raglok.kill", "message.raglok.compare", "message.raglok.avenge"},
            WRECK = {"message.wreck.run", "message.wreck.smell", "message.wreck.charge", "message.wreck.pull", "message.wreck.fire", "message.wreck.freeze", "message.wreck.speed", "message.wreck.explosion", "message.wreck.strength"};
    
    protected static final String DEV = "message.developer",
            STAND = "message.standard",
            INTER = "message.internet",
            UPDATE = "message.update",
            NEW = "message.version",
            AYERACOS = "message.ayeraco.spawn";

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
    
    public static String ayeracoAppear(int loc) {
        return StatCollector.translateToLocal(AYERACO[loc]);
    }
    
    public static String ayeracoSpawn() {
        return StatCollector.translateToLocal(AYERACOS);
    }
}