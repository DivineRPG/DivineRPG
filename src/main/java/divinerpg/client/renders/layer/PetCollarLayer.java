package divinerpg.client.renders.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.entities.vanilla.nether.EntityHellPig;
import divinerpg.entities.vanilla.overworld.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class PetCollarLayer extends RenderLayer<EntityDivineTameable, EntityModel<EntityDivineTameable>> {
    private static final ResourceLocation
            EHU_COLLAR = new ResourceLocation(DivineRPG.MODID, "textures/entity/ehu_collar.png"),
            HELL_PIG_COLLAR = new ResourceLocation(DivineRPG.MODID, "textures/entity/hell_pig/hell_pig_collar.png"),
            SNAPPER_COLLAR = new ResourceLocation(DivineRPG.MODID, "textures/entity/snapper_collar.png");

    public PetCollarLayer(RenderLayerParent<EntityDivineTameable, EntityModel<EntityDivineTameable>> p_117707_) {
        super(p_117707_);
    }

    private ResourceLocation texture(Entity entity){
        if (entity instanceof EntityEhu) {
            return EHU_COLLAR;
        } else if (entity instanceof EntityHellPig) {
            return HELL_PIG_COLLAR;
        } else if (entity instanceof EntitySnapper) {
            return SNAPPER_COLLAR;
        } else {
            return null;
        }
    }

    @Override
    public void render(PoseStack p_117720_, MultiBufferSource p_117721_, int p_117722_, EntityDivineTameable p_117723_, float p_117724_, float p_117725_, float p_117726_, float p_117727_, float p_117728_, float p_117729_) {
        if (p_117723_.isTame() && !p_117723_.isInvisible()) {
            float[] afloat = p_117723_.getCollarColor().getTextureDiffuseColors();
            renderColoredCutoutModel(this.getParentModel(), texture(p_117723_), p_117720_, p_117721_, p_117722_, p_117723_, afloat[0], afloat[1], afloat[2]);
        }
    }
}