package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelWhale;
import divinerpg.objects.entities.entity.vanilla.EntityWhale;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWhale extends RenderLiving<EntityWhale> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/whale.png");

    public RenderWhale(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelWhale(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWhale entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityWhale> {
        @Override
        public Render<? super EntityWhale> createRenderFor(RenderManager manager) {
            return new RenderWhale(manager, new ModelWhale(), 0F);
        }
    }
}