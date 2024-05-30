package divinerpg.client.renders.entity.iceika;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.iceika.ModelGroglin;
import divinerpg.entities.iceika.groglin.Groglin;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderGroglin extends HumanoidMobRenderer<Groglin, ModelGroglin> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/groglin.png");
    public RenderGroglin(EntityRendererProvider.Context context) {
        super(context, new ModelGroglin(context.bakeLayer(ModelGroglin.LAYER_LOCATION)), .4F);
        addLayer(new HumanoidArmorLayer<>(this, new ModelGroglin(context.bakeLayer(ModelLayers.SKELETON_INNER_ARMOR)), new ModelGroglin(context.bakeLayer(ModelLayers.SKELETON_OUTER_ARMOR)), context.getModelManager()));
    }
    @Override public ResourceLocation getTextureLocation(Groglin entity) {return TEXTURE;}
    @Override protected void scale(Groglin type, PoseStack stack, float s) {stack.scale(.8F, .8F, .8F);}
}