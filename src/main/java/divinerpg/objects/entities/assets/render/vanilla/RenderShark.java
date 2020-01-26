package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelShark;
import divinerpg.objects.entities.entity.vanilla.EntityShark;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderShark extends RenderLiving<EntityShark> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/shark.png");

    public RenderShark(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelShark(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityShark entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityShark> {
        @Override
        public Render<? super EntityShark> createRenderFor(RenderManager manager) {
            return new RenderShark(manager, new ModelShark(), 0F);
        }
    }
}