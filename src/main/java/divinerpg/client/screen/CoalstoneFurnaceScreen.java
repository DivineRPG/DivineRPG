package divinerpg.client.screen;

import divinerpg.*;
import divinerpg.client.menu.*;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CoalstoneFurnaceScreen extends InfiniFurnaceScreen<CoalstoneFurnaceMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/gui/coalstone_furnace.png");

    public CoalstoneFurnaceScreen(CoalstoneFurnaceMenu p_i51089_1_, Inventory p_i51089_2_, Component p_i51089_3_) {
        super(p_i51089_1_, p_i51089_2_, p_i51089_3_, TEXTURE, 11974326, 11974326);
    }
}
