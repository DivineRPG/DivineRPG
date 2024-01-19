package divinerpg.client.renders.entity.twilight;

import divinerpg.DivineRPG;
import divinerpg.client.models.twilight.ModelTwilightArcher;
import divinerpg.client.renders.layer.TwilightArcherLayer;
import divinerpg.entities.mortum.EntityTwilightArcher;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderTwilightArcher extends MobRenderer<EntityTwilightArcher, ModelTwilightArcher<EntityTwilightArcher>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/twilight_archer.png");

    public RenderTwilightArcher(final EntityRendererProvider.Context context) {
        super(context, new ModelTwilightArcher<>(context), 1F);
        this.addLayer(new TwilightArcherLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EntityTwilightArcher entity) {
        return TEXTURE;
    }

}