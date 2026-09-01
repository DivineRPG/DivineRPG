package divinerpg.items.ranged;

import divinerpg.entities.projectile.DivineThrownItem;
import divinerpg.registries.EntityRegistry;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class ItemThrowable extends ItemRangedWeapon implements ProjectileItem {
    public final float damage;

    public ItemThrowable(Properties properties, float damage) {
        this(properties, () -> EntityRegistry.THROWN_ITEM.value(), damage);
    }

    public ItemThrowable(Properties properties, Supplier<EntityType<? extends Projectile>> projectileType, float damage) {
        super(properties, projectileType);
        this.damage = damage;
        power = 2;
        infinite = false;
    }
    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.PLAYERS, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));

        if (level instanceof ServerLevel serverLevel) {
            Projectile.spawnProjectileFromRotation(DivineThrownItem::new, serverLevel, itemStack, player, 0.0F, 1.5F, 1.0F);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        itemStack.consume(1, player);
        return InteractionResult.SUCCESS;
    }

    @Override
    public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {
        return new DivineThrownItem(EntityTypes.EGG, level, position.x(), position.y(), position.z(), itemStack);
    }
}