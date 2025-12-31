package divinerpg.client.renders.entity.vanilla;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.client.models.vanilla.ModelEnderSpider;
import divinerpg.client.renders.layer.CarriedBlockEnderSpider;
import divinerpg.entities.vanilla.end.EntityEnderSpider;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.OnlyIn;

import static divinerpg.DivineRPG.MODID;
import static net.neoforged.api.distmarker.Dist.CLIENT;

@OnlyIn(CLIENT)
public class RenderEnderSpider extends MobRenderer<EntityEnderSpider, ModelEnderSpider> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/ender_spider.png");
    public RenderEnderSpider(EntityRendererProvider.Context context) {
        super(context, new ModelEnderSpider(context), .5F);
        addLayer(new CarriedBlockEnderSpider(this, context.getBlockRenderDispatcher()));
    }
    @Override protected void scale(EntityEnderSpider entity, PoseStack stack, float partialTickTime) {stack.scale(.6F, .6F, .6F);}
    @Override public ResourceLocation getTextureLocation(EntityEnderSpider entity) {return TEXTURE;}
}