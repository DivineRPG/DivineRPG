package divinerpg.client.renders.entity.twilight;

import divinerpg.DivineRPG;
import divinerpg.client.models.twilight.ModelTwilightArcher;
import divinerpg.client.renders.layer.SkythernArcherLayer;
import divinerpg.entities.skythern.EntitySkythernArcher;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderSkythernArcher extends MobRenderer<EntitySkythernArcher, ModelTwilightArcher<EntitySkythernArcher>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/skythern_archer.png");

    public RenderSkythernArcher(EntityRendererProvider.Context context) {
        super(context, new ModelTwilightArcher<>(context), 0.8F);
        this.addLayer(new SkythernArcherLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EntitySkythernArcher entity) {
        return TEXTURE;
    }

}