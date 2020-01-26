package divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import divinerpg.objects.entities.assets.model.arcana.ModelDramix;
import divinerpg.objects.entities.entity.arcana.EntityDungeonConstructor;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDungeonConstructor extends RenderLiving<EntityDungeonConstructor> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/dungeon_constructor.png");

    public RenderDungeonConstructor(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDramix(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDungeonConstructor entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityDungeonConstructor> {
        @Override
        public Render<? super EntityDungeonConstructor> createRenderFor(RenderManager manager) {
            return new RenderDungeonConstructor(manager, new ModelDramix(), 0);
        }
    }

    @Override
    public void preRenderCallback(EntityDungeonConstructor entity, float f) {
        GL11.glScalef(0.4f, 0.4f, 0.4f);
    }
}