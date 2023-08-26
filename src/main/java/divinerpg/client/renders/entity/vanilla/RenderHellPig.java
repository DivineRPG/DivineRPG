package divinerpg.client.renders.entity.vanilla;

import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.*;
import divinerpg.entities.vanilla.nether.EntityHellPig;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderHellPig extends MobRenderer<EntityHellPig, ModelHellPig<EntityHellPig>> {

    public RenderHellPig(Context context) {
        super(context, new ModelHellPig<>(context), 0.7F);
    }

    public static final ResourceLocation
    	hellPigLoc = new ResourceLocation(DivineRPG.MODID, "textures/entity/hell_pig.png"),
    	madHellPigLoc = new ResourceLocation(DivineRPG.MODID, "textures/entity/mad_hell_pig.png"),
    	tamedHellPigLoc = new ResourceLocation(DivineRPG.MODID, "textures/entity/tamed_hell_pig.png");

    @Override
    public ResourceLocation getTextureLocation(EntityHellPig entity) {
        return entity.isTame() ? tamedHellPigLoc : (entity.isAngry() ? madHellPigLoc : hellPigLoc);
    }
}