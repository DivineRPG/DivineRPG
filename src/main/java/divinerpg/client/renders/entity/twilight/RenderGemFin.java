package divinerpg.client.renders.entity.twilight;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.client.models.twilight.ModelGemFin;
import divinerpg.entities.eden.EntityGemFin;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderGemFin extends MobRenderer<EntityGemFin, ModelGemFin> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/gem_fin/patchy_gem_fin.png");
    private static final ResourceLocation TEXTURE1 = new ResourceLocation(DivineRPG.MODID, "textures/entity/gem_fin/precious_gem_fin.png");
    private static final ResourceLocation TEXTURE2 = new ResourceLocation(DivineRPG.MODID, "textures/entity/gem_fin/ruby_gem_fin.png");

    public RenderGemFin(EntityRendererProvider.Context context) {
        super(context, new ModelGemFin(context), 0.32F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityGemFin entity) {
    	return switch(entity.getVariant()) {
    	case 0 -> TEXTURE;
    	case 1 -> TEXTURE1;
    	default -> TEXTURE2;
    	};
    }

    protected void setupRotations(EntityGemFin p_114017_, PoseStack p_114018_, float p_114019_, float p_114020_, float p_114021_) {
        super.setupRotations(p_114017_, p_114018_, p_114019_, p_114020_, p_114021_);
        float f = 4.3F * Mth.sin(0.6F * p_114019_);
        p_114018_.mulPose(Axis.YP.rotationDegrees(f));
        if (!p_114017_.isInWater()) {
            p_114018_.translate(0.2F, 0.2F, 0.0F);
            p_114018_.mulPose(Axis.ZP.rotationDegrees(90.0F));
        }
    }
}