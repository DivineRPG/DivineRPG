package divinerpg.client.renders.entity.twilight;

import divinerpg.DivineRPG;
import divinerpg.client.models.twilight.ModelSunArcher;
import divinerpg.client.renders.layer.SunArcherBowLayer;
import divinerpg.entities.eden.EntitySunArcher;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderSunArcher extends MobRenderer<EntitySunArcher, ModelSunArcher<EntitySunArcher>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/sun_archer.png");

    public RenderSunArcher(EntityRendererProvider.Context context) {
        super(context, new ModelSunArcher<>(context), 0.8F);
        this.addLayer(new SunArcherBowLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EntitySunArcher entity) {
        return TEXTURE;
    }

}