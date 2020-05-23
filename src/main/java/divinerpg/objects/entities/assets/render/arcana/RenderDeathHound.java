package divinerpg.objects.entities.assets.render.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.arcana.ModelDeathHound;
import divinerpg.objects.entities.entity.arcana.death.EntityDeathHound;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderDeathHound extends RenderLiving<EntityDeathHound> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/death_hound.png");

    public RenderDeathHound(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelDeathHound(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDeathHound entity) {
        return texture;
    }

}