package divinerpg.client.screen;

import divinerpg.DivineRPG;
import divinerpg.client.menu.GreenlightFurnaceMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class GreenlightFurnaceScreen extends DivineFurnaceScreen<GreenlightFurnaceMenu> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/greenlight_furnace.png");
    public static final Identifier GREENLIGHT_FLAME_SPRITE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "greenlight_flame");
    public GreenlightFurnaceScreen(GreenlightFurnaceMenu menu, Inventory inv, Component c) {
        super(menu, inv, c, TEXTURE, 2107662, 2107662, GREENLIGHT_FLAME_SPRITE);
    }
}