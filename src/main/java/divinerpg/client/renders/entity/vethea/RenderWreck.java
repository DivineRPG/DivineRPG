package divinerpg.client.renders.entity.vethea;


import com.mojang.blaze3d.matrix.*;
import divinerpg.*;
import divinerpg.client.models.boss.*;
import divinerpg.entities.boss.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.util.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderWreck extends MobRenderer<EntityWreck, SegmentedModel<EntityWreck>> {
    private SegmentedModel form1 = new ModelWreckForm1<EntityWreck>();
    private SegmentedModel form2 = new ModelWreckForm2<EntityWreck>();
    private SegmentedModel form3 = new ModelWreckForm3<EntityWreck>();

    public RenderWreck(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelWreckForm1<EntityWreck>(), 0.8F);


    }

    @Override
    public void render(EntityWreck entity, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, IRenderTypeBuffer p_225623_5_, int p_225623_6_) {
        super.render(entity, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
        if(entity.getAbilityType() == 0) {
            this.model = (ModelWreckForm1<EntityWreck>) form1;
        }
        else if (entity.getAbilityType() == 1) {
            this.model = (ModelWreckForm2<EntityWreck>) form2;
        } else {
            this.model = (ModelWreckForm3<EntityWreck>) form3;
        }
    }

    @Override
    public ResourceLocation getTextureLocation(EntityWreck entity) {
        EntityWreck wreck = (EntityWreck)entity;
        if(wreck.getAbilityType() == 0) {
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/wreck_melee.png");
        } else if(wreck.getAbilityType() == 1) {
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/wreck_arcanic.png");
        } else if(wreck.getAbilityType() == 2) {
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/wreck_ranged.png");
        }
        return new ResourceLocation(DivineRPG.MODID, "textures/entity/wreck_melee.png");
    }



}