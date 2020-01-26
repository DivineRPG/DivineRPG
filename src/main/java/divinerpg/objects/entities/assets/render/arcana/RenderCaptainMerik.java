package divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelSamek;
import divinerpg.objects.entities.entity.arcana.EntityCaptainMerik;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderCaptainMerik extends RenderLiving<EntityCaptainMerik> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/captain_merik.png");

    public RenderCaptainMerik(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelSamek(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCaptainMerik entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityCaptainMerik> {
        @Override
        public Render<? super EntityCaptainMerik> createRenderFor(RenderManager manager) {
            return new RenderCaptainMerik(manager, new ModelSamek(), 0F);
        }
    }
}