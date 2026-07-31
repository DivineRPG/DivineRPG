package divinerpg.client.renders.entity.boss;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.boss.ModelEternalArcher;
import divinerpg.client.renders.base.RenderDivineMob;
import divinerpg.entities.boss.EntityEternalArcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class RenderEternalArcher<T extends EntityEternalArcher, S extends LivingEntityRenderState, M extends ModelEternalArcher<S>> extends RenderDivineMob<T, S, M> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/eternal_archer.png");

    @SuppressWarnings("unchecked")
    public RenderEternalArcher(Context context) {
        super(context, "eternal_archer", (M) new ModelEternalArcher<>(context), 0.8F);
        //TODO - Layer
//        this.addLayer(new EternalArcherLayer(this));
    }

    @Override
    public S createRenderState() {
        return (S) new LivingEntityRenderState();
    }
    @Override
    public Identifier getTextureLocation(S state) {
        return TEXTURE;
    }

    @Override
    protected void scale(S state, PoseStack stack) {
        stack.scale(2.5F, 2.5F, 2.5F);
    }
}