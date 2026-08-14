package divinerpg.client.renders.entity.boss;

import divinerpg.client.models.boss.ModelSunstorm;
import divinerpg.client.models.state.SunstormRenderState;
import divinerpg.entities.boss.EntitySunstorm;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

import static divinerpg.DivineRPG.MODID;

public class RenderSunstorm extends MobRenderer<EntitySunstorm, SunstormRenderState, ModelSunstorm<SunstormRenderState>> {

    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MODID, "textures/entity/sunstorm.png");

    public RenderSunstorm(EntityRendererProvider.Context context) {
        super(context, new ModelSunstorm<>(context), 0.5F);
    }

    @Override
    public SunstormRenderState createRenderState() {
        return new SunstormRenderState();
    }

    @Override
    public void extractRenderState(EntitySunstorm entity, SunstormRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        float healthPercent = entity.getHealth() / entity.getMaxHealth();
        state.hasRightSoul = healthPercent > 0.75F;
        state.hasLeftSoul = healthPercent > 0.50F;
        state.hasMiddleSoul = healthPercent > 0.25F;
    }

    @Override
    public Identifier getTextureLocation(SunstormRenderState state) {
        return TEXTURE;
    }
}