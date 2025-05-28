package divinerpg.client.renders.entity.vanilla;

import divinerpg.DivineRPG;
import divinerpg.client.renders.base.RenderDivineMob;
import divinerpg.entities.vanilla.overworld.EntityCyclops;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

import static divinerpg.util.ClientUtils.layerHumanoid;

@OnlyIn(Dist.CLIENT)
public class RenderCyclops extends RenderDivineMob<EntityCyclops> {
    private final ResourceLocation angryCyclopsLoc = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/cyclops_angry.png");
    public RenderCyclops(Context context) {
        super(context, "cyclops", new HumanoidModel<>(context.bakeLayer(layerHumanoid)), .8F, 2);
    }
    @Override public ResourceLocation getTextureLocation(EntityCyclops entity) {
        return entity.isAggressive() ? angryCyclopsLoc : TEXTURE;
    }
}