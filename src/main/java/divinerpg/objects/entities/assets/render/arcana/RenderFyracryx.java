package divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.arcana.ModelDeathcryx;
import divinerpg.objects.entities.entity.arcana.EntityFyracryx;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderFyracryx extends RenderLiving<EntityFyracryx> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/fyracryx.png");

    public RenderFyracryx(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDeathcryx(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityFyracryx entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityFyracryx> {
        @Override
        public Render<? super EntityFyracryx> createRenderFor(RenderManager manager) {
            return new RenderFyracryx(manager, new ModelDeathcryx(), 0);
        }
    }
}