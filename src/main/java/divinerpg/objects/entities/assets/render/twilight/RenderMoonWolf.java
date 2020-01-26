package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelMoonWolf;
import divinerpg.objects.entities.entity.twilight.EntityMoonWolf;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMoonWolf extends RenderLiving<EntityMoonWolf> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/moon_wolf.png");

    public RenderMoonWolf(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelMoonWolf(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMoonWolf entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityMoonWolf> {
        @Override
        public Render<? super EntityMoonWolf> createRenderFor(RenderManager manager) {
            return new RenderMoonWolf(manager, new ModelMoonWolf(), 0);
        }
    }
}