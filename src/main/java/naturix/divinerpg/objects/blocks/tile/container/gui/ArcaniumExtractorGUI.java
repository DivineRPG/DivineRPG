package naturix.divinerpg.objects.blocks.tile.container.gui;

import naturix.divinerpg.objects.blocks.tile.entity.TileEntityModFurnace;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class ArcaniumExtractorGUI extends ModFurnaceGUI {
    public static final ResourceLocation TEXTURES = new ResourceLocation(
            Reference.MODID + ":textures/gui/arcanium_extractor.png");

    public ArcaniumExtractorGUI(InventoryPlayer player, TileEntityModFurnace tileEntity) {
        super(player, tileEntity);
    }

    public ResourceLocation getTexture() {
        return TEXTURES;
    }
}