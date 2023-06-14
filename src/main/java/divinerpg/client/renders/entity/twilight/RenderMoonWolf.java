package divinerpg.client.renders.entity.twilight;

import divinerpg.DivineRPG;
import divinerpg.client.models.twilight.*;
import divinerpg.entities.wildwood.EntityMoonWolf;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderMoonWolf extends MobRenderer<EntityMoonWolf, ModelMoonWolf> {

    public RenderMoonWolf(EntityRendererProvider.Context context) {
        super(context, new ModelMoonWolf(context), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityMoonWolf entity) {
        if (!entity.isTame()) {
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_default.png");
        } else if (!entity.isTame() && entity.isAngry()) {
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_agro.png");
        } else {
            switch (entity.getCollarColor().getId()) {
                case 0:
                    return new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_white.png");
                case 1:
                    return new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_orange.png");
                case 2:
                    return new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_magenta.png");
                case 3:
                    return new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_light_blue.png");
                case 4:
                    return new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_yellow.png");
                case 5:
                    return new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_lime.png");
                case 6:
                    return new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_pink.png");
                case 7:
                    return new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_grey.png");
                case 8:
                    return new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_light_grey.png");
                case 9:
                    return new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_cyan.png");
                case 10:
                    return new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_purple.png");
                case 11:
                    return new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_blue.png");
                case 12:
                    return new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_brown.png");
                case 13:
                    return new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_green.png");
                case 14:
                    return new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_red.png");
                case 15:
                    return new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_black.png");
                default:
                    return new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_default.png");
            }
        }
    }
}
