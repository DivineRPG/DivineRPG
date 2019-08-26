package divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.arcana.ModelDeathHound;
import divinerpg.objects.entities.entity.arcana.DeathHound;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDeathHound extends RenderLiving<DeathHound> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/death_hound.png");

    public RenderDeathHound(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDeathHound(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(DeathHound entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<DeathHound> {
        @Override
        public Render<? super DeathHound> createRenderFor(RenderManager manager) {
            return new RenderDeathHound(manager, new ModelDeathHound(), 0);
        }
    }
}