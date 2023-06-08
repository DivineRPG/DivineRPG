package divinerpg.entities.vethea;

import divinerpg.DivineRPG;
import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityLheiva extends EntityDivineMonster {

    public EntityLheiva(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.0F;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    public boolean hurt(DamageSource source, float par2) {
        Entity var1 = source.getDirectEntity();
        if (var1 != null && var1 instanceof Player) {
            if (((Player)var1).inventory.contains(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "band_of_heiva_hunting")))))
                return super.hurt(source, par2);
        } else if(source.is(DamageTypes.FELL_OUT_OF_WORLD)) return super.hurt(source, par2);
        return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.LHEIVA.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.LHEIVA_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.LHEIVA_HURT.get();
    }
}