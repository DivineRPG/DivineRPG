package divinerpg.client.renders.entity.vanilla;

import divinerpg.DivineRPG;
import divinerpg.entities.vanilla.nether.EntityHellPig;
import net.minecraft.client.model.PigModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

import static divinerpg.util.ClientUtils.layerPig;

@OnlyIn(Dist.CLIENT)
public class RenderHellPig extends MobRenderer<EntityHellPig, PigModel<EntityHellPig>> {
    public static final ResourceLocation
    	hellPigLoc = new ResourceLocation(DivineRPG.MODID, "textures/entity/hell_pig.png"),
    	madHellPigLoc = new ResourceLocation(DivineRPG.MODID, "textures/entity/mad_hell_pig.png"),
    	tamedHellPigLoc = new ResourceLocation(DivineRPG.MODID, "textures/entity/tamed_hell_pig.png");

    public RenderHellPig(Context context) {
        super(context, new PigModel<EntityHellPig>(context.bakeLayer(layerPig)), 1.0F);
    }
    @Override
    public ResourceLocation getTextureLocation(EntityHellPig entity) {
        return entity.isTame() ? tamedHellPigLoc : (entity.isAngry() ? madHellPigLoc : hellPigLoc);
    }
}