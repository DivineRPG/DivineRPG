package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelKobblin;
import divinerpg.objects.entities.entity.vanilla.EntityKobblin;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderKobblin extends RenderLiving<EntityKobblin> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/kobblin.png");

    public RenderKobblin(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelKobblin(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityKobblin entity) {
        return texture;
    }
}