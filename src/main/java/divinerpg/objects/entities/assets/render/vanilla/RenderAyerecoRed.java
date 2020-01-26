package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.objects.entities.assets.model.vanilla.ModelAyeraco;
import divinerpg.objects.entities.entity.vanilla.ayeraco.EntityAyeracoRed;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderAyerecoRed extends RenderLiving<EntityAyeracoRed> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/ayeraco_red.png");

    public RenderAyerecoRed(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelAyeraco(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityAyeracoRed entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityAyeracoRed> {
        @Override
        public Render<? super EntityAyeracoRed> createRenderFor(RenderManager manager) {
            return new RenderAyerecoRed(manager, new ModelAyeraco(), 0F);
        }
    }
}