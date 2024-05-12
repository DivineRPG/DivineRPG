package divinerpg.util;

import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Rarity;

public class RarityList {
    /** Use these 3 Rarities for yellow, aqua, and light purple colors instead of custom ones:
     * UNCOMMON(ChatFormatting.YELLOW),
     * RARE(ChatFormatting.AQUA),
     * EPIC(ChatFormatting.LIGHT_PURPLE);
     */
    //Extra Base Colors
    public static Rarity GRAY = Rarity.create("gray", ChatFormatting.GRAY);
    public static Rarity DARK_GRAY = Rarity.create("dark_gray", ChatFormatting.DARK_GRAY);
    public static Rarity RED = Rarity.create("red", ChatFormatting.RED);
    public static Rarity GREEN = Rarity.create("green", ChatFormatting.GREEN);
    public static Rarity BLUE = Rarity.create("blue", ChatFormatting.BLUE);
    //Materials
    public static Rarity ENDER = Rarity.create("ender", style -> style.withColor(11294186));
    public static Rarity DIVINE = Rarity.create("divine", style -> style.withColor(16506215));
    public static Rarity EDEN = Rarity.create("eden", style -> style.withColor(15360539));
    public static Rarity WILDWOOD = Rarity.create("wildwood", style -> style.withColor(1484773));
    public static Rarity APALACHIA = Rarity.create("apalachia", style -> style.withColor(13318614));
    public static Rarity SKYTHERN = Rarity.create("skythern", style -> style.withColor(11445945));
    public static Rarity MORTUM = Rarity.create("mortum", style -> style.withColor(7302520));
    public static Rarity HALITE = Rarity.create("halite", style -> style.withColor(6471301));
    public static Rarity AWAKENED_HALITE = Rarity.create("awakened_halite", style -> style.withColor(4451564));
}