package divinerpg.objects.entities.assets.render.iceika;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.iceika.ModelAlicanto;
import divinerpg.objects.entities.entity.iceika.EntityAlicanto;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderAlicanto extends RenderLiving<EntityAlicanto> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/alicanto.png");

    public RenderAlicanto(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelAlicanto(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityAlicanto entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityAlicanto> {
        @Override
        public Render<? super EntityAlicanto> createRenderFor(RenderManager manager) {
            return new RenderAlicanto(manager, new ModelAlicanto(), 0F);
        }
    }
}