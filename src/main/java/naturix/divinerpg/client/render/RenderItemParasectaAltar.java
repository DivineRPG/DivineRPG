package naturix.divinerpg.client.render;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.blocks.tile.model.ParasectaAltarModel;
import naturix.divinerpg.bases.blocks.tile.render.ItemBakedBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = DivineRPG.modId, value = Side.CLIENT)
public class RenderItemParasectaAltar extends TileEntityItemStackRenderer {
    private final ParasectaAltarModel modelShield = new ParasectaAltarModel();
    private static ItemBakedBase bakedBase;
    private static String textureName;

    public RenderItemParasectaAltar(String textureName) {
        RenderItemParasectaAltar.textureName = textureName;
    }

    @Override
    public void renderByItem(@Nonnull ItemStack stack, float partialTicks) {
        GlStateManager.pushMatrix();
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(DivineRPG.modId + ":textures/model/"+textureName+".png"));
        this.modelShield.render(1);
        GlStateManager.popMatrix();
    }

}