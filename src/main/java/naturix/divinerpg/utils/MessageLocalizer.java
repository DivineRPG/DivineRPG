package naturix.divinerpg.utils;

import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

public class MessageLocalizer {

    protected static final String STAND = "message.standard", VERS = "message.version";

    public static String normal(String message) {
        return Utils.WHITE + new TextComponentTranslation(message).getFormattedText();
    }

    public static String normal(String message, TextFormatting format) {
        return format + new TextComponentTranslation(message).getFormattedText();
    }

    public static String standard(String iTextComponent) {
        return Utils.AQUA + new TextComponentTranslation(STAND).getFormattedText().replaceFirst("#", iTextComponent)
                .replace("&", Utils.GREEN + "DivineRPG");
    }

    public static String version(String vers) {
        return Utils.RED + new TextComponentTranslation(VERS).getFormattedText().replace("#", vers);
    }
}