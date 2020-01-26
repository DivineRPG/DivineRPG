package divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import divinerpg.objects.entities.entity.arcana.EntityLordVatticus;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderLordVatticus extends RenderLiving<EntityLordVatticus> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/lord_vatticus.png");

    public RenderLordVatticus(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelBiped(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityLordVatticus entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityLordVatticus> {
        @Override
        public Render<? super EntityLordVatticus> createRenderFor(RenderManager manager) {
            return new RenderLordVatticus(manager, new ModelBiped(), 0F);
        }
    }
}