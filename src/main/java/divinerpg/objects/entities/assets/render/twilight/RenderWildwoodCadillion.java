package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelCadillion;
import divinerpg.objects.entities.entity.twilight.EntityWildwoodCadillion;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderWildwoodCadillion extends RenderLiving<EntityWildwoodCadillion> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/wildwood_cadillion.png");

    public RenderWildwoodCadillion(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCadillion(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWildwoodCadillion entity) {
        return texture;
    }
}