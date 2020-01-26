package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelLiopleurodon;
import divinerpg.objects.entities.entity.vanilla.EntityLiopleurodon;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderLiopleurodon extends RenderLiving<EntityLiopleurodon> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/liopleurodon.png");

    public RenderLiopleurodon(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelLiopleurodon(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityLiopleurodon entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityLiopleurodon> {
        @Override
        public Render<? super EntityLiopleurodon> createRenderFor(RenderManager manager) {
            return new RenderLiopleurodon(manager, new ModelLiopleurodon(), 0F);
        }
    }
}