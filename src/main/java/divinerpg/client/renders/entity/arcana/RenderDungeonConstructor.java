package divinerpg.client.renders.entity.arcana;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.client.models.arcana.ModelDungeonConstructor;
import divinerpg.entities.arcana.EntityDungeonConstructor;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;

import static divinerpg.DivineRPG.MODID;

public class RenderDungeonConstructor
        extends MobRenderer<EntityDungeonConstructor, ArmedEntityRenderState, ModelDungeonConstructor> {

    private static final Identifier TEXTURE =
            Identifier.fromNamespaceAndPath(MODID, "textures/entity/dungeon_constructor.png");

    public RenderDungeonConstructor(EntityRendererProvider.Context context) {
        super(context, new ModelDungeonConstructor(context), 0.5F);
    }

    @Override
    public ArmedEntityRenderState createRenderState() {
        return new ArmedEntityRenderState();
    }

    @Override
    protected void scale(ArmedEntityRenderState state, PoseStack poseStack) {
        super.scale(state, poseStack);
        state.scale = 0.4f;
    }

    @Override
    public void extractRenderState(
            EntityDungeonConstructor entity,
            ArmedEntityRenderState state,
            float partialTicks) {

        super.extractRenderState(entity, state, partialTicks);

        state.attackTime = entity.getAttackAnim(partialTicks);
        state.walkAnimationPos = entity.walkAnimation.position(partialTicks);
        state.walkAnimationSpeed = entity.walkAnimation.speed(partialTicks);
        state.ageInTicks = entity.tickCount + partialTicks;
    }

    @Override
    public Identifier getTextureLocation(ArmedEntityRenderState state) {
        return TEXTURE;
    }
}