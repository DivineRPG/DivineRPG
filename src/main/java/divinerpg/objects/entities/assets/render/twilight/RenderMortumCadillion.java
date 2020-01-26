package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelCadillion;
import divinerpg.objects.entities.entity.twilight.EntityMortumCadillion;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMortumCadillion extends RenderLiving<EntityMortumCadillion> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/mortum_cadillion.png");

    public RenderMortumCadillion(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelCadillion(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMortumCadillion entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityMortumCadillion> {
        @Override
        public Render<? super EntityMortumCadillion> createRenderFor(RenderManager manager) {
            return new RenderMortumCadillion(manager, new ModelCadillion(), 0);
        }
    }
}