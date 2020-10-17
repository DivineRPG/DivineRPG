package divinerpg.util;

import net.minecraft.util.DamageSource;

public class DamageSources {
    public static final DamageSource trapSource = (new DamageSource("trapSource")).setDamageBypassesArmor().setFireDamage();
    public static final DamageSource spikeSource = new DamageSource("spike").setDamageBypassesArmor();
}
