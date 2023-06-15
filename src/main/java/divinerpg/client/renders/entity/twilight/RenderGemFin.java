package divinerpg.client.renders.entity.twilight;

import divinerpg.DivineRPG;
import divinerpg.client.models.twilight.ModelGemFin;
import divinerpg.entities.eden.EntityGemFin;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderGemFin extends MobRenderer<EntityGemFin, ModelGemFin> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/gem_fin/patchy_gem_fin.png");
    private static final ResourceLocation TEXTURE1 = new ResourceLocation(DivineRPG.MODID, "textures/entity/gem_fin/precious_gem_fin.png");
    private static final ResourceLocation TEXTURE2 = new ResourceLocation(DivineRPG.MODID, "textures/entity/gem_fin/ruby_gem_fin.png");

    public RenderGemFin(EntityRendererProvider.Context context) {
        super(context, new ModelGemFin(context), 0.8F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityGemFin entity) {
        if(entity.getVariant() == 0) {
            return TEXTURE;
        } else if (entity.getVariant() == 1) {
            return TEXTURE1;
        } else {
            return TEXTURE2;
        }
    }

}
