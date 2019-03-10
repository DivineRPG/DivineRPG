package naturix.divinerpg.objects.blocks.tile.render;

import java.util.Objects;

import javax.annotation.Nonnull;

import naturix.divinerpg.objects.blocks.BaseStatue;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityDramixStatue;
import naturix.divinerpg.objects.blocks.tile.model.ModelDramixStatue;
import naturix.divinerpg.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDramixStatue extends TileEntitySpecialRenderer<TileEntityDramixStatue> {
	private final ModelDramixStatue ModelDramixStatue = new ModelDramixStatue();

	@Override
	public void render(@Nonnull TileEntityDramixStatue te, double x, double y, double z, float partialTicks,
	        int destroyStage, float alpha) {
		GlStateManager.enableDepth();
		GlStateManager.depthFunc(515);
		GlStateManager.depthMask(true);
		int meta;

		if (te.hasWorld()) {
			Block block = te.getBlockType();
			meta = te.getBlockMetadata();
			if (block instanceof BaseStatue && meta == 0) {
				meta = te.getBlockMetadata();
			}
		} else {
			meta = 0;
		}

		if (destroyStage >= 0) {
			this.bindTexture(DESTROY_STAGES[destroyStage]);
			GlStateManager.matrixMode(5890);
			GlStateManager.pushMatrix();
			GlStateManager.scale(4.0F, 4.0F, 1.0F);
			GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
			GlStateManager.matrixMode(5888);
		} else {
			this.bindTexture(new ResourceLocation(Reference.MODID, "textures/blocks/"
			        + Objects.requireNonNull(te.getBlockType().getRegistryName()).getResourcePath() + ".png"));
		}

		GlStateManager.pushMatrix();
		GlStateManager.enableRescaleNormal();

		if (destroyStage < 0) {
			GlStateManager.color(1.0F, 1.0F, 1.0F, alpha);
		}

		GlStateManager.translate((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GlStateManager.scale(1.0F, -1.0F, -1.0F);

		GlStateManager.disableRescaleNormal();
		GlStateManager.popMatrix();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

		if (destroyStage >= 0) {
			GlStateManager.matrixMode(5890);
			GlStateManager.popMatrix();
			GlStateManager.matrixMode(5888);
		}
	}
}