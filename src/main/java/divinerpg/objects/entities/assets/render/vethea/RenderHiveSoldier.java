package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelHiveSoldier;
import divinerpg.objects.entities.entity.vethea.EntityHiveSoldier;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderHiveSoldier extends RenderLiving<EntityHiveSoldier> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/hive_soldier.png");

    public RenderHiveSoldier(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelHiveSoldier(), 1F);

    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityHiveSoldier entity) {
        return texture;
    }


}