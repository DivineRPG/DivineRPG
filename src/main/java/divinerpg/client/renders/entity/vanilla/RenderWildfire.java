package divinerpg.client.renders.entity.vanilla;

import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.*;
import divinerpg.client.renders.layer.WildfireBowLayer;
import divinerpg.entities.vanilla.nether.EntityWildfire;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderWildfire extends MobRenderer<EntityWildfire, ModelWildfire> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/wildfire.png");
    public RenderWildfire(Context context) {
        super(context, new ModelWildfire(context), 0.8F);
        this.addLayer(new WildfireBowLayer(this));
    }
    @Override
    public ResourceLocation getTextureLocation(EntityWildfire entity) {
        return TEXTURE;
    }
}