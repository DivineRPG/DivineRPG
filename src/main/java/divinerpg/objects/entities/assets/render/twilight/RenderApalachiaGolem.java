package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelTwilightGolem;
import divinerpg.objects.entities.entity.twilight.EntityApalachiaGolem;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderApalachiaGolem extends RenderLiving<EntityApalachiaGolem> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/apalachia_golem.png");

    public RenderApalachiaGolem(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelTwilightGolem(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityApalachiaGolem entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityApalachiaGolem> {
        @Override
        public Render<? super EntityApalachiaGolem> createRenderFor(RenderManager manager) {
            return new RenderApalachiaGolem(manager, new ModelTwilightGolem(), 0);
        }
    }
}