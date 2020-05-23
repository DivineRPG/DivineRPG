package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelMage;
import divinerpg.objects.entities.entity.twilight.mage.EntityMage;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderMage extends RenderLiving<EntityMage> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/mage.png");

    public RenderMage(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelMage(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMage entity) {
        return texture;
    }
}