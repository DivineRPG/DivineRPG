package divinerpg.client.renders.entity.boss;


import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.boss.ModelEternalArcher;
import divinerpg.client.renders.layer.EternalArcherLayer;
import divinerpg.entities.boss.EntityEternalArcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderEternalArcher extends MobRenderer<EntityEternalArcher, ModelEternalArcher<EntityEternalArcher>> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/eternal_archer.png");
    public RenderEternalArcher(Context context) {
        super(context, new ModelEternalArcher<>(context), 0.8F);
        this.addLayer(new EternalArcherLayer(this));
    }
    @Override
    public ResourceLocation getTextureLocation(EntityEternalArcher entity) {
        return TEXTURE;
    }

    @Override
    protected void scale(EntityEternalArcher type, PoseStack stack, float s) {
        stack.scale(2.5F, 2.5F, 2.5F);
    }
}