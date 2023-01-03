package divinerpg.client.renders.entity.vanilla;


import divinerpg.DivineRPG;
import divinerpg.client.renders.base.RenderDivineMob;
import divinerpg.entities.vanilla.overworld.EntityCyclops;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

import static divinerpg.util.ClientUtils.layerHumanoid;

@OnlyIn(Dist.CLIENT)
public class RenderCyclops extends RenderDivineMob<EntityCyclops> {
    private final ResourceLocation angryCyclopsLoc = new ResourceLocation(DivineRPG.MODID, "textures/entity/angry_cyclops.png");
    public RenderCyclops(Context context) {
        super(context, "cyclops", new HumanoidModel<EntityCyclops>(context.bakeLayer(layerHumanoid)), 0.8F, 2F);
    }
    @Override
    public ResourceLocation getTextureLocation(EntityCyclops entity) {
        return entity.isAggressive() ? angryCyclopsLoc : TEXTURE;
    }
}