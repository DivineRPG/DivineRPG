package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelCadillion;
import divinerpg.objects.entities.entity.twilight.EntityMortumCadillion;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderMortumCadillion extends RenderLiving<EntityMortumCadillion> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/mortum_cadillion.png");

    public RenderMortumCadillion(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCadillion(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMortumCadillion entity) {
        return texture;
    }
}