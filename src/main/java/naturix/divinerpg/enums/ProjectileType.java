package naturix.divinerpg.enums;

import naturix.divinerpg.utils.Reference;
import net.minecraft.util.ResourceLocation;

public enum ProjectileType {
    FROST_CANNON_SHOT(6, new ResourceLocation(Reference.MODID, "projectiles/frost_cannon")),
    CYCLOPSIAN_STAFF_SHOT(6, new ResourceLocation(Reference.MODID, "cyclops_eye_shards")),
    MAELSTROM_SHOT(12, new ResourceLocation(Reference.MODID, "projectiles/maelstrom")),
    CRAB_ANCHOR_SHOT(3, new ResourceLocation(Reference.MODID, "projectiles/crab_anchor")),
    SHARK_ANCHOR_SHOT(4, new ResourceLocation(Reference.MODID, "projectiles/bowhead_anchor")),
    BOWHEAD_ANCHOR_SHOT(5, new ResourceLocation(Reference.MODID, "projectiles/bowhead_anchor")),
    LIOPLEURODON_ANCHOR_SHOT(6, new ResourceLocation(Reference.MODID, "projectiles/lioleurodon_anchor")),
    GOLDEN_FURY_SHOT(30, new ResourceLocation(Reference.MODID, "gold_nugget")),
    GHAST_CANNON_SHOT(16, new ResourceLocation(Reference.MODID, "projectiles/ghast_cannon")),
    CRABCLAW_CANNON_SHOT(12, new ResourceLocation(Reference.MODID, "projectiles/crab_anchor")),
    BOWHEAD_CANNON_SHOT(12, new ResourceLocation(Reference.MODID, "projectiles/bowhead_anchor")),
    FROSTCLAW_CANNON_SHOT(16, new ResourceLocation(Reference.MODID, "projectiles/frostclaw_cannon")),
    FRACTITE_CANNON_SHOT(14, new ResourceLocation(Reference.MODID, "projectiles/fractite_cannon"));

    private final float damage;
    private final ResourceLocation texture;

    ProjectileType(float damage, ResourceLocation texture) {
        this.damage = damage;
        this.texture = texture;
    }

    public float getDamage() {
        return damage;
    }

    public ResourceLocation getTexture() {
        return texture;
    }
}