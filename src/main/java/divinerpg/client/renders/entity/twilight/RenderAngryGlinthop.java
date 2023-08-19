package divinerpg.client.renders.entity.twilight;

import divinerpg.DivineRPG;
import divinerpg.client.models.twilight.ModelAngryGlinthop;
import divinerpg.entities.mortum.EntityAngryGlinthop;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderAngryGlinthop extends MobRenderer<EntityAngryGlinthop, ModelAngryGlinthop<EntityAngryGlinthop>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/glinthop_angry.png");

    public RenderAngryGlinthop(EntityRendererProvider.Context context) {
        super(context, new ModelAngryGlinthop<>(context), 0.8F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityAngryGlinthop entity) {
        return TEXTURE;
    }

}