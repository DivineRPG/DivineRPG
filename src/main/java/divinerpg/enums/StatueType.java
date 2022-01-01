package divinerpg.enums;

import divinerpg.*;
import divinerpg.client.models.boss.*;
import divinerpg.client.models.vanilla.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.util.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.loading.FMLEnvironment;

public enum StatueType {
    NONE(null, null),
	ANCIENT_ENTITY_STATUE(FMLEnvironment.dist == Dist.CLIENT ? new ModelAncientEntity() : null, new ResourceLocation(DivineRPG.MODID, "textures/entity/ancient_entity.png")),
    BLUE_AYERACO_STATUE(FMLEnvironment.dist == Dist.CLIENT ? new ModelAyeraco() : null, new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_blue.png")),
    DENSOS_STATUE(FMLEnvironment.dist == Dist.CLIENT ? new ModelDensos() : null, new ResourceLocation(DivineRPG.MODID, "textures/entity/densos.png")),
    DRAMIX_STATUE(FMLEnvironment.dist == Dist.CLIENT ? new ModelDramix() : null, new ResourceLocation(DivineRPG.MODID, "textures/entity/dramix.png")),
    ETERNAL_ARCHER_STATUE(FMLEnvironment.dist == Dist.CLIENT ? new ModelEternalArcher() : null, new ResourceLocation(DivineRPG.MODID, "textures/entity/eternal_archer.png")),
    KAROT_STATUE(FMLEnvironment.dist == Dist.CLIENT ? new ModelKarot() : null, new ResourceLocation(DivineRPG.MODID, "textures/entity/karot.png")),
    KING_OF_SCORCHERS_STATUE(FMLEnvironment.dist == Dist.CLIENT ? new ModelKingScorcher() : null, new ResourceLocation(DivineRPG.MODID, "textures/entity/king_of_scorchers.png")),
    PARASECTA_STATUE(FMLEnvironment.dist == Dist.CLIENT ? new ModelParasecta() : null, new ResourceLocation(DivineRPG.MODID, "textures/entity/parasecta.png")),
    REYVOR_STATUE(FMLEnvironment.dist == Dist.CLIENT ? new ModelDensos() : null, new ResourceLocation(DivineRPG.MODID, "textures/entity/reyvor.png")),
    SOUL_FIEND_STATUE(FMLEnvironment.dist == Dist.CLIENT ? new ModelSoulFiend() : null, new ResourceLocation(DivineRPG.MODID, "textures/entity/soul_fiend.png")),
    THE_WATCHER_STATUE(FMLEnvironment.dist == Dist.CLIENT ? new ModelTheWatcher() : null, new ResourceLocation(DivineRPG.MODID, "textures/entity/the_watcher.png")),
    TWILIGHT_DEMON_STATUE(FMLEnvironment.dist == Dist.CLIENT ? new ModelTwilightDemon() : null, new ResourceLocation(DivineRPG.MODID, "textures/entity/twilight_demon.png")),
    VAMACHERON_STATUE(FMLEnvironment.dist == Dist.CLIENT ? new ModelVamacheron() : null, new ResourceLocation(DivineRPG.MODID, "textures/entity/vamacheron.png")),

    RED_AYERACO_STATUE(FMLEnvironment.dist == Dist.CLIENT ? new ModelAyeraco() : null, new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_red.png")),
    GREEN_AYERACO_STATUE(FMLEnvironment.dist == Dist.CLIENT ? new ModelAyeraco() : null, new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_green.png")),
    PURPLE_AYERACO_STATUE(FMLEnvironment.dist == Dist.CLIENT ? new ModelAyeraco() : null, new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_purple.png")),
    YELLOW_AYERACO_STATUE(FMLEnvironment.dist == Dist.CLIENT ? new ModelAyeraco() : null, new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_yellow.png")),

    TERMASECT_STATUE(FMLEnvironment.dist == Dist.CLIENT ? new ModelTermasect() : null, new ResourceLocation(DivineRPG.MODID, "textures/entity/termasect.png")),
    SUNSTORM_STATUE(FMLEnvironment.dist == Dist.CLIENT ? new ModelSunstorm() : null, new ResourceLocation(DivineRPG.MODID, "textures/entity/sunstorm.png")),
    EXPERIENCED_CORI_STATUE(FMLEnvironment.dist == Dist.CLIENT ? new ModelExperiencedCori() : null, new ResourceLocation(DivineRPG.MODID, "textures/entity/experienced_cori.png"));
	
    private final Object model;
    private final ResourceLocation texture;

    StatueType(Object model, ResourceLocation texture) {
        this.model = FMLEnvironment.dist == Dist.CLIENT ? (EntityModel) model : null;
        this.texture = texture;
    }

    private static ResourceLocation StatueLoc(String name) {
        return new ResourceLocation(DivineRPG.MODID, "textures/model/" + name + ".png");
    }

    public ResourceLocation getTexture() {
        return this.texture;
    }

    public static StatueType getStatueFromId(int ordinal) {
        if (ordinal < 0 || ordinal > values().length) {
            ordinal = 0;
        }
        return values()[ordinal];
    }

    @OnlyIn(Dist.CLIENT)
    public EntityModel getModel() {
        return (EntityModel) this.model;
    }
}