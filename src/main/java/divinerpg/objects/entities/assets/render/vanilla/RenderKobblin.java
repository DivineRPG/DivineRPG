package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelKobblin;
import divinerpg.objects.entities.entity.vanilla.EntityKobblin;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderKobblin extends RenderLiving<EntityKobblin> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/kobblin.png");

    public RenderKobblin(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelKobblin(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityKobblin entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityKobblin> {
        @Override
        public Render<? super EntityKobblin> createRenderFor(RenderManager manager) {
            return new RenderKobblin(manager, new ModelKobblin(), 0F);
        }
    }
}