package divinerpg.client.renders.entity.twilight;

import divinerpg.DivineRPG;
import divinerpg.client.models.twilight.ModelMoonWolf;
import divinerpg.client.renders.layer.MoonWolfCollarLayer;
import divinerpg.entities.wildwood.EntityMoonWolf;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderMoonWolf extends MobRenderer<EntityMoonWolf, ModelMoonWolf<EntityMoonWolf>> {
    private static final ResourceLocation WOLF_LOCATION = new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_default.png");
    private static final ResourceLocation WOLF_TAME_LOCATION = new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_default.png");
    private static final ResourceLocation WOLF_ANGRY_LOCATION = new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_agro.png");

    public RenderMoonWolf(EntityRendererProvider.Context context) {
        super(context, new ModelMoonWolf<>(context), 0.5F);
        this.addLayer(new MoonWolfCollarLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EntityMoonWolf entity) {
        if (entity.isTame()) {
            return WOLF_TAME_LOCATION;
        } else {
            return entity.isAngry() ? WOLF_ANGRY_LOCATION : WOLF_LOCATION;
        }
    }
}