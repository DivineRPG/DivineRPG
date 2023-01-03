package divinerpg.util;

import net.minecraft.world.damagesource.*;

public class DamageSources {
    public static final DamageSource trapSource = (new DamageSource("trapSource")).bypassArmor().setIsFire();
    public static final DamageSource spikeSource = new DamageSource("spike").bypassArmor();
    public static final DamageSource acidSource = new DamageSource("acid").bypassArmor();
    public static final DamageSource arcanaSource = new DamageSource("arcana").bypassArmor().bypassMagic();
}
