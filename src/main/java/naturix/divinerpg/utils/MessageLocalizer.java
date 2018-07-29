package naturix.divinerpg.utils;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.translation.I18n;

public class MessageLocalizer {
    
    protected static final String STAND = "message.standard", VERS = "message.version";

    public static String normal(String message) {
        return Utils.WHITE + I18n.translateToLocal(message);
    }
    
    public static String normal(String message, String color) {
        return color + I18n.translateToLocal(message);
    }
    
    public static String standard(String iTextComponent) {
        return Utils.AQUA + I18n.translateToLocal(STAND).replaceFirst("#", iTextComponent).replace("&", Utils.GREEN + "DivineRPG");
    }
    
    public static String version(String vers) {
        return Utils.RED + I18n.translateToLocal(VERS).replace("#", vers);
    }
}