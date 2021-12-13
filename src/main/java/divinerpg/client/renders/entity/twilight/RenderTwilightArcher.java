package divinerpg.client.renders.entity.twilight;

import divinerpg.*;
import divinerpg.client.models.twilight.*;
import divinerpg.client.renders.layer.*;
import divinerpg.entities.mortum.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderTwilightArcher extends MobRenderer<EntityTwilightArcher, ModelTwilightArcher<EntityTwilightArcher>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/twilight_archer.png");

    public RenderTwilightArcher(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelTwilightArcher<>(), 0.8F);
        this.addLayer(new TwilightArcherLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EntityTwilightArcher entity) {
        return TEXTURE;
    }

}