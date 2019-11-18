package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.entity.vethea.TempleGuardian;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTempleGuardian extends RenderLiving<TempleGuardian> {

    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/temple_guardian.png");
    private final ModelBiped modelEntity;

    public RenderTempleGuardian(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelBiped(), 1F);
        modelEntity = (ModelBiped) super.mainModel;
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(TempleGuardian entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<TempleGuardian> {

        @Override
        public Render<? super TempleGuardian> createRenderFor(RenderManager manager) {
            return new RenderTempleGuardian(manager, new ModelBiped(), 1F);
        }
    }

}