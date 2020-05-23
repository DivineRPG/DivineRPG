package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelStoneGolem;
import divinerpg.objects.entities.entity.vanilla.EntitySmelter;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderSmelter extends RenderLiving<EntitySmelter> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/smelter.png");

    public RenderSmelter(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelStoneGolem(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySmelter entity) {
        return texture;
    }
}