package divinerpg.objects.blocks.tile.container.gui;

import divinerpg.DivineRPG;
import divinerpg.objects.blocks.tile.entity.TileEntityModFurnace;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GreenlightFurnaceGUI extends ModFurnaceGUI {
    private static final ResourceLocation TEXTURES = new ResourceLocation(
            DivineRPG.MODID + ":textures/gui/greenlight_furnace.png");

    public GreenlightFurnaceGUI(InventoryPlayer player, TileEntityModFurnace tileEntity) {
        super(player, tileEntity);
    }

    public ResourceLocation getTexture() {
        return TEXTURES;
    }
}