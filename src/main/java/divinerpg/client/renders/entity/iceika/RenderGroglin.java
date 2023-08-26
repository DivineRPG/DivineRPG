package divinerpg.client.renders.entity.iceika;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.iceika.ModelGroglin;
import divinerpg.client.renders.layer.GroglinLayer;
import divinerpg.entities.iceika.EntityGroglin;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderGroglin extends MobRenderer<EntityGroglin, ModelGroglin<EntityGroglin>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/groglin.png");

    public RenderGroglin(EntityRendererProvider.Context context) {
        super(context, new ModelGroglin<>(context), 0.4F);
        this.addLayer(new GroglinLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EntityGroglin entity) {
        return TEXTURE;
    }

    @Override
    protected void scale(EntityGroglin type, PoseStack stack, float s) {
        stack.scale(0.8F, 0.8F, 0.8F);
    }
}