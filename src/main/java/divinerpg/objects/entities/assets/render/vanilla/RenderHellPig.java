package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.vanilla.EntityHellPig;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderHellPig extends RenderLiving<EntityHellPig> {

    ResourceLocation hellPigLoc = new ResourceLocation(DivineRPG.MODID, "textures/entity/hell_pig.png");
    ResourceLocation madHellPigLoc = new ResourceLocation(DivineRPG.MODID, "textures/entity/mad_hell_pig.png");
    ResourceLocation tamedHellPigLoc = new ResourceLocation(DivineRPG.MODID, "textures/entity/tamed_hell_pig.png");

    public RenderHellPig(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelPig(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityHellPig hellPig) {
        return hellPig.isTamed() ? tamedHellPigLoc : (hellPig.isAngry() ? madHellPigLoc : hellPigLoc);
    }
}