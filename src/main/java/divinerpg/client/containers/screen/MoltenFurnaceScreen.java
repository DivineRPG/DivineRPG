package divinerpg.client.containers.screen;

import divinerpg.*;
import divinerpg.client.containers.*;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class MoltenFurnaceScreen extends InfiniFurnaceScreen<MoltenFurnaceContainer> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/gui/molten_furnace.png");

    public MoltenFurnaceScreen(MoltenFurnaceContainer p_i51089_1_, Inventory p_i51089_2_, Component p_i51089_3_) {
        super(p_i51089_1_, p_i51089_2_, p_i51089_3_, TEXTURE);
    }
}