package divinerpg.enums;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.arcana.*;
import divinerpg.objects.entities.assets.model.twilight.*;
import divinerpg.objects.entities.assets.model.vanilla.*;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;

public enum StatueType {
    NONE(null, null),
    ANCIENT_ENTITY_STATUE(new ModelAncientEntity(), new ResourceLocation(DivineRPG.MODID, "textures/entity/ancient_entity.png")),
    BLUE_AYERACO_STATUE(new ModelAyeraco(), new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_blue.png")),
    DENSOS_STATUE(new ModelDensos(), new ResourceLocation(DivineRPG.MODID, "textures/entity/densos.png")),
    DRAMIX_STATUE(new ModelDramix(), new ResourceLocation(DivineRPG.MODID, "textures/entity/dramix.png")),
    ETERNAL_ARCHER_STATUE(new ModelEternalArcher(), new ResourceLocation(DivineRPG.MODID, "textures/entity/eternal_archer.png")),
    KAROT_STATUE(new ModelKarot(), new ResourceLocation(DivineRPG.MODID, "textures/entity/karot.png")),
    KING_OF_SCORCHERS_STATUE(new ModelKingScorcher(), new ResourceLocation(DivineRPG.MODID, "textures/entity/king_of_scorchers.png")),
    PARASECTA_STATUE(new ModelParasecta(), new ResourceLocation(DivineRPG.MODID, "textures/entity/parasecta.png")),
    REYVOR_STATUE(new ModelDensos(), new ResourceLocation(DivineRPG.MODID, "textures/entity/reyvor.png")),
    SOUL_FIEND_STATUE(new ModelSoulFiend(), new ResourceLocation(DivineRPG.MODID, "textures/entity/soul_fiend.png")),
    THE_WATCHER_STATUE(new ModelTheWatcher(), new ResourceLocation(DivineRPG.MODID, "textures/entity/the_watcher.png")),
    TWILIGHT_DEMON_STATUE(new ModelTwilightDemon(), new ResourceLocation(DivineRPG.MODID, "textures/entity/twilight_demon.png")),
    VAMACHERON_STATUE(new ModelVamacheron(), new ResourceLocation(DivineRPG.MODID, "textures/entity/vamacheron.png")),

    RED_AYERACO_STATUE(new ModelAyeraco(), new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_red.png")),
    GREEN_AYERACO_STATUE(new ModelAyeraco(), new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_green.png")),
    PURPLE_AYERACO_STATUE(new ModelAyeraco(), new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_purple.png")),
    YELLOW_AYERACO_STATUE(new ModelAyeraco(), new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_yellow.png")),

    TERMASECT_STATUE(new ModelTermasect(), new ResourceLocation(DivineRPG.MODID, "textures/entity/termasect.png")),
    SUNSTORM_STATUE(new ModelSunstorm(), new ResourceLocation(DivineRPG.MODID, "textures/entity/sunstorm.png")),
    EXPERIENCED_CORI_STATUE(new ModelExperiencedCori(), new ResourceLocation(DivineRPG.MODID, "textures/entity/experienced_cori.png"));

    private final ModelBase model;
    private final ResourceLocation texture;

    StatueType(ModelBase model, ResourceLocation texture) {
        this.model = model;
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

    public ModelBase getModel() {
        return this.model;
    }
}