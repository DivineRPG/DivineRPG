package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelTomo;
import divinerpg.objects.entities.entity.twilight.ApalachiaTomo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderApalachiaTomo extends RenderLiving<ApalachiaTomo> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/apalachia_tomo.png");

    public RenderApalachiaTomo(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelTomo(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(ApalachiaTomo entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<ApalachiaTomo> {
        @Override
        public Render<? super ApalachiaTomo> createRenderFor(RenderManager manager) {
            return new RenderApalachiaTomo(manager, new ModelTomo(), 0);
        }
    }
}