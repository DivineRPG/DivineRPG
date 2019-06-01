package naturix.divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vanilla.ModelRainbour;
import naturix.divinerpg.objects.entities.entity.vanilla.Rainbour;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderRainbour extends RenderLiving<Rainbour> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation rainbourLoc = new ResourceLocation("divinerpg:textures/entity/rainbour.png");
    ResourceLocation angryRainbourLoc = new ResourceLocation("divinerpg:textures/entity/angry_rainbour.png");

    public RenderRainbour(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelRainbour(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Rainbour rainbour) {
        return rainbour.isAngry() ? angryRainbourLoc : rainbourLoc;
    }

    public static class Factory implements IRenderFactory<Rainbour> {
        @Override
        public Render<? super Rainbour> createRenderFor(RenderManager manager) {
            return new RenderRainbour(manager, new ModelRainbour(), 0F);
        }
    }
}