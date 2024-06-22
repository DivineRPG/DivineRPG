package divinerpg.client.screen;

import divinerpg.DivineRPG;
import divinerpg.client.menu.MoonlightFurnaceMenu;
import net.minecraft.client.gui.screens.recipebook.SmeltingRecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class MoonlightFurnaceScreen extends DivineFurnaceScreen<MoonlightFurnaceMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/gui/moonlight_furnace.png");
    public MoonlightFurnaceScreen(MoonlightFurnaceMenu menu, Inventory inv, Component component) {
        super(menu, new SmeltingRecipeBookComponent(), inv, component, TEXTURE, 2565186, 2565186);
    }
}