package divinerpg.blocks.twilight;

import divinerpg.blocks.base.Fire;
import divinerpg.utils.Utils;
import net.minecraft.advancements.triggers.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.CommonHooks;

import java.util.List;

import static divinerpg.DivineRPG.MODID;
import static net.minecraft.core.registries.Registries.ENCHANTMENT;
import static net.minecraft.sounds.SoundEvents.ENCHANTMENT_TABLE_USE;

public class EnchantedFlame extends Fire {
    public static final Identifier ADVANCEMENT = Identifier.fromNamespaceAndPath(MODID, "twilight/burning_enchanter");
    public EnchantedFlame(Properties p) {super(p);}
    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
        super.entityInside(state, level, pos, entity, effectApplier, isPrecise);
        if(entity instanceof Player p) {
            var lookup = level.registryAccess().lookupOrThrow(ENCHANTMENT);
            int enchanted = 0, maxEnchantments = p.experienceLevel / 15;
            if(enchanted < maxEnchantments) enchanted += enchant(lookup, p, EquipmentSlot.MAINHAND);
            if(enchanted < maxEnchantments) enchanted += enchant(lookup, p, EquipmentSlot.OFFHAND);
            if(enchanted < maxEnchantments) enchanted += enchant(lookup, p, EquipmentSlot.HEAD);
            if(enchanted < maxEnchantments) enchanted += enchant(lookup, p, EquipmentSlot.CHEST);
            if(enchanted < maxEnchantments) enchanted += enchant(lookup, p, EquipmentSlot.LEGS);
            if(enchanted < maxEnchantments) enchanted += enchant(lookup, p, EquipmentSlot.FEET);
            if(enchanted > 0) {
                p.playSound(ENCHANTMENT_TABLE_USE, 1F, 0.7F);
                if(level instanceof ServerLevel s) {
                    s.sendParticles(ParticleTypes.LARGE_SMOKE, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, 5 * enchanted, .5, .5, .5, 0);
                    s.sendParticles(ParticleTypes.SOUL, p.getX(), p.getEyeY(), p.getZ(), 3 * enchanted, .25, .25, .25, 0);
                    Utils.awardAdvancement(s.getServer(), (ServerPlayer) p, ADVANCEMENT, "use_enchanted_flame");
                } level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
            }
        }
    }
    public static int enchant(Registry<Enchantment> enchantments, Player p, EquipmentSlot slot) {
        ItemStack stack = p.getItemBySlot(slot);
        if(!stack.isEmpty() && stack.isEnchantable()) {
            var tag = enchantments.get(EnchantmentTags.IN_ENCHANTING_TABLE);
            if(tag.isPresent()) {
                List<EnchantmentInstance> list = EnchantmentHelper.selectEnchantment(p.getRandom(), stack, 30, tag.get().stream());
                if(!list.isEmpty()) {
                    p.onEnchantmentPerformed(stack, 15);
                    stack = stack.getItem().applyEnchantments(stack, list);
                    CommonHooks.onPlayerEnchantItem(p, stack, list);
                    if(!EnchantmentHelper.hasTag(stack, EnchantmentTags.CURSE)) {
                        tag = enchantments.get(EnchantmentTags.CURSE);
                        if(tag.isPresent()) {
                            list = EnchantmentHelper.selectEnchantment(p.getRandom(), stack, 30, tag.get().stream());
                            if(!list.isEmpty()) {
                                stack = stack.getItem().applyEnchantments(stack, List.of(list.get(p.getRandom().nextInt(list.size()))));
                                CommonHooks.onPlayerEnchantItem(p, stack, list);
                            }
                        }
                    } p.awardStat(Stats.ENCHANT_ITEM);
                    if(p instanceof ServerPlayer s) CriteriaTriggers.ENCHANTED_ITEM.trigger(s, stack, 15);
                    p.setItemSlot(slot, stack);
                    return 1;
                }
            }
        } return 0;
    }
}