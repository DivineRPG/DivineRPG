package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.vethea.EntityTempleGuardian;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderTempleGuardian extends RenderLiving<EntityTempleGuardian> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/temple_guardian.png");

    public RenderTempleGuardian(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelBiped(), 1F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityTempleGuardian entity) {
        return texture;
    }


}