package divinerpg.client.renders.entity.twilight;

import divinerpg.*;
import divinerpg.client.models.twilight.*;
import divinerpg.client.renders.layer.*;
import divinerpg.entities.skythern.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderSkythernArcher extends MobRenderer<EntitySkythernArcher, ModelTwilightArcher<EntitySkythernArcher>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/skythern_archer.png");

    public RenderSkythernArcher(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelTwilightArcher<>(), 0.8F);
        this.addLayer(new SkythernArcherLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EntitySkythernArcher entity) {
        return TEXTURE;
    }

}