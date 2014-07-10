package net.divinerpg.libs;

import net.minecraft.util.EnumChatFormatting;

public class ChatFormats {

    public static final String   WHITE           = EnumChatFormatting.WHITE.toString();
    public static final String   BLACK           = EnumChatFormatting.BLACK.toString();

    public static final String   RED             = EnumChatFormatting.RED.toString();
    public static final String   BLUE            = EnumChatFormatting.BLUE.toString();
    public static final String   GREEN           = EnumChatFormatting.GREEN.toString();
    public static final String   AQUA            = EnumChatFormatting.AQUA.toString();
    public static final String   GOLD            = EnumChatFormatting.GOLD.toString();
    public static final String   GRAY            = EnumChatFormatting.GRAY.toString();
    public static final String   MAGENTA         = EnumChatFormatting.LIGHT_PURPLE.toString();
    public static final String   YELLOW          = EnumChatFormatting.YELLOW.toString();

    public static final String   DARK_AQUA       = EnumChatFormatting.DARK_AQUA.toString();
    public static final String   DARK_BLUE       = EnumChatFormatting.DARK_BLUE.toString();
    public static final String   DARK_GRAY       = EnumChatFormatting.DARK_GRAY.toString();
    public static final String   DARK_GREEN      = EnumChatFormatting.DARK_GREEN.toString();
    public static final String   PURPLE          = EnumChatFormatting.DARK_PURPLE.toString();
    public static final String   DARK_RED        = EnumChatFormatting.DARK_RED.toString();

    public static final String   BOLD            = EnumChatFormatting.BOLD.toString();
    public static final String   UNDERLINE       = EnumChatFormatting.UNDERLINE.toString();
    public static final String   ITALIC          = EnumChatFormatting.ITALIC.toString();
    public static final String   STRIKE          = EnumChatFormatting.STRIKETHROUGH.toString();
    public static final String   MAGIC           = EnumChatFormatting.OBFUSCATED.toString();

    public static final String   RESET           = EnumChatFormatting.RESET.toString();

    public static final String   ARCANA          = DARK_BLUE + "Arcana" + RESET;
    public static final String   ICEIKA          = AQUA + "Iceika" + RESET;
    public static final String   TWILIGHT        = MAGENTA + "Twilight" + RESET;
    public static final String   EDEN            = PURPLE + "Eden" + RESET;
    public static final String   WILDWOODS       = DARK_GREEN + "Wildwoods" + RESET;
    public static final String   APALACHIA       = DARK_AQUA + "Apalachia" + RESET;
    public static final String   SKYTHERN        = BLUE + "Skythern" + RESET;
    public static final String   MORTUM          = RED + "Mortum" + RESET;
    public static final String   HALITE          = DARK_RED + "Halite" + RESET;
    public static final String   VETHEA          = GREEN + "Vethea" + RESET;

    public static final String[] DIMENSIONS_LIST = new String[] { ARCANA, ICEIKA, TWILIGHT, EDEN, WILDWOODS, APALACHIA, SKYTHERN, MORTUM, VETHEA };

    public static final String DIVINERPG = DARK_AQUA + Reference.MOD_NAME;
}
