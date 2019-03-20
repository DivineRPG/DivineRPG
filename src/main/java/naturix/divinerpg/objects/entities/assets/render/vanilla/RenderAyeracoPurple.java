package naturix.divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vanilla.model.ModelAyeraco;
import naturix.divinerpg.objects.entities.entity.vanilla.AyeracoPurple;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderAyeracoPurple extends RenderLiving<AyeracoPurple> {

    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/ayeraco_purple.png");

    public RenderAyeracoPurple(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelAyeraco(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(AyeracoPurple entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<AyeracoPurple> {
        @Override
        public Render<? super AyeracoPurple> createRenderFor(RenderManager manager) {
            return new RenderAyeracoPurple(manager, new ModelAyeraco(), 0F);
        }
    }
}