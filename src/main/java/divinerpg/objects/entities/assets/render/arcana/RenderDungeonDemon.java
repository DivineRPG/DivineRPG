package divinerpg.objects.entities.assets.render.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.arcana.ModelDungeonDemon;
import divinerpg.objects.entities.entity.arcana.EntityDungeonDemon;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderDungeonDemon extends RenderLiving<EntityDungeonDemon> {
    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/dungeon_demon.png");

    public RenderDungeonDemon(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelDungeonDemon(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDungeonDemon entity) {
        return texture;
    }
}