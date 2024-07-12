package divinerpg.client.renders.entity.twilight;

import divinerpg.*;
import divinerpg.client.models.twilight.*;
import divinerpg.client.renders.layer.*;
import divinerpg.entities.skythern.*;
import net.minecraft.client.renderer.entity.*;
import net.neoforged.api.distmarker.*;

import net.minecraft.resources.ResourceLocation;

@OnlyIn(Dist.CLIENT)
public class RenderSkythernArcher extends MobRenderer<EntitySkythernArcher, ModelTwilightArcher<EntitySkythernArcher>> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/skythern_archer.png");

    public RenderSkythernArcher(EntityRendererProvider.Context context) {
        super(context, new ModelTwilightArcher<>(context), 0.8F);
        this.addLayer(new SkythernArcherLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EntitySkythernArcher entity) {
        return TEXTURE;
    }

}