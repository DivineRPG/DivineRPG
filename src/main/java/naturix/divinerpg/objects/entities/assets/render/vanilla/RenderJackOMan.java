package naturix.divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vanilla.model.ModelJackOMan;
import naturix.divinerpg.objects.entities.assets.render.MainHandLayerRenderJackOMan;
import naturix.divinerpg.objects.entities.entity.vanilla.JackOMan;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderJackOMan extends RenderLiving<JackOMan> {
    public static final IRenderFactory FACTORY = new Factory();
    public static ResourceLocation TEXTURE = new ResourceLocation("divinerpg:textures/entity/jackoman.png");

    public RenderJackOMan(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelJackOMan(), shadowsizeIn);
        addLayer(new MainHandLayerRenderJackOMan(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(JackOMan entity) {
        return TEXTURE;
    }

    public static class Factory implements IRenderFactory<JackOMan> {
        @Override
        public Render<? super JackOMan> createRenderFor(RenderManager manager) {
            return new RenderJackOMan(manager, new ModelJackOMan(), 0.5F);
        }
    }
}