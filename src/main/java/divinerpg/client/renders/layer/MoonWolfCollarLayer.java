package divinerpg.client.renders.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.twilight.ModelMoonWolf;
import divinerpg.entities.wildwood.EntityMoonWolf;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class MoonWolfCollarLayer extends RenderLayer<EntityMoonWolf, ModelMoonWolf> {
    private static final ResourceLocation WOLF_COLLAR_LOCATION = new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_collar.png");
    public MoonWolfCollarLayer(RenderLayerParent<EntityMoonWolf, ModelMoonWolf> layer) {super(layer);}
    @Override public void render(PoseStack stack, MultiBufferSource source, int p_117722_, EntityMoonWolf entity, float p_117724_, float p_117725_, float p_117726_, float p_117727_, float p_117728_, float p_117729_) {
        if(entity.isTame() && !entity.isInvisible()) {
            float[] afloat = entity.getCollarColor().getTextureDiffuseColors();
            renderColoredCutoutModel(getParentModel(), WOLF_COLLAR_LOCATION, stack, source, p_117722_, entity, afloat[0], afloat[1], afloat[2]);
        }
    }
}