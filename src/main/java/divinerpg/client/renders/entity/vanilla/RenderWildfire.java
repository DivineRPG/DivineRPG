package divinerpg.client.renders.entity.vanilla;

import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.ModelWildfire;
import divinerpg.entities.vanilla.nether.EntityWildfire;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderWildfire extends HumanoidMobRenderer<EntityWildfire, ModelWildfire> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/wildfire.png");
    public RenderWildfire(EntityRendererProvider.Context context) {
        super(context, new ModelWildfire(context.bakeLayer(ModelWildfire.LAYER_LOCATION)), .5F);
    }
    @Override public ResourceLocation getTextureLocation(EntityWildfire entity) {return TEXTURE;}
}