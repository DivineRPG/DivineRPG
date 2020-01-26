package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelCyclops;
import divinerpg.objects.entities.entity.vanilla.EntityCyclops;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderCyclops extends RenderLiving<EntityCyclops> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation cyclopsLoc = new ResourceLocation("divinerpg:textures/entity/cyclops.png");
    ResourceLocation angryCyclopsLoc = new ResourceLocation("divinerpg:textures/entity/angry_cyclops.png");

    public RenderCyclops(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelCyclops(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCyclops cyclops) {
        return cyclops.isAngry() ? angryCyclopsLoc : cyclopsLoc;
    }

    public static class Factory implements IRenderFactory<EntityCyclops> {
        @Override
        public Render<? super EntityCyclops> createRenderFor(RenderManager manager) {
            return new RenderCyclops(manager, new ModelCyclops(), 0F);
        }
    }
}