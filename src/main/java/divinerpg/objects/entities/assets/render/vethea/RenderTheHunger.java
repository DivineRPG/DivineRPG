package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelTheHunger;
import divinerpg.objects.entities.entity.vethea.EntityTheHunger;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderTheHunger extends RenderLiving<EntityTheHunger> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/the_hunger.png");

    public RenderTheHunger(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelTheHunger(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityTheHunger entity) {
        return texture;
    }
}