package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelTomo;
import divinerpg.objects.entities.entity.twilight.EntityApalachiaTomo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderApalachiaTomo extends RenderLiving<EntityApalachiaTomo> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/apalachia_tomo.png");

    public RenderApalachiaTomo(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelTomo(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityApalachiaTomo entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityApalachiaTomo> {
        @Override
        public Render<? super EntityApalachiaTomo> createRenderFor(RenderManager manager) {
            return new RenderApalachiaTomo(manager, new ModelTomo(), 0);
        }
    }
}