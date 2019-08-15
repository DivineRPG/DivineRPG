package naturix.divinerpg.events;

import naturix.divinerpg.Config;
import naturix.divinerpg.objects.blocks.BlockMod;
import naturix.divinerpg.registry.ModDimensions;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.FullSetArmorHelper;
import naturix.divinerpg.utils.Reference;
import naturix.divinerpg.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class EventArmorSet {

    @SubscribeEvent
    public void onPlayerHurtEvent(LivingHurtEvent evt) {
        if (evt.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) evt.getEntityLiving();

            FullSetArmorHelper armorHelper = new FullSetArmorHelper(player);
            if (!armorHelper.isFullEquipped()){
                return;
            }

            DamageSource s = evt.getSource();

            if (armorHelper.isBedrock()){
                if (s.isExplosion())
                    evt.setCanceled(true);
            }

            if (armorHelper.isEnder()) {
                if (s.isExplosion()) {
                    evt.setCanceled(true);
                }
            }

            //Arlemite
            if (armorHelper.isArlemit()) {
                if (s.isProjectile()
                        || s.damageType.equals("thrown")) {
                    evt.setAmount(evt.getAmount() * 0.3f);
                }
            }

            //Rupee
            if (armorHelper.isRupee()) {
                if ((s.damageType.equals("mob")) && !s.isProjectile()) {
                    evt.setAmount(evt.getAmount() * 0.3f);
                }
            }

            //Santa
            if (armorHelper.isSanta()) {
                if (player.world.provider.getDimension() == ModDimensions.iceikaDimension.getId()) {
                    evt.setAmount(evt.getAmount() * 0.2f);
                }
            }

            Item body = armorHelper.getBody();
            Item legs = armorHelper.getLegs();
            Item boots = armorHelper.getBoots();
            Item helmet = armorHelper.getHelmet();

            //Vethean
            if (body == ModItems.degradedBody && legs == ModItems.degradedLegs && boots == ModItems.degradedBoots) {
                if ((helmet == ModItems.degradedHelmet && !s.isProjectile() && !s.isMagicDamage())
                        || (helmet == ModItems.degradedMask && s.isProjectile() && !s.isMagicDamage())
                        || (helmet == ModItems.degradedHood && s.isMagicDamage()))
                    evt.setAmount(evt.getAmount() * 0.82f);
            }
            if (body == ModItems.finishedBody && legs == ModItems.finishedLegs && boots == ModItems.finishedBoots) {
                if ((helmet == ModItems.finishedHelmet && !s.isProjectile() && !s.isMagicDamage())
                        || (helmet == ModItems.finishedMask && s.isProjectile() && !s.isMagicDamage())
                        || (helmet == ModItems.finishedHood && s.isMagicDamage()))
                    evt.setAmount(evt.getAmount() * 0.773f);
            }
            if (body == ModItems.glisteningBody && legs == ModItems.glisteningLegs
                    && boots == ModItems.glisteningBoots) {
                if ((helmet == ModItems.glisteningHelmet && !s.isProjectile() && !s.isMagicDamage())
                        || (helmet == ModItems.glisteningMask && s.isProjectile() && !s.isMagicDamage())
                        || (helmet == ModItems.glisteningHood && s.isMagicDamage()))
                    evt.setAmount(evt.getAmount() * 0.7f);
            }
            if (body == ModItems.demonizedBody && legs == ModItems.demonizedLegs && boots == ModItems.demonizedBoots) {
                if ((helmet == ModItems.demonizedHelmet && !s.isProjectile() && !s.isMagicDamage())
                        || (helmet == ModItems.demonizedMask && s.isProjectile() && !s.isMagicDamage())
                        || (helmet == ModItems.demonizedHood && s.isMagicDamage()))
                    evt.setAmount(evt.getAmount() * 0.625f);
            }
            if (body == ModItems.tormentedBody && legs == ModItems.tormentedLegs && boots == ModItems.tormentedBoots) {
                if ((helmet == ModItems.tormentedHelmet && !s.isProjectile() && !s.isMagicDamage())
                        || (helmet == ModItems.tormentedMask && s.isProjectile() && !s.isMagicDamage())
                        || (helmet == ModItems.tormentedHood && s.isMagicDamage()))
                    evt.setAmount(evt.getAmount() * 0.348f);
            }
        }
    }

    @SubscribeEvent
    public void onBlockDrops(HarvestDropsEvent event) {
        if (event.getState().getBlock() != null && event.getState().getBlock() instanceof BlockMod
                && ((BlockMod) event.getState().getBlock()).isTwilightOre()) {
            if (event.getHarvester() != null && event.getHarvester() instanceof EntityPlayer) {

                FullSetArmorHelper armorHelper = new FullSetArmorHelper(event.getHarvester());

                // Eden
                if (armorHelper.isEden()) {
                    if (!event.isSilkTouching()) {
                        ItemStack fragment = event.getDrops().get(0);
                        event.getDrops().add(fragment.copy());
                        event.getDrops().add(fragment.copy());
                        event.getDrops().add(fragment.copy());
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onJump(LivingJumpEvent event) {
        if (event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntityLiving();

            FullSetArmorHelper armorHelper = new FullSetArmorHelper(player);

            // Divine or Vethea
            if (armorHelper.isDivine()
                    || armorHelper.isGlistening(ModItems.glisteningHood)) {
                player.addVelocity(0, 0.2D, 0);
            }

            // Skythern
            if (armorHelper.isSkythern()) {
                player.addVelocity(0, 0.5D, 0);
            }

            // Vethean
            if (armorHelper.isDemonised(ModItems.demonizedHood)) {
                player.addVelocity(0, 0.3D, 0);
            }
            if (armorHelper.isTormented(ModItems.tormentedHood)) {
                player.addVelocity(0, 0.4D, 0);
            }

        }
    }

    @SubscribeEvent
    public void onLivingHurtEvent(LivingHurtEvent e) {
        if (e.getSource().getTrueSource() != null && e.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) e.getSource().getTrueSource();

            FullSetArmorHelper armorHelper = new FullSetArmorHelper(player);

            DamageSource s = e.getSource();

            // Santa or Divine or Demonized
            if (armorHelper.isSanta()
                || armorHelper.isDivine()
                || armorHelper.isDemonised(null)) {
                if ((e.getEntityLiving().world.provider.getDimensionType().getId() == Config.iceikaDimensionId)
                        && ((s.getTrueSource() instanceof EntityPlayer) && !s.isProjectile() && !s.isMagicDamage())) {
                    e.setAmount(e.getAmount() + 6);
                }
            }

            // Halite
            if (armorHelper.isHalite()) {
                if (((s.getTrueSource() instanceof EntityPlayer) && !s.isProjectile() && !s.isMagicDamage())) {
                    e.setAmount(e.getAmount() + 16);
                }
            }

            // Corrupted
            if (armorHelper.isCorrupted()) {
                if (((s.getTrueSource() instanceof EntityPlayer) && s.isProjectile())) {
                    e.setAmount(e.getAmount() * 1.2F);
                }
            }

            // Vethean
            if (armorHelper.isGlistening(null)) {
                if (((s.getTrueSource() instanceof EntityPlayer) && !s.isProjectile() && !s.isMagicDamage())) {
                    e.setAmount(e.getAmount() + 3);
                }
            }
            if (armorHelper.isTormented(null)) {
                if (((s.getTrueSource() instanceof EntityPlayer) && !s.isProjectile() && !s.isMagicDamage())) {
                    e.setAmount(e.getAmount() + 9);
                }
            }
        }
    }

    @SubscribeEvent
    public void onPlayerAttackEvent(LivingAttackEvent e) {
        if (e.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) e.getEntityLiving();
            FullSetArmorHelper armorHelper = new FullSetArmorHelper(player);

            DamageSource s = e.getSource();

            // Kraken and Aquastrive
            if (armorHelper.isAquastrive()
                    || (armorHelper.isKraken())) {
                if (s.equals(DamageSource.DROWN)) {
                    e.setCanceled(true);
                }
            }

            // Uvite
            if (armorHelper.isUvite()) {
                if (s.equals(DamageSource.CACTUS)
                        || s.equals(DamageSource.FALLING_BLOCK)
                        || s.equals(DamageSource.ANVIL)
                        || s.equals(DamageSource.IN_WALL)
                        || s.equals(Utils.trapSource)) {
                    e.setCanceled(true);
                }
            }

            // Wither Reaper
            if (armorHelper.isWither() ) {
                if (s.equals(DamageSource.WITHER)) {
                    e.setCanceled(true);
                }
            }

            // Jungle
            if (armorHelper.isJungle()) {
                if (s.equals(DamageSource.MAGIC)) {
                    e.setCanceled(true);
                }
            }
        }
    }
}