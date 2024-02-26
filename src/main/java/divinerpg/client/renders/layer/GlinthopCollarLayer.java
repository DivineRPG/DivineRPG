package divinerpg.client.renders.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.twilight.ModelGlinthop;
import divinerpg.entities.eden.EntityGlinthop;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class GlinthopCollarLayer extends RenderLayer<EntityGlinthop, ModelGlinthop> {
    private static final ResourceLocation GLINTHOP_COLLAR = new ResourceLocation(DivineRPG.MODID, "textures/entity/glinthop_collar.png");
    public GlinthopCollarLayer(RenderLayerParent<EntityGlinthop, ModelGlinthop> layer) {super(layer);}
    @Override public void render(PoseStack stack, MultiBufferSource source, int p_117722_, EntityGlinthop entity, float p_117724_, float p_117725_, float p_117726_, float p_117727_, float p_117728_, float p_117729_) {
        if(entity.isTame() && !entity.isInvisible()) {
            float[] afloat = entity.getCollarColor().getTextureDiffuseColors();
            renderColoredCutoutModel(getParentModel(), GLINTHOP_COLLAR, stack, source, p_117722_, entity, afloat[0], afloat[1], afloat[2]);
        }
    }
}