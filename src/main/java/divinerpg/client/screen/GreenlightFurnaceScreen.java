package divinerpg.client.screen;

import divinerpg.DivineRPG;
import divinerpg.client.menu.GreenlightFurnaceMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class GreenlightFurnaceScreen extends DivineFurnaceScreen<GreenlightFurnaceMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/gui/greenlight_furnace.png");
    public GreenlightFurnaceScreen(GreenlightFurnaceMenu menu, Inventory inv, Component c) {
        super(menu, inv, c, TEXTURE, 2107662, 2107662);
    }
}