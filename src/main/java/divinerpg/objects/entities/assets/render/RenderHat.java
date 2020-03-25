package divinerpg.objects.entities.assets.render;

import divinerpg.api.Reference;
import divinerpg.objects.entities.assets.model.ModelHat;
import divinerpg.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHat implements LayerRenderer<AbstractClientPlayer> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/devhat.png");
	


	 public static class Factory implements IRenderFactory<AbstractClientPlayer> {

	        @Override
	        public Render<? super AbstractClientPlayer> createRenderFor(RenderManager manager) {
				return null;
	         //   return new RenderHat(manager, new ModelHat(), 0.1F);
	        }
	    }
	private final ModelHat ModelHat = new ModelHat();
	public RenderHat(RenderPlayer render) {
	}


	@Override
	public void doRenderLayer(AbstractClientPlayer player, float limbSwing, float limbSwingAmount,
			float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (!Utils.isContributor(player)) {
			return;
		}
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

		GlStateManager.disableBlend();
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Reference.MODID, getTexture(Utils.getWingType(player))));

		GlStateManager.pushMatrix();
		GlStateManager.translate(0.0F, 0.0 - 0.025F, 0.075F);
		GlStateManager.scale(0.5, 0.5, 0.5);
		ModelHat.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, player);
		ModelHat.render(player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		GlStateManager.popMatrix();

	}


	@Override
	public boolean shouldCombineTextures() {
		return false;
	}

	public enum Type {
		RED, BLUE
	}

	private String getTexture(Type type) {
		switch (type) {
			case RED:
				return "textures/models/devhat.png";
			case BLUE:
				return "textures/models/devhat_b.png";
		}
		return "";
	}
	}