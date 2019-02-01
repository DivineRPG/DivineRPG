package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelFrost;
import naturix.divinerpg.entities.entity.vanilla.Frost;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderFrost extends RenderLiving<Frost> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/frost.png");

    public RenderFrost(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelFrost(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Frost entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<Frost> {
        @Override
        public Render<? super Frost> createRenderFor(RenderManager manager) {
            return new RenderFrost(manager, new ModelFrost(), 0F);
        }
    }
}