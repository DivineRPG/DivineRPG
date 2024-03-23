package divinerpg.client.renders.entity.twilight;

import divinerpg.DivineRPG;
import divinerpg.client.models.twilight.ModelGlinthop;
import divinerpg.client.renders.layer.GlinthopCollarLayer;
import divinerpg.entities.eden.EntityGlinthop;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderGlinthop extends MobRenderer<EntityGlinthop, ModelGlinthop> {
    private static final ResourceLocation
        TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/glinthop.png"),
        TEXTURE_ALT = new ResourceLocation(DivineRPG.MODID, "textures/entity/glinthop_alt.png");
    public RenderGlinthop(EntityRendererProvider.Context context) {
        super(context, new ModelGlinthop(context), .3F);
        addLayer(new GlinthopCollarLayer(this));
    }
    @Override public ResourceLocation getTextureLocation(EntityGlinthop entity) {
        if(entity.isSpecialAlt()) return TEXTURE_ALT;
        else return TEXTURE;
    }
}