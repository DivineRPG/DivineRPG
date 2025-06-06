package divinerpg.blocks.twilight;

import divinerpg.DivineRPG;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.Utils;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.*;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.CommonHooks;

import java.util.List;

public class MortumEmbers extends TwilightFire {
    public static final ResourceLocation ADVANCEMENT = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "twilight/curses");
    public MortumEmbers() {
        super(25F);
    }
    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        super.entityInside(state, level, pos, entity);
        if(entity instanceof Player p) {
            var lookup = level.registryAccess().registryOrThrow(Registries.ENCHANTMENT);
            int cursed = curse(lookup, p, EquipmentSlot.MAINHAND)
                    + curse(lookup, p, EquipmentSlot.OFFHAND)
                    + curse(lookup, p, EquipmentSlot.HEAD)
                    + curse(lookup, p, EquipmentSlot.CHEST)
                    + curse(lookup, p, EquipmentSlot.LEGS)
                    + curse(lookup, p, EquipmentSlot.FEET);
            if(cursed > 0) {
                p.playSound(SoundRegistry.DEEP_LAUGH.get(), 0.6F, 0.8F);
                p.playSound(SoundEvents.SCULK_SHRIEKER_SHRIEK, .6F, 0.7F);
                if(level instanceof ServerLevel s) {
                    s.sendParticles(ParticleTypes.LARGE_SMOKE, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, 9 * cursed, .5, .5, .5, 0);
                    s.sendParticles(ParticleTypes.SOUL, p.getX(), p.getEyeY(), p.getZ(), 5 * cursed, .25, .25, .25, 0);
                    Utils.awardAdvancement(s.getServer(), (ServerPlayer) p, ADVANCEMENT, "use_mortum_embers");
                } level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
            }
        }
    }
    public static int curse(Registry<Enchantment> enchantments, Player p, EquipmentSlot slot) {
        ItemStack stack = p.getItemBySlot(slot);
        if(!stack.isEmpty() && stack.isEnchantable() && !EnchantmentHelper.hasTag(stack, EnchantmentTags.CURSE)) {
            var tag = enchantments.getTag(EnchantmentTags.CURSE);
            if(tag.isPresent()) {
                List<EnchantmentInstance> list = EnchantmentHelper.selectEnchantment(p.getRandom(), stack, 30, tag.get().stream());
                if(!list.isEmpty()) {
                    stack = stack.getItem().applyEnchantments(stack, list);
                    CommonHooks.onPlayerEnchantItem(p, stack, list);
                    p.awardStat(Stats.ENCHANT_ITEM);
                    if(p instanceof ServerPlayer s) CriteriaTriggers.ENCHANTED_ITEM.trigger(s, stack, 0);
                    p.setItemSlot(slot, stack);
                    return 1;
                }
            }
        } return 0;
    }
}
