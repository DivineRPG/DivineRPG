package divinerpg.items.base;

import divinerpg.DivineRPG;
import divinerpg.entities.projectile.*;
import divinerpg.enums.BulletType;
import divinerpg.items.vanilla.ItemScythe;
import divinerpg.items.vethea.ItemVetheanDisk;
import divinerpg.registries.EntityRegistry;
import divinerpg.util.*;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.*;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.registries.ForgeRegistries;
import javax.annotation.Nullable;
import java.util.List;

public class ItemModRanged extends ItemMod {
    private final Item ammoSupplier;
    private final SoundSource soundCategory;
    protected BulletType bulletType;
    protected final String entityType;
    public SoundEvent sound;
    public int onUseDamage;
    public int projectileAmount;
    /**
     * Constructor for DivineRPG ranged weapons.
     *
     * @param entityType - entity type
     * @param bulletType - type of bullets. Has lower priority than entityType param
     * @param sound - what sound will be on bullet spawn
     * @param uses - max usage of item
     * @param delay - weapon's cooldown
     * @param ammo - ammo for weapon. If it returns null, no ammo required
     * @param arcanaConsuming - arcana consuming per shot. Pass 0 to not consume at all
     */
    public ItemModRanged(Rarity rarity, String entityType, BulletType bulletType, SoundEvent sound, int uses, int delay, Item ammo, int arcanaConsuming) {
        super(new Properties().durability(uses).rarity(rarity));
        ammoSupplier = ammo;
        arcanaConsumedUse = arcanaConsuming;
        this.bulletType = bulletType;
        cooldown = delay;
        this.entityType = entityType;
        this.sound = sound;
        soundCategory = SoundSource.PLAYERS;
    }
    public ItemModRanged(String entityType, BulletType bulletType, SoundEvent sound, int uses, int delay, Item ammo, int arcanaConsuming) {
        super(new Properties().durability(uses));
        ammoSupplier = ammo;
        arcanaConsumedUse = arcanaConsuming;
        this.bulletType = bulletType;
        cooldown = delay;
        this.entityType = entityType;
        this.sound = sound;
        soundCategory = SoundSource.PLAYERS;
    }
    //Throwables (no durability)
    public ItemModRanged(Rarity rarity, BulletType bulletType, int delay) {
        super(new Properties().rarity(rarity));
        ammoSupplier = null;
        arcanaConsumedUse = 0;
        this.bulletType = bulletType;
        cooldown = delay;
        entityType = null;
        sound = SoundEvents.ARROW_SHOOT;
        soundCategory = SoundSource.PLAYERS;
    }
    //No rarity, specified arcana usage
    public ItemModRanged(BulletType bulletType, SoundEvent sound, Item ammoSupplier, int uses, int delay, int arcanaConsuming) {this(null, bulletType, sound, uses, delay, ammoSupplier, arcanaConsuming);}
    //No rarity, specified ammo
    public ItemModRanged(BulletType bulletType, SoundEvent sound, Item ammoSupplier, int uses, int delay) {this(null, bulletType, sound, uses, delay, ammoSupplier, 0);}
    //No rarity, no ammo
    public ItemModRanged(BulletType bulletType, SoundEvent sound, int uses, int delay) {this(bulletType, sound, null, uses, delay);}
    @Override public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if(canUseRangedWeapon(player, stack)) {
            InteractionResultHolder<ItemStack> ammo = tryFindAmmo(player);
            if(ammo.getResult() == InteractionResult.SUCCESS) {
                doPreUsageEffects(world, player);
                if(!world.isClientSide) spawnEntity(world, player, stack, bulletType, entityType);
                ItemStack ammoStack = ammo.getObject();
                if(ammoStack != null) ammoStack.shrink(1);
                if(!player.isCreative()) stack.hurtAndBreak(1, player, (ctx) -> ctx.broadcastBreakEvent(player.getUsedItemHand()));
                if(arcanaConsumedUse == 0) {
                    player.getCooldowns().addCooldown(this, cooldown);
                    player.awardStat(Stats.ITEM_USED.get(this));
                }
                doPostUsageEffects(world, player);
                if(this instanceof ItemModThrowable || this instanceof ItemVetheanDisk) {
                    world.playSound(null, player.blockPosition(), sound != null ? sound : SoundEvents.ARROW_SHOOT, soundCategory != null ? soundCategory : SoundSource.PLAYERS, .5F, .4F / (player.getRandom().nextFloat() * .4F + .8F));
                    return InteractionResultHolder.success(stack);
                } world.playSound(null, player.blockPosition(), sound != null ? sound : SoundEvents.ARROW_SHOOT, soundCategory != null ? soundCategory : SoundSource.PLAYERS, 1, 1);
                return super.use(world, player, hand);
            }
        } return InteractionResultHolder.pass(stack);
    }
    private boolean needsAmmo() {return ammoSupplier != null;}
    private boolean isAmmo(@Nullable ItemStack stack) {return stack != null && stack.getItem() == ammoSupplier;}
    private ItemStack findAmmo(Player player) {
        if(this.isAmmo(player.getItemInHand(InteractionHand.OFF_HAND))) return player.getItemInHand(InteractionHand.OFF_HAND);
        else if(this.isAmmo(player.getItemInHand(InteractionHand.MAIN_HAND))) return player.getItemInHand(InteractionHand.MAIN_HAND);
        else {
            for(int i = 0; i < player.inventory.getContainerSize(); ++i) {
                ItemStack itemstack = player.inventory.getItem(i);
                if(this.isAmmo(itemstack)) return itemstack;
            } return null;
        }
    }
    /*
     Trying to find ammo stack.
     If SUCCESS, can continue.
     If ItemStack is not null, we need to shrink it.
     */
    protected InteractionResultHolder<ItemStack> tryFindAmmo(Player player) {
        ItemStack stack = null;
        InteractionResult result = InteractionResult.SUCCESS;
        if(!player.isCreative() && needsAmmo()) {
            stack = findAmmo(player);
            if(stack == null || stack.getCount() < 1) result = InteractionResult.FAIL;
        } return new InteractionResultHolder<>(result, stack);
    }
    //Trying to detect if we can use the item.
    protected boolean canUseRangedWeapon(Player player, ItemStack stack) {return (player.isCreative() || stack.getMaxDamage() <= 0 || stack.getDamageValue() < stack.getMaxDamage());}
    protected void spawnEntity(Level world, Player player, ItemStack stack, BulletType bulletType, String entityType) {
        ThrowableProjectile bullet;
        //Class has the most priority
        if(entityType != null) {
            try{bullet = (ThrowableProjectile)ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(DivineRPG.MODID, entityType)).create(world);}
            catch(Exception e) {
                e.printStackTrace();
                //Weapon will not work, so it would be better to crush
                throw new RuntimeException(e.getMessage());
            }
        }
        //In other cases we look to a BulletType field
        else if(bulletType.getParticle() != ParticleTypes.BUBBLE) bullet = new EntityParticleBullet(EntityRegistry.PARTICLE_BULLET.get(), world, player, bulletType);
        else if(bulletType.getRed() != 0 && bulletType.getGreen() != 0 && bulletType.getBlue() != 0) bullet = new EntityColoredBullet(EntityRegistry.COLORED_BULLET.get(), player, world, bulletType);
        else bullet = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), player, world, bulletType);
        bullet.shootFromRotation(player, player.xRot, player.yRot, 0, 1.5F, .5F);
        world.addFreshEntity(bullet);
    }
    protected void doPreUsageEffects(Level world, Player player) {if(onUseDamage > 0) player.hurt(DamageSources.source(world, DamageSources.ARCANA), onUseDamage);}
    protected void doPostUsageEffects(Level world, Player player) {}
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if(bulletType != null) {
            if(!(this instanceof ItemModShotgun)) {
                if(bulletType.getBulletDamageType() == BulletType.BulletDamageType.ARCANA) tooltip.add(LocalizeUtils.arcanaDam((int)bulletType.getDamage()));
                if(!(this instanceof ItemScythe) && bulletType.getBulletDamageType() == BulletType.BulletDamageType.MAGIC) tooltip.add(LocalizeUtils.magicDam((int)bulletType.getDamage()));
                if(bulletType.getBulletDamageType() == BulletType.BulletDamageType.PHYSIC) tooltip.add(LocalizeUtils.rangedDam((int)bulletType.getDamage()));
            } if(bulletType.getBulletSpecial() == BulletType.BulletSpecial.BOUNCE) tooltip.add(LocalizeUtils.bouncingShots());
            if(bulletType.getBulletSpecial() == BulletType.BulletSpecial.POISON) tooltip.add(LocalizeUtils.poison(bulletType.effectSec));
            if(bulletType.getBulletSpecial() == BulletType.BulletSpecial.PULL) tooltip.add(LocalizeUtils.pull());
            if(bulletType.getBulletSpecial() == BulletType.BulletSpecial.PUSH) tooltip.add(LocalizeUtils.push());
            if(bulletType.getBulletSpecial() == BulletType.BulletSpecial.RETURN) tooltip.add(LocalizeUtils.returnsToSender());
            if(bulletType.getBulletSpecial() == BulletType.BulletSpecial.SKY) tooltip.add(LocalizeUtils.skyShots(projectileAmount));
            if(bulletType == BulletType.METEOR || bulletType.getBulletSpecial() == BulletType.BulletSpecial.EXPLODE) tooltip.add(LocalizeUtils.explosiveShots());
            if(bulletType.getBulletSpecial() == BulletType.BulletSpecial.SLOW) tooltip.add(LocalizeUtils.slow(bulletType.effectSec));
            if(bulletType.getBulletSpecial() == BulletType.BulletSpecial.SPLIT) tooltip.add(LocalizeUtils.splitShots());
        } if(onUseDamage > 0) tooltip.add(LocalizeUtils.onUseDam(onUseDamage));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        if(!(this instanceof ItemModThrowable)) {
            tooltip.add(needsAmmo() ? LocalizeUtils.ammo(ammoSupplier) : LocalizeUtils.infiniteAmmo());
            if(!canBeDepleted()) stack.getOrCreateTag().putBoolean("Unbreakable", true);
        }
    }
}