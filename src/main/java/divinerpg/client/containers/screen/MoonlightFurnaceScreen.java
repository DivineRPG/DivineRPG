package divinerpg.client.containers.screen;

import divinerpg.DivineRPG;
import divinerpg.client.containers.MoonlightFurnaceContainer;
import net.minecraft.client.gui.screens.recipebook.SmeltingRecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class MoonlightFurnaceScreen extends DivineFurnaceScreen<MoonlightFurnaceContainer> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/gui/moonlight_furnace.png");

    public MoonlightFurnaceScreen(MoonlightFurnaceContainer p_i51089_1_, Inventory p_i51089_2_, Component p_i51089_3_) {
        super(p_i51089_1_, new SmeltingRecipeBookComponent(), p_i51089_2_, p_i51089_3_, TEXTURE);
    }
}