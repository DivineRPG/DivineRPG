package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelMystic;
import divinerpg.objects.entities.entity.twilight.EntityMystic;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMystic extends RenderLiving<EntityMystic> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/mystic.png");

    public RenderMystic(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelMystic(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMystic entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityMystic> {
        @Override
        public Render<? super EntityMystic> createRenderFor(RenderManager manager) {
            return new RenderMystic(manager, new ModelMystic(), 0);
        }
    }
}