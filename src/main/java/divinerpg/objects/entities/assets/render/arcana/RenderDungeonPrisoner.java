package divinerpg.objects.entities.assets.render.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.arcana.ModelDungeonPrisoner;
import divinerpg.objects.entities.entity.arcana.EntityDungeonPrisoner;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderDungeonPrisoner extends RenderLiving<EntityDungeonPrisoner> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/dungeon_prisoner.png");

    public RenderDungeonPrisoner(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelDungeonPrisoner(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDungeonPrisoner entity) {
        return texture;
    }
}