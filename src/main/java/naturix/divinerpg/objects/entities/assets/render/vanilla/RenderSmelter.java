package naturix.divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vanilla.model.ModelStoneGolem;
import naturix.divinerpg.objects.entities.entity.vanilla.Smelter;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSmelter extends RenderLiving<Smelter> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/smelter.png");

    public RenderSmelter(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelStoneGolem(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Smelter entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<Smelter> {
        @Override
        public Render<? super Smelter> createRenderFor(RenderManager manager) {
            return new RenderSmelter(manager, new ModelStoneGolem(), 0F);
        }
    }
}