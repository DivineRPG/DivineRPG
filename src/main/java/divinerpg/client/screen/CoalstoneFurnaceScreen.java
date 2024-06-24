package divinerpg.client.screen;

import divinerpg.DivineRPG;
import divinerpg.client.menu.CoalstoneFurnaceMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CoalstoneFurnaceScreen extends InfiniFurnaceScreen<CoalstoneFurnaceMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/gui/coalstone_furnace.png");
    public CoalstoneFurnaceScreen(CoalstoneFurnaceMenu menu, Inventory inv, Component c) {
        super(menu, inv, c, TEXTURE, 11974326, 11974326);
    }
}