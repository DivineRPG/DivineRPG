package divinerpg.blocks.twilight;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.Fire;
import divinerpg.utils.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class DivineFlame extends Fire {
    public static final Identifier ADVANCEMENT = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "divine/ritual_or_not");
    public DivineFlame(Properties p) {super(p);}

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
        super.entityInside(state, level, pos, entity, effectApplier, isPrecise);
        if(entity instanceof Player p) {
            var lookup = level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT);
            int cursesRemoved = removeCurses(lookup, p, EquipmentSlot.HEAD) +
                    removeCurses(lookup, p, EquipmentSlot.CHEST) +
                    removeCurses(lookup, p, EquipmentSlot.LEGS) +
                    removeCurses(lookup, p, EquipmentSlot.FEET) +
                    removeCurses(lookup, p, EquipmentSlot.MAINHAND) +
                    removeCurses(lookup, p, EquipmentSlot.OFFHAND);
            if(cursesRemoved > 0) {
                p.hurt(level.damageSources().magic(), cursesRemoved * 4);
                p.playSound(SoundEvents.SCULK_SHRIEKER_SHRIEK, .6F, 0.7F);
                p.playSound(SoundEvents.TRIDENT_THUNDER.value(), 1F, 0.5F);
                if(level instanceof ServerLevel s) {
                    s.sendParticles(ParticleTypes.LARGE_SMOKE, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, 7 * cursesRemoved, .5, .5, .5, 0);
                    s.sendParticles(ParticleTypes.SOUL, p.getX(), p.getEyeY(), p.getZ(), 7 * cursesRemoved, .25, .25, .25, 0);
                    Utils.awardAdvancement(s.getServer(), (ServerPlayer) p, ADVANCEMENT, "remove_curse");
                } level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
            }
        }
    }
    public static int removeCurses(HolderLookup.RegistryLookup<Enchantment> enchantmentLookup, Player p, EquipmentSlot slot) {
        ItemStack stack = p.getItemBySlot(slot);
        if(EnchantmentHelper.hasTag(stack, EnchantmentTags.CURSE)) {
            ItemEnchantments.Mutable mut = new ItemEnchantments.Mutable(stack.getAllEnchantments(enchantmentLookup));
            mut.removeIf(e -> e.is(EnchantmentTags.CURSE));
            EnchantmentHelper.setEnchantments(stack, mut.toImmutable());
            p.setItemSlot(slot, stack);
            return 1;
        } return 0;
    }
}