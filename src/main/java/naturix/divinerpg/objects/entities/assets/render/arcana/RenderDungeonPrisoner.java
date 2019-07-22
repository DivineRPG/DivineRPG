package naturix.divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.arcana.ModelDungeonPrisoner;
import naturix.divinerpg.objects.entities.entity.arcana.DungeonPrisoner;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDungeonPrisoner extends RenderLiving<DungeonPrisoner> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/dungeon_prisoner.png");

    public RenderDungeonPrisoner(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDungeonPrisoner(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(DungeonPrisoner entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<DungeonPrisoner> {
        @Override
        public Render<? super DungeonPrisoner> createRenderFor(RenderManager manager) {
            return new RenderDungeonPrisoner(manager, new ModelDungeonPrisoner(), 0);
        }
    }
}