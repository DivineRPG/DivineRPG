package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelMegalith;
import divinerpg.objects.entities.entity.twilight.EntityMegalith;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMegalith extends RenderLiving<EntityMegalith> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/megalith.png");

    public RenderMegalith(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelMegalith(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMegalith entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityMegalith> {
        @Override
        public Render<? super EntityMegalith> createRenderFor(RenderManager manager) {
            return new RenderMegalith(manager, new ModelMegalith(), 0);
        }
    }
}