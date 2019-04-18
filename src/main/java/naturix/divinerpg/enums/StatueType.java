package naturix.divinerpg.enums;

import naturix.divinerpg.objects.blocks.tile.model.ModelAncientEntityStatue;
import naturix.divinerpg.objects.blocks.tile.model.ModelAyeracoStatue;
import naturix.divinerpg.objects.blocks.tile.model.ModelDensosStatue;
import naturix.divinerpg.objects.blocks.tile.model.ModelDexStatue;
import naturix.divinerpg.objects.blocks.tile.model.ModelDramixStatue;
import naturix.divinerpg.objects.blocks.tile.model.ModelEternalArcherStatue;
import naturix.divinerpg.objects.blocks.tile.model.ModelKarotStatue;
import naturix.divinerpg.objects.blocks.tile.model.ModelKingOfScorchersStatue;
import naturix.divinerpg.objects.blocks.tile.model.ModelReyvorStatue;
import naturix.divinerpg.objects.blocks.tile.model.ModelSoulFiendStatue;
import naturix.divinerpg.objects.blocks.tile.model.ModelTheWatcherStatue;
import naturix.divinerpg.objects.blocks.tile.model.ModelTwilightDemonStatue;
import naturix.divinerpg.objects.blocks.tile.model.ModelVamacheronStatue;
import naturix.divinerpg.utils.models.DivineModel;
import net.minecraft.util.ResourceLocation;

public enum StatueType {
    NONE(null, null),
    ANCIENT_ENTITY_STATUE(new ModelAncientEntityStatue(), StatueLoc("ancient_entity_statue")),
    AYERACO_STATUE(new ModelAyeracoStatue(), StatueLoc("ayeraco_statue")),
    DENSOS_STATUE(new ModelDensosStatue(), StatueLoc("densos_statue")),
    DEX_STATUE(new ModelDexStatue(), StatueLoc("dex_statue")),
    DRAMIX_STATUE(new ModelDramixStatue(), StatueLoc("dramix_statue")),
    ETERNAL_ARCHER_STATUE(new ModelEternalArcherStatue(), StatueLoc("eternal_archer_statue")),
    KAROT_STATUE(new ModelKarotStatue(), StatueLoc("karot_statue")),
    KING_OF_SCORCHERS_STATUE(new ModelKingOfScorchersStatue(), StatueLoc("king_of_scorchers_statue")),
    PARASECTA_STATUE(new ModelKarotStatue(), StatueLoc("parasecta_statue")),
    REYVOR_STATUE(new ModelReyvorStatue(), StatueLoc("reyvor_statue")),
    SOUL_FIEND_STATUE(new ModelSoulFiendStatue(), StatueLoc("soul_fiend_statue")),
    THE_WATCHER_STATUE(new ModelTheWatcherStatue(), StatueLoc("the_watcher_statue")),
    TWILIGHT_DEMON_STATUE(new ModelTwilightDemonStatue(), StatueLoc("twilight_demon_statue")),
    VAMACHERON_STATUE(new ModelVamacheronStatue(), StatueLoc("vamacheron_statue"));

    private final DivineModel model;
    private final ResourceLocation texture;

    StatueType(DivineModel model, ResourceLocation texture) {
        this.model = model;
        this.texture = texture;
    }

    public DivineModel getModel() {
        return this.model;
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

    private static ResourceLocation StatueLoc(String name) {
        return new ResourceLocation("divinerpg:textures/model/" + name + ".png");
    }
}