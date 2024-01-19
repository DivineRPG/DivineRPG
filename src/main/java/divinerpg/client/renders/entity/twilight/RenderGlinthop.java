package divinerpg.client.renders.entity.twilight;

import divinerpg.DivineRPG;
import divinerpg.client.models.twilight.ModelGlinthop;
import divinerpg.client.renders.layer.GlinthopCollarLayer;
import divinerpg.entities.eden.EntityGlinthop;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderGlinthop extends MobRenderer<EntityGlinthop, EntityModel<EntityGlinthop>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/glinthop.png");
    private static final ResourceLocation TEXTURE_ALT = new ResourceLocation(DivineRPG.MODID, "textures/entity/glinthop_alt.png");

    public RenderGlinthop(Context context) {
        super(context, new ModelGlinthop<>(context), 0.3F);
        this.addLayer(new GlinthopCollarLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EntityGlinthop entity) {
        if (entity.isSpecialAlt()) {
            return TEXTURE_ALT;
        } else {
            return TEXTURE;
        }
    }

}