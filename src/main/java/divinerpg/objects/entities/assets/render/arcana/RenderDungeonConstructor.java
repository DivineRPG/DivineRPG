package divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import divinerpg.objects.entities.assets.model.arcana.ModelDramix;
import divinerpg.objects.entities.entity.arcana.DungeonConstructor;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDungeonConstructor extends RenderLiving<DungeonConstructor> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/dungeon_constructor.png");

    public RenderDungeonConstructor(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDramix(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(DungeonConstructor entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<DungeonConstructor> {
        @Override
        public Render<? super DungeonConstructor> createRenderFor(RenderManager manager) {
            return new RenderDungeonConstructor(manager, new ModelDramix(), 0);
        }
    }

    @Override
    public void preRenderCallback(DungeonConstructor entity, float f) {
        GL11.glScalef(0.4f, 0.4f, 0.4f);
    }
}