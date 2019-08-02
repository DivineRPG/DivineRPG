package naturix.divinerpg.objects.blocks.tile.container.gui;

import naturix.divinerpg.objects.blocks.tile.block.TileEntityModFurnace;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class CoalstoneFurnaceGUI extends ModFurnaceGUI {
    private static final ResourceLocation TEXTURES = new ResourceLocation(
            Reference.MODID + ":textures/gui/coalstone_furnace.png");

    public CoalstoneFurnaceGUI(InventoryPlayer player, TileEntityModFurnace tileEntity) {
        super(player, tileEntity);
    }

    public ResourceLocation getTexture() {
        return TEXTURES;
    }
}