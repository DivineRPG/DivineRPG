package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelStoneGolem;
import divinerpg.objects.entities.entity.vanilla.EntityStoneGolem;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderStoneGolem extends RenderLiving<EntityStoneGolem> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/stone_golem.png");

    public RenderStoneGolem(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelStoneGolem(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityStoneGolem entity) {
        return texture;
    }
}