package divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.arcana.ModelDungeonDemon;
import divinerpg.objects.entities.entity.arcana.EntityDungeonDemon;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDungeonDemon extends RenderLiving<EntityDungeonDemon> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/dungeon_demon.png");

    public RenderDungeonDemon(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDungeonDemon(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDungeonDemon entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityDungeonDemon> {
        @Override
        public Render<? super EntityDungeonDemon> createRenderFor(RenderManager manager) {
            return new RenderDungeonDemon(manager, new ModelDungeonDemon(), 0);
        }
    }
}