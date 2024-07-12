package divinerpg.client.renders.entity.twilight;

import divinerpg.*;
import divinerpg.client.models.twilight.*;
import divinerpg.client.renders.layer.*;
import divinerpg.entities.mortum.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.*;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderTwilightArcher extends MobRenderer<EntityTwilightArcher, ModelTwilightArcher<EntityTwilightArcher>> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/twilight_archer.png");

    public RenderTwilightArcher(final EntityRendererProvider.Context context) {
        super(context, new ModelTwilightArcher<>(context), 1F);
        this.addLayer(new TwilightArcherLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EntityTwilightArcher entity) {
        return TEXTURE;
    }

}