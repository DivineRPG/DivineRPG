package divinerpg.client.screen;

import divinerpg.DivineRPG;
import divinerpg.client.menu.WhitefireFurnaceMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class WhitefireFurnaceScreen extends InfiniFurnaceScreen<WhitefireFurnaceMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/gui/whitefire_furnace.png");
    public WhitefireFurnaceScreen(WhitefireFurnaceMenu menu, Inventory inv, Component c) {
        super(menu, inv, c, TEXTURE, 4210752, 4210752);
    }
}