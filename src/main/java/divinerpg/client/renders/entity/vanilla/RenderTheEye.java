package divinerpg.client.renders.entity.vanilla;

import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.ModelTheEye;
import divinerpg.entities.vanilla.overworld.EntityTheEye;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderTheEye extends MobRenderer<EntityTheEye, EntityModel<EntityTheEye>> {
    private static final ResourceLocation
            texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/the_eye.png"),
            madTexture = new ResourceLocation(DivineRPG.MODID, "textures/entity/the_eye_angry.png");

    public RenderTheEye(Context context) {
        super(context, new ModelTheEye(context), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityTheEye theEye) {
        return theEye.getTarget() != null ? texture : madTexture;
    }
}