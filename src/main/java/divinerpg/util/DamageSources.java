package divinerpg.util;

import net.minecraft.util.DamageSource;

public class DamageSources {
    public static final DamageSource trapSource = (new DamageSource("trapSource")).bypassArmor().setIsFire();
    public static final DamageSource spikeSource = new DamageSource("spike").bypassArmor();
}
