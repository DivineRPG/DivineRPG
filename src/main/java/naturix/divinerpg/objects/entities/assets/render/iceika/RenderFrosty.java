package naturix.divinerpg.objects.entities.assets.render.iceika;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.iceika.ModelFrosty;
import naturix.divinerpg.objects.entities.entity.iceika.Frosty;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderFrosty extends RenderLiving<Frosty> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation frostyLoc = new ResourceLocation("divinerpg:textures/entity/frosty.png");
    ResourceLocation angryFrostyLoc = new ResourceLocation("divinerpg:textures/entity/angry_frosty.png");

    public RenderFrosty(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelFrosty(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Frosty frosty) {
        return (frosty.angerLevel > 0) ? angryFrostyLoc : frostyLoc;
    }

    public static class Factory implements IRenderFactory<Frosty> {
        @Override
        public Render<? super Frosty> createRenderFor(RenderManager manager) {
            return new RenderFrosty(manager, new ModelFrosty(), 0F);
        }
    }
}