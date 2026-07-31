package divinerpg.client.renders.entity.vanilla;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.client.models.vanilla.ModelEnderSpider;
import divinerpg.entities.vanilla.end.EntityEnderSpider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

import static divinerpg.DivineRPG.MODID;


public class RenderEnderSpider extends MobRenderer<EntityEnderSpider, LivingEntityRenderState, ModelEnderSpider> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MODID, "textures/entity/ender_spider.png");

    public RenderEnderSpider(EntityRendererProvider.Context context) {
        super(context, new ModelEnderSpider(context), 0.5F);
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

    @Override
    public void extractRenderState(EntityEnderSpider entity, LivingEntityRenderState state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
    }

    @Override
    protected void scale(LivingEntityRenderState state, PoseStack stack) {
        stack.scale(0.6F, 0.6F, 0.6F);
    }

    @Override
    public Identifier getTextureLocation(LivingEntityRenderState state) {
        return TEXTURE;
    }
}