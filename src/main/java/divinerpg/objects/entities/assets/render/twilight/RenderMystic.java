package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelMystic;
import divinerpg.objects.entities.entity.twilight.mage.EntityMystic;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderMystic extends RenderLiving<EntityMystic> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/mystic.png");

    public RenderMystic(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelMystic(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMystic entity) {
        return texture;
    }
}