package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelStoneGolem;
import divinerpg.objects.entities.entity.vanilla.EntityStoneGolem;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderStoneGolem extends RenderLiving<EntityStoneGolem> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/stone_golem.png");

    public RenderStoneGolem(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelStoneGolem(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityStoneGolem entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityStoneGolem> {
        @Override
        public Render<? super EntityStoneGolem> createRenderFor(RenderManager manager) {
            return new RenderStoneGolem(manager, new ModelStoneGolem(), 0F);
        }
    }
}