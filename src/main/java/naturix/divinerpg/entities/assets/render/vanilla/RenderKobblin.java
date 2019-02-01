package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelKobblin;
import naturix.divinerpg.entities.entity.vanilla.Kobblin;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderKobblin extends RenderLiving<Kobblin> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/kobblin.png");

    public RenderKobblin(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelKobblin(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Kobblin entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<Kobblin> {
        @Override
        public Render<? super Kobblin> createRenderFor(RenderManager manager) {
            return new RenderKobblin(manager, new ModelKobblin(), 0F);
        }
    }
}