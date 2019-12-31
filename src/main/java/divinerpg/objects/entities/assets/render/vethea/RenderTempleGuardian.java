package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.entity.vethea.EntityTempleGuardian;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTempleGuardian extends RenderLiving<EntityTempleGuardian> {

    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/temple_guardian.png");
    private final ModelBiped modelEntity;

    public RenderTempleGuardian(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelBiped(), 1F);
        modelEntity = (ModelBiped) super.mainModel;
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityTempleGuardian entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityTempleGuardian> {

        @Override
        public Render<? super EntityTempleGuardian> createRenderFor(RenderManager manager) {
            return new RenderTempleGuardian(manager, new ModelBiped(), 1F);
        }
    }

}