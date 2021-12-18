package divinerpg.client.containers.screen;

import divinerpg.*;
import divinerpg.client.containers.*;
import net.minecraft.client.gui.recipebook.*;
import net.minecraft.client.gui.screen.inventory.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;

public class GreenlightFurnaceScreen extends AbstractFurnaceScreen<GreenlightFurnaceContainer> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/gui/greenlight_furnace.png");

    public GreenlightFurnaceScreen(GreenlightFurnaceContainer p_i51089_1_, PlayerInventory p_i51089_2_, ITextComponent p_i51089_3_) {
        super(p_i51089_1_, new FurnaceRecipeGui(), p_i51089_2_, p_i51089_3_, TEXTURE);
    }
}