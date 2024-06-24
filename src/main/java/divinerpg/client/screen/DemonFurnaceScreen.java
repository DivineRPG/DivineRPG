package divinerpg.client.screen;

import divinerpg.DivineRPG;
import divinerpg.client.menu.DemonFurnaceMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
public class DemonFurnaceScreen extends InfiniFurnaceScreen<DemonFurnaceMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/gui/demon_furnace.png");
    public DemonFurnaceScreen(DemonFurnaceMenu menu, Inventory inv, Component c) {
        super(menu, inv, c, TEXTURE, 4210752, 4210752);
    }
}