package divinerpg.client.renders.entity.boss;


import com.mojang.blaze3d.vertex.*;
import divinerpg.*;
import divinerpg.client.models.boss.*;
import divinerpg.client.renders.base.RenderDivineMob;
import divinerpg.entities.boss.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.*;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderWreck extends RenderDivineMob<EntityWreck> {
    private final EntityModel<EntityWreck> modelMelee, modelArcanic, modelRanged;
    
    private final ResourceLocation 
    	arcanic = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/wreck_arcanic.png"),
    	ranged = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/wreck_ranged.png");

    public RenderWreck(Context context) {
        super(context, "wreck_melee", new ModelWreck(context), 0.8F);
        modelMelee = this.model;
        modelArcanic = new ModelWreckArcanic(context);
        modelRanged = new ModelWreckRanged(context);
    }
    @Override
    public void render(EntityWreck entity, float p_225623_2_, float p_225623_3_, PoseStack p_225623_4_, MultiBufferSource p_225623_5_, int p_225623_6_) {
        this.model = switch(entity.getAbilityType()) {
        case 1 -> modelArcanic;
        case 2 -> modelRanged;
        default -> modelMelee;
        };
        super.render(entity, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
    }
    @Override
    public ResourceLocation getTextureLocation(EntityWreck entity) {
        return switch(entity.getAbilityType()) {
        case 1 -> arcanic;
        case 2 -> ranged;
        default -> TEXTURE;
        };
    }
}