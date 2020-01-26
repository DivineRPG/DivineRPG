package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelKingScorcher;
import divinerpg.objects.entities.entity.vanilla.EntityKingOfScorchers;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderKingOfScorchers extends RenderLiving<EntityKingOfScorchers> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/king_of_scorchers.png");

    public RenderKingOfScorchers(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelKingScorcher(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityKingOfScorchers entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityKingOfScorchers> {
        @Override
        public Render<? super EntityKingOfScorchers> createRenderFor(RenderManager manager) {
            return new RenderKingOfScorchers(manager, new ModelKingScorcher(), 0F);
        }
    }
}