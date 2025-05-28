package divinerpg.client.renders.entity.vanilla;

import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.ModelTheEye;
import divinerpg.entities.vanilla.overworld.EntityTheEye;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderTheEye extends MobRenderer<EntityTheEye, ModelTheEye> {
    private static final ResourceLocation
            texture = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/the_eye.png"),
            madTexture = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/the_eye_angry.png");
    public RenderTheEye(Context context) {super(context, new ModelTheEye(context), .7F);}
    @Override public ResourceLocation getTextureLocation(EntityTheEye entity) {
        return entity.isAggressive() ? madTexture : texture;
    }
}