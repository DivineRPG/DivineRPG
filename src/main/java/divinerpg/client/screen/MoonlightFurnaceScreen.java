package divinerpg.client.screen;

import divinerpg.DivineRPG;
import divinerpg.client.menu.MoonlightFurnaceMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class MoonlightFurnaceScreen extends DivineFurnaceScreen<MoonlightFurnaceMenu> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/moonlight_furnace.png");
    public static final Identifier MOONLIGHT_FLAME_SPRITE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "moonlight_flame");
    public MoonlightFurnaceScreen(MoonlightFurnaceMenu menu, Inventory inv, Component c) {
        super(menu, inv, c, TEXTURE, 2565186, 2565186, MOONLIGHT_FLAME_SPRITE);
    }
}