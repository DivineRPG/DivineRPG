package divinerpg.objects.blocks.tile.container.gui;

import divinerpg.Reference;
import divinerpg.objects.blocks.tile.entity.TileEntityModFurnace;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class OceanfireFurnaceGUI extends ModFurnaceGUI {
    private static final ResourceLocation TEXTURES = new ResourceLocation(
            Reference.MODID + ":textures/gui/oceanfire_furnace.png");

    public OceanfireFurnaceGUI(InventoryPlayer player, TileEntityModFurnace tileEntity) {
        super(player, tileEntity);
    }

    public ResourceLocation getTexture() {
        return TEXTURES;
    }
}