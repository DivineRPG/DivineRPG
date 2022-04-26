package divinerpg.client.renders.entity.vanilla;


import divinerpg.*;
import divinerpg.client.models.vanilla.*;
import divinerpg.entities.vanilla.overworld.*;
import net.minecraft.client.renderer.culling.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderKobblin extends MobRenderer<EntityKobblin, ModelKobblin<EntityKobblin>> {
    ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/kobblin.png");

    public RenderKobblin(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelKobblin<>(), 0.8F);
    }

    @Override
    public boolean shouldRender(EntityKobblin entity, ClippingHelper p_225626_2_, double p_225626_3_, double p_225626_5_, double p_225626_7_) {
        if(!entity.getProvoked()) {
        return false;
        }else{
            return super.shouldRender(entity, p_225626_2_, p_225626_3_, p_225626_5_, p_225626_7_);
        }
    }

    public ResourceLocation getTextureLocation(EntityKobblin entity) {
        return TEXTURE;
    }
}