package divinerpg.client.renders.entity.iceika;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.iceika.ModelGruzzorlug;
import divinerpg.client.renders.layer.GruzzorlugLayer;
import divinerpg.entities.iceika.gruzzorlug.Gruzzorlug;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderGruzzorlug extends MobRenderer<Gruzzorlug, ModelGruzzorlug<Gruzzorlug>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/gruzzorlug.png");

    public RenderGruzzorlug(EntityRendererProvider.Context context) {
        super(context, new ModelGruzzorlug<>(context), 0.3F);
        this.addLayer(new GruzzorlugLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Gruzzorlug entity) {
        return TEXTURE;
    }

    @Override
    protected void scale(Gruzzorlug type, PoseStack stack, float s) {
        stack.scale(0.8F, 0.8F, 0.8F);
    }
}