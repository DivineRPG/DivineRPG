package divinerpg.entities.eden;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;

public class EntityGreenfeet extends EntityDivineMonster {
    public EntityGreenfeet(EntityType<? extends EntityGreenfeet> type, Level worldIn) {super(type, worldIn);}
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader reader) {return 0;}
    @Override public void aiStep() {
        if(this.isAlive()) {
            boolean flag = isSunBurnTick();
            if(flag) {
                ItemStack itemstack = getItemBySlot(EquipmentSlot.HEAD);
                if(!itemstack.isEmpty()) {
                    if(itemstack.isDamageableItem()) {
                        Item item = itemstack.getItem();
                        itemstack.setDamageValue(itemstack.getDamageValue() + random.nextInt(2));
                        if(itemstack.getDamageValue() >= itemstack.getMaxDamage()) {
                            onEquippedItemBroken(item, EquipmentSlot.HEAD);
                            setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
                        }
                    } flag = false;
                } if(flag) igniteForSeconds(8);
            }
        } super.aiStep();
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.NESRO.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.NESRO_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.NESRO_HURT.get();
    }

}