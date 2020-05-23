package divinerpg.objects.entities.assets.render.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.arcana.EntityLivingStatue;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderLivingStatue extends RenderLiving<EntityLivingStatue> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/living_statue.png");

    public RenderLivingStatue(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelBiped(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityLivingStatue entity) {
        return texture;
    }
}