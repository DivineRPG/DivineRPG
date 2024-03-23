package divinerpg.client.renders.entity.vanilla;

import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.ModelRotatick;
import divinerpg.entities.vanilla.overworld.EntityRotatick;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderRotatick extends MobRenderer<EntityRotatick, EntityModel<EntityRotatick>> {
    private static final ResourceLocation
        TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/rotatick.png"),
        TEXTURE_ALT = new ResourceLocation(DivineRPG.MODID, "textures/entity/rotatick_alt.png");
    public RenderRotatick(EntityRendererProvider.Context context) {
        super(context, new ModelRotatick(context), .6F);
    }
    @Override public ResourceLocation getTextureLocation(EntityRotatick entity) {
        if(entity.isSpecialAlt()) return TEXTURE_ALT;
        else return TEXTURE;
    }
}