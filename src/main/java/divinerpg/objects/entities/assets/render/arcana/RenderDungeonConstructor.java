package divinerpg.objects.entities.assets.render.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.arcana.ModelDramix;
import divinerpg.objects.entities.entity.arcana.EntityDungeonConstructor;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

public class RenderDungeonConstructor extends RenderLiving<EntityDungeonConstructor> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/dungeon_constructor.png");

    public RenderDungeonConstructor(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelDramix(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDungeonConstructor entity) {
        return texture;
    }

    @Override
    public void preRenderCallback(EntityDungeonConstructor entity, float f) {
        GL11.glScalef(0.4f, 0.4f, 0.4f);
    }
}