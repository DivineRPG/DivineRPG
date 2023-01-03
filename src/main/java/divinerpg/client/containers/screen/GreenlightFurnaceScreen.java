package divinerpg.client.containers.screen;

import divinerpg.*;
import divinerpg.client.containers.*;
import net.minecraft.client.gui.screens.inventory.*;
import net.minecraft.client.gui.screens.recipebook.*;
import net.minecraft.network.chat.*;
import net.minecraft.resources.*;
import net.minecraft.world.entity.player.*;

public class GreenlightFurnaceScreen extends AbstractFurnaceScreen<GreenlightFurnaceContainer> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/gui/greenlight_furnace.png");

    public GreenlightFurnaceScreen(GreenlightFurnaceContainer p_i51089_1_, Inventory p_i51089_2_, Component p_i51089_3_) {
        super(p_i51089_1_, new SmeltingRecipeBookComponent(), p_i51089_2_, p_i51089_3_, TEXTURE);
    }
}