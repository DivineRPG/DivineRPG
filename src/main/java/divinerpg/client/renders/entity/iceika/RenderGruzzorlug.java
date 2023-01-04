package divinerpg.client.renders.entity.iceika;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.iceika.ModelGruzzorlug;
import divinerpg.client.renders.layer.GruzzorlugLayer;
import divinerpg.entities.iceika.EntityGruzzorlug;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderGruzzorlug extends MobRenderer<EntityGruzzorlug, ModelGruzzorlug<EntityGruzzorlug>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/gruzzorlug.png");

    public RenderGruzzorlug(EntityRendererProvider.Context context) {
        super(context, new ModelGruzzorlug<>(context), 0.3F);
        this.addLayer(new GruzzorlugLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EntityGruzzorlug entity) {
        return TEXTURE;
    }

    @Override
    protected void scale(EntityGruzzorlug type, PoseStack stack, float s) {
        stack.scale(0.8F, 0.8F, 0.8F);
    }
}