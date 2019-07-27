package naturix.divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.entity.arcana.LivingStatue;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderLivingStatue extends RenderLiving<LivingStatue> {

    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/living_statue.png");

    public RenderLivingStatue(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelBiped(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(LivingStatue entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<LivingStatue> {
        @Override
        public Render<? super LivingStatue> createRenderFor(RenderManager manager) {
            return new RenderLivingStatue(manager, new ModelBiped(), 0);
        }
    }
}