package divinerpg.client.containers.screen;

import divinerpg.*;
import divinerpg.client.containers.*;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class OceanfireFurnaceScreen extends InfiniFurnaceScreen<OceanfireFurnaceContainer> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/gui/oceanfire_furnace.png");

    public OceanfireFurnaceScreen(OceanfireFurnaceContainer p_i51089_1_, Inventory p_i51089_2_, Component p_i51089_3_) {
        super(p_i51089_1_, p_i51089_2_, p_i51089_3_, TEXTURE, 4210752, 4210752);
    }
}
