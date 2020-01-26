package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelSnapper;
import divinerpg.objects.entities.entity.vanilla.EntitySnapper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSnapper extends RenderLiving<EntitySnapper> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/snapper.png");

    public RenderSnapper(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelSnapper(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySnapper entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntitySnapper> {
        @Override
        public Render<? super EntitySnapper> createRenderFor(RenderManager manager) {
            return new RenderSnapper(manager, new ModelSnapper(), 0F);
        }
    }
}