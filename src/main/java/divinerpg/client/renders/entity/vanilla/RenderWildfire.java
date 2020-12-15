package divinerpg.client.renders.entity.vanilla;

import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.*;
import divinerpg.client.renders.layer.WildfireBowLayer;
import divinerpg.entities.vanilla.nether.EntityWildfire;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderWildfire extends MobRenderer<EntityWildfire, ModelWildfire<EntityWildfire>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/wildfire.png");

    public RenderWildfire(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelWildfire<>(), 0.8F);
        this.addLayer(new WildfireBowLayer(this));
    }

    public ResourceLocation getEntityTexture(EntityWildfire entity) {
        return TEXTURE;
    }
}