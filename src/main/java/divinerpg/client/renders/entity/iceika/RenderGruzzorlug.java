package divinerpg.client.renders.entity.iceika;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.iceika.ModelGruzzorlug;
import divinerpg.entities.iceika.gruzzorlug.Gruzzorlug;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderGruzzorlug extends HumanoidMobRenderer<Gruzzorlug, ModelGruzzorlug> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/gruzzorlug.png");
    public RenderGruzzorlug(EntityRendererProvider.Context context) {
        super(context, new ModelGruzzorlug(context.bakeLayer(ModelGruzzorlug.LAYER_LOCATION)), .3F);
    }
    @Override public ResourceLocation getTextureLocation(Gruzzorlug entity) {return TEXTURE;}
    @Override protected void scale(Gruzzorlug type, PoseStack stack, float s) {stack.scale(.8F, .8F, .8F);}
}