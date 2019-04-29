package naturix.divinerpg.events;

import naturix.divinerpg.Config;
import naturix.divinerpg.objects.blocks.BlockMod;
import naturix.divinerpg.registry.ModDimensions;
import naturix.divinerpg.registry.ModItems;
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
    private Item boots = null, body = null, legs = null, helmet = null;

    @SubscribeEvent
    public void onPlayerHurtEvent(LivingHurtEvent evt) {
        if (evt.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) evt.getEntityLiving();

            ItemStack stackBoots = player.inventory.armorInventory.get(0);
            ItemStack stackLegs = player.inventory.armorInventory.get(1);
            ItemStack stackBody = player.inventory.armorInventory.get(2);
            ItemStack stackHelmet = player.inventory.armorInventory.get(3);

            boots = stackBoots != null ? stackBoots.getItem() : null;
            body = stackBody != null ? stackBody.getItem() : null;
            legs = stackLegs != null ? stackLegs.getItem() : null;
            helmet = stackHelmet != null ? stackHelmet.getItem() : null;

            DamageSource s = evt.getSource();

            //Bedrock
            if ((boots == ModItems.bedrockBoots && legs == ModItems.bedrockLegs && body == ModItems.bedrockBody
                    && helmet == ModItems.bedrockHelmet)) {
                if (s.isExplosion()) {
                    evt.setCanceled(true);
                }
            }

            //Ender
            if ((boots == ModItems.enderBoots || boots == ModItems.redEnderBoots || boots == ModItems.yellowEnderBoots
                    || boots == ModItems.greenEnderBoots || boots == ModItems.blueEnderBoots
                    || boots == ModItems.grayEnderBoots)
                    && (legs == ModItems.enderLegs || legs == ModItems.redEnderLegs || legs == ModItems.yellowEnderLegs
                            || legs == ModItems.greenEnderLegs || legs == ModItems.blueEnderLegs
                            || legs == ModItems.grayEnderLegs)
                    && (body == ModItems.enderBody || body == ModItems.redEnderBody || body == ModItems.yellowEnderBody
                            || body == ModItems.greenEnderBody || body == ModItems.blueEnderBody
                            || body == ModItems.grayEnderBody)
                    && (helmet == ModItems.enderHelmet || helmet == ModItems.redEnderHelmet
                            || helmet == ModItems.yellowEnderHelmet || helmet == ModItems.greenEnderHelmet
                            || helmet == ModItems.blueEnderHelmet || helmet == ModItems.grayEnderHelmet)) {
                if (s.isExplosion()) {
                    evt.setCanceled(true);
                }
            }

            //Arlemite
            if (boots == ModItems.arlemiteBoots && legs == ModItems.arlemiteLegs && body == ModItems.arlemiteBody
                    && helmet == ModItems.arlemiteHelmet) {
                if (s.isProjectile() || s.damageType.equals("thrown")) {
                    evt.setAmount(evt.getAmount() * 0.3f);
                }
            }

            //Rupee
            if ((boots == ModItems.rupeeBoots || boots == ModItems.redRupeeBoots || boots == ModItems.yellowRupeeBoots
                    || boots == ModItems.greenRupeeBoots || boots == ModItems.blueRupeeBoots
                    || boots == ModItems.grayRupeeBoots)
                    && (legs == ModItems.rupeeLegs || legs == ModItems.redRupeeLegs || legs == ModItems.yellowRupeeLegs
                            || legs == ModItems.greenRupeeLegs || legs == ModItems.blueRupeeLegs
                            || legs == ModItems.grayRupeeLegs)
                    && (body == ModItems.rupeeBody || body == ModItems.redRupeeBody || body == ModItems.yellowRupeeBody
                            || body == ModItems.greenRupeeBody || body == ModItems.blueRupeeBody
                            || body == ModItems.grayRupeeBody)
                    && (helmet == ModItems.rupeeHelmet || helmet == ModItems.redRupeeHelmet
                            || helmet == ModItems.yellowRupeeHelmet || helmet == ModItems.greenRupeeHelmet
                            || helmet == ModItems.blueRupeeHelmet || helmet == ModItems.grayRupeeHelmet)) {
                if ((s.damageType.equals("mob")) && !s.isProjectile()) {
                    evt.setAmount(evt.getAmount() * 0.3f);
                }
            }

            //Santa
            if (boots == ModItems.santaBoots && legs == ModItems.santaPants && body == ModItems.santaTunic
                    && helmet == ModItems.santaCap) {
                if (player.world.provider.getDimension() == ModDimensions.iceikaDimension.getId()) {
                    evt.setAmount(evt.getAmount() * 0.2f);
                }
            }

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
                EntityPlayer player = event.getHarvester();

                ItemStack stackBoots = player.inventory.armorInventory.get(0);
                ItemStack stackLegs = player.inventory.armorInventory.get(1);
                ItemStack stackBody = player.inventory.armorInventory.get(2);
                ItemStack stackHelmet = player.inventory.armorInventory.get(3);

                boots = stackBoots != null ? stackBoots.getItem() : null;
                body = stackBody != null ? stackBody.getItem() : null;
                legs = stackLegs != null ? stackLegs.getItem() : null;
                helmet = stackHelmet != null ? stackHelmet.getItem() : null;

                // Eden
                if (boots == ModItems.edenBoots && body == ModItems.edenChestplate && legs == ModItems.edenLeggings
                        && helmet == ModItems.edenHelmet) {
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

            ItemStack stackBoots = player.inventory.armorInventory.get(0);
            ItemStack stackLegs = player.inventory.armorInventory.get(1);
            ItemStack stackBody = player.inventory.armorInventory.get(2);
            ItemStack stackHelmet = player.inventory.armorInventory.get(3);

            boots = stackBoots != null ? stackBoots.getItem() : null;
            body = stackBody != null ? stackBody.getItem() : null;
            legs = stackLegs != null ? stackLegs.getItem() : null;
            helmet = stackHelmet != null ? stackHelmet.getItem() : null;

            // Divine
            if (boots == ModItems.divineBoots && body == ModItems.divineBody && legs == ModItems.divineLegs
                    && helmet == ModItems.divineHelmet) {
                player.addVelocity(0, 0.2D, 0);
            }

            // Skythern
            if (boots == ModItems.skythernBoots && body == ModItems.skythernChestplate
                    && legs == ModItems.skythernLeggings && helmet == ModItems.skythernHelmet) {
                player.addVelocity(0, 0.5D, 0);
            }

            // Vethean
            if (body == ModItems.glisteningBody && legs == ModItems.glisteningLegs && boots == ModItems.glisteningBoots
                    && helmet == ModItems.glisteningHood) {
                player.addVelocity(0, 0.2D, 0);
            }
            if (body == ModItems.demonizedBody && legs == ModItems.demonizedLegs && boots == ModItems.demonizedBoots
                    && helmet == ModItems.demonizedHood) {
                player.addVelocity(0, 0.3D, 0);
            }
            if (body == ModItems.tormentedBody && legs == ModItems.tormentedLegs && boots == ModItems.tormentedBoots
                    && helmet == ModItems.tormentedHood) {
                player.addVelocity(0, 0.4D, 0);
            }

        }
    }

    @SubscribeEvent
    public void onLivingHurtEvent(LivingHurtEvent e) {
        if (e.getSource().getTrueSource() != null && e.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) e.getSource().getTrueSource();

            ItemStack stackBoots = player.inventory.armorInventory.get(0);
            ItemStack stackLegs = player.inventory.armorInventory.get(1);
            ItemStack stackBody = player.inventory.armorInventory.get(2);
            ItemStack stackHelmet = player.inventory.armorInventory.get(3);

            boots = stackBoots != null ? stackBoots.getItem() : null;
            body = stackBody != null ? stackBody.getItem() : null;
            legs = stackLegs != null ? stackLegs.getItem() : null;
            helmet = stackHelmet != null ? stackHelmet.getItem() : null;

            DamageSource s = e.getSource();

            // Santa
            if (boots == ModItems.santaBoots && body == ModItems.santaTunic && legs == ModItems.santaPants
                    && helmet == ModItems.santaCap) {
                if ((e.getEntityLiving().world.provider.getDimensionType().getId() == Config.iceikaDimensionId)
                        && ((s.getTrueSource() instanceof EntityPlayer) && !s.isProjectile() && !s.isMagicDamage())) {
                    e.setAmount(e.getAmount() + 6);
                }
            }

            // Halite
            if (boots == ModItems.haliteBoots && body == ModItems.haliteChestplate && legs == ModItems.haliteLeggings
                    && helmet == ModItems.haliteHelmet) {
                if (((s.getTrueSource() instanceof EntityPlayer) && !s.isProjectile() && !s.isMagicDamage())) {
                    e.setAmount(e.getAmount() + 16);
                }
            }

            // Divine
            if (boots == ModItems.divineBoots && body == ModItems.divineBody && legs == ModItems.divineLegs
                    && helmet == ModItems.divineHelmet) {
                if (((s.getTrueSource() instanceof EntityPlayer) && !s.isProjectile() && !s.isMagicDamage())) {
                    e.setAmount(e.getAmount() + 6);
                }
            }

            // Corrupted
            if (body == ModItems.corruptedBody && legs == ModItems.corruptedLegs && boots == ModItems.corruptedBoots
                    && helmet == ModItems.corruptedHelmet) {
                if (((s.getTrueSource() instanceof EntityPlayer) && s.isProjectile())) {
                    e.setAmount(e.getAmount() * 1.2F);
                }
            }

            // Vethean
            if (body == ModItems.glisteningBody && legs == ModItems.glisteningLegs && boots == ModItems.glisteningBoots
                    && helmet == ModItems.glisteningHelmet) {
                if (((s.getTrueSource() instanceof EntityPlayer) && !s.isProjectile() && !s.isMagicDamage())) {
                    e.setAmount(e.getAmount() + 3);
                }
            }
            if (body == ModItems.demonizedBody && legs == ModItems.demonizedLegs && boots == ModItems.demonizedBoots
                    && helmet == ModItems.demonizedHelmet) {
                if (((s.getTrueSource() instanceof EntityPlayer) && !s.isProjectile() && !s.isMagicDamage())) {
                    e.setAmount(e.getAmount() + 6);
                }
            }
            if (body == ModItems.tormentedBody && legs == ModItems.tormentedLegs && boots == ModItems.tormentedBoots
                    && helmet == ModItems.tormentedHelmet) {
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

            ItemStack stackBoots = player.inventory.armorInventory.get(0);
            ItemStack stackLegs = player.inventory.armorInventory.get(1);
            ItemStack stackBody = player.inventory.armorInventory.get(2);
            ItemStack stackHelmet = player.inventory.armorInventory.get(3);

            boots = stackBoots != null ? stackBoots.getItem() : null;
            body = stackBody != null ? stackBody.getItem() : null;
            legs = stackLegs != null ? stackLegs.getItem() : null;
            helmet = stackHelmet != null ? stackHelmet.getItem() : null;

            DamageSource s = e.getSource();

            // Kraken and Aquastrive
            if ((boots == ModItems.aquastriveBoots && body == ModItems.aquastriveBody && legs == ModItems.aquastriveLegs
                    && helmet == ModItems.aquastriveHelmet)
                    || (boots == ModItems.krakenBoots && body == ModItems.krakenBody && legs == ModItems.krakenLegs
                            && helmet == ModItems.krakenHelmet)) {
                if (s.equals(DamageSource.DROWN)) {
                    e.setCanceled(true);
                }
            }

            // Uvite
            if (boots == ModItems.apalachiaBoots && legs == ModItems.apalachiaLeggings
                    && body == ModItems.apalachiaChestplate && helmet == ModItems.apalachiaHelmet) {
                if (s.equals(DamageSource.CACTUS) || s.equals(DamageSource.FALLING_BLOCK)
                        || s.equals(DamageSource.ANVIL) || s.equals(DamageSource.IN_WALL)
                        || s.equals(Utils.trapSource)) {
                    e.setCanceled(true);
                }
            }

            // Wither Reaper
            if (boots == ModItems.witherReaperBoots && legs == ModItems.witherReaperLegs
                    && body == ModItems.witherReaperBody && helmet == ModItems.witherReaperHelmet) {
                if (s.equals(DamageSource.WITHER)) {
                    e.setCanceled(true);
                }
            }

            // Jungle
            if (boots == ModItems.jungleBoots && legs == ModItems.jungleLegs && body == ModItems.jungleBody
                    && helmet == ModItems.jungleHelmet) {
                if (s.equals(DamageSource.MAGIC)) {
                    e.setCanceled(true);
                }
            }
        }
    }
}