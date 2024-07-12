package divinerpg.client.screen;

import divinerpg.DivineRPG;
import divinerpg.client.menu.MoltenFurnaceMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class MoltenFurnaceScreen extends InfiniFurnaceScreen<MoltenFurnaceMenu> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/molten_furnace.png");
    public MoltenFurnaceScreen(MoltenFurnaceMenu menu, Inventory inv, Component c) {
        super(menu, inv, c, TEXTURE, 4210752, 4210752);
    }
}