package divinerpg.client.renders.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.entities.eden.EntityGlinthop;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class GlinthopCollarLayer extends RenderLayer<EntityGlinthop, EntityModel<EntityGlinthop>> {
    private static final ResourceLocation GLINTHOP_COLLAR = new ResourceLocation(DivineRPG.MODID, "textures/entity/glinthop_collar.png");

    public GlinthopCollarLayer(RenderLayerParent<EntityGlinthop, EntityModel<EntityGlinthop>> p_117707_) {
        super(p_117707_);
    }

    @Override
    public void render(PoseStack p_117720_, MultiBufferSource p_117721_, int p_117722_, EntityGlinthop p_117723_, float p_117724_, float p_117725_, float p_117726_, float p_117727_, float p_117728_, float p_117729_) {
        if (p_117723_.isTame() && !p_117723_.isInvisible()) {
            float[] afloat = p_117723_.getCollarColor().getTextureDiffuseColors();
            renderColoredCutoutModel(this.getParentModel(), GLINTHOP_COLLAR, p_117720_, p_117721_, p_117722_, p_117723_, afloat[0], afloat[1], afloat[2]);
        }
    }
}