package divinerpg.items.ranged.staffs;

import divinerpg.registries.*;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class Evernight extends VetheanStaff {
    public final int onUseDam = 19;
    public Evernight(Properties properties) {
        super(properties, EntityRegistry.EVERNIGHT_SHOT::value, 80, 38.3F);
        tooltips.add(LocalizeUtils.onUseDam(onUseDam));
    }
    @Override public InteractionResult use(Level level, Player player, InteractionHand hand) {
        InteractionResult result = super.use(level, player, hand);
        if(result.consumesAction() && !player.isCreative()) player.hurt(level.damageSources().source(DamageRegistry.ARCANA), onUseDam);
        return result;
    }
}