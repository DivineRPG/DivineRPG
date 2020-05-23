package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelHiveQueen;
import divinerpg.objects.entities.entity.vethea.EntityHiveQueen;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderHiveQueen extends RenderLiving<EntityHiveQueen> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/hive_queen.png");

    public RenderHiveQueen(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelHiveQueen(), 1F);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityHiveQueen entity) {
        return texture;
    }


}